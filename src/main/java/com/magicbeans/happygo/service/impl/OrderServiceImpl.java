package com.magicbeans.happygo.service.impl;

import com.magicbeans.happygo.entity.*;
import com.magicbeans.base.Pages;
import com.magicbeans.happygo.entity.Order;
import com.magicbeans.happygo.entity.OrderProduct;
import com.magicbeans.happygo.entity.ShopCar;
import com.magicbeans.happygo.exception.InterfaceCommonException;
import com.magicbeans.happygo.mapper.*;
import com.magicbeans.happygo.service.IOrderService;
import com.magicbeans.base.BaseServiceImp;
import com.magicbeans.happygo.util.CommonUtil;
import com.magicbeans.happygo.util.RoleConstant;
import com.magicbeans.happygo.util.StatusConstant;
import com.magicbeans.happygo.vo.OrderDetailVO;
import com.magicbeans.happygo.vo.OrderListVO;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author null123
 * @since 2018-02-02
 */
@Service
@Transactional
public class OrderServiceImpl extends BaseServiceImp<OrderMapper, Order> implements IOrderService {

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private OrderProductMapper orderProductMapper;
    @Resource
    private ShopCarMapper shopCarMapper;
    @Resource
    private IUserMapper userMapper;
    @Resource
    private UserScoreMapper userScoreMapper;
    @Resource
    private IncomeDetailMapper incomeDetailMapper;

    @Override
    public void addOrder(Order order, List<String> shopCarIdList) {
        orderMapper.insert(order);
        List<ShopCar> shopCars = shopCarMapper.batchQueryShopCar(shopCarIdList);
        for (ShopCar car : shopCars) {
            OrderProduct op = new OrderProduct();
            op.setNumber(car.getNumber());
            op.setOrderId(order.getId());
            op.setProductId(car.getProductId());
            orderProductMapper.insert(op);
        }
        shopCarMapper.deleteBatchIds(shopCarIdList);
    }

    @Override
    public BigDecimal countOrderPrice(String orderId) {
        // TODO: 2018/2/2 0002  当前因为运费并未确认其需求，所以当前订单的价格不包含运费
        return orderMapper.countOrderPrice(orderId);
    }

    @Override
    public void paySuccess(Integer payMethod,Integer orderId,BigDecimal price) {

    }

    @Override
    public void underPay(Order order) {
        //查询订单相关信息
        List<OrderProduct> orderProductList = orderProductMapper.queryOrderProductByOrder(order.getId());
        BigDecimal count = new BigDecimal(0.0);
        if (null != orderProductList && orderProductList.size() > 0){
            for (OrderProduct orderProduct : orderProductList) {
                count = count.add(orderProduct.getProduct().getPrice().multiply(new BigDecimal(orderProduct.getNumber().toString())));
                orderProduct.setPrice(orderProduct.getProduct().getPrice());
                orderProduct.setProductName(orderProduct.getProduct().getName());
                orderProduct.setProductCover(orderProduct.getProduct().getCoverImg());
                orderProduct.setProductDetail(JSONObject.fromObject(orderProduct.getProduct()).toString());
                orderProduct.setIntegral(orderProduct.getProduct().getIntegral());
                orderProduct.setIsIntegral(orderProduct.getProduct().getIsIntegral());
                orderProduct.setTicket(orderProduct.getProduct().getTicket());
                // 订单状态锁定
                orderProductMapper.updateById(orderProduct);
            }
        }
        // 更新状态
        order.setStatus(StatusConstant.ORDER_WAITING_PAY);
        order.setPayMethod(StatusConstant.PAY_METHOD_UNDER_LINE);
//        order.setAdminOk(0);
        order.setPrice(count);
        // TODO: 2018/2/5 0005  订单的运费 因业务需求不定，暂不做处理，如果确定后，更新设值 freight 字段即可
        orderMapper.updateById(order);
    }

    @Override
    public void uploadBankImg(String orderId,String img){
        Order order = orderMapper.selectById(orderId);
        if(null == order){
            throw new InterfaceCommonException(StatusConstant.OBJECT_NOT_EXIST,"订单不存在");
        }
        if(!StatusConstant.ORDER_WAITING_PAY.equals(order.getStatus())){
            throw new InterfaceCommonException(StatusConstant.Fail_CODE,"订单状态异常");
        }
        if(!StatusConstant.PAY_METHOD_UNDER_LINE.equals(order.getPayMethod())){
            throw new InterfaceCommonException(StatusConstant.Fail_CODE,"订单的支付方式错误");
        }
        Order t = new Order();
        t.setStatus(StatusConstant.ORDER_PAID);
        t.setBankImg(img);
        t.setId(orderId);
        t.setAdminOk(0);
        orderMapper.updateById(t);
    }

    @Override
    public void confirmUnderOrder(String orderId, String currentUserId, Integer status,SystemConfig config) {
        if(status != 1 && status != 2){
            throw new InterfaceCommonException(StatusConstant.ARGUMENTS_EXCEPTION,"参数错误");
        }
        Order order = orderMapper.selectById(orderId);
        if(null == order){
            throw new InterfaceCommonException(StatusConstant.OBJECT_NOT_EXIST,"订单不存在");
        }
        if(!StatusConstant.ORDER_PAID.equals(order.getStatus())){
            throw new InterfaceCommonException(StatusConstant.Fail_CODE,"订单状态异常");
        }
        if(!StatusConstant.PAY_METHOD_UNDER_LINE.equals(order.getPayMethod())){
            throw new InterfaceCommonException(StatusConstant.Fail_CODE,"订单的支付方式错误");
        }
        if(0 != order.getAdminOk() || CommonUtil.isEmpty(order.getBankImg())){
            throw new InterfaceCommonException(StatusConstant.Fail_CODE,"订单未上传流水明细");
        }
        Order to = new Order();
        to.setStatus(StatusConstant.ORDER_WAITING_SEND);
        to.setId(orderId);
        to.setAdminOk(status);
        to.setAdminId(currentUserId);
        orderMapper.updateById(to);
        // // 确认付款，
        if(1 == status){
            User user = userMapper.selectById(order.getUserId()); // 购买者用户
            List<OrderProduct> orderProducts = orderProductMapper.queryOrderProduct(orderId);
            // 获取用户的上一级分销 分销提成
            User parentUser = null;
            User t = null;
            User th = null;
            if (null != user.getParentId()) {
                parentUser = userMapper.selectById(user.getParentId()); // 一级分销者
                if(null != parentUser.getParentId()){
                    t = userMapper.selectById(parentUser.getParentId()); // 二级分销者
                    if(null != t.getParentId()){
                        th = userMapper.selectById(parentUser.getParentId()); // 三级分销者
                    }
                }
            }

            if(null != orderProducts && orderProducts.size() > 0){
                for (OrderProduct product : orderProducts) {
                    //计算积分 开始
                    if(null != product.getIsIntegral() && 1 == product.getIsIntegral() && null != product.getIntegral()
                            && product.getIntegral() > 0){
                        // 计算自身积分
                        UserScore selfScore = countIncome(product, user, 0, config);
                        if(null != selfScore){
                            userScoreMapper.insert(selfScore);
                        }
                        if(null != parentUser){
                            // 计算一级分销
                            UserScore userScore = countIncome(product, parentUser, 1, config);
                            if(null != userScore){
                                userScoreMapper.insert(userScore);
                            }
                        }
                        if(null != t){
                            UserScore userScore = countIncome(product, parentUser, 1, config);
                            if(null != userScore){
                                userScoreMapper.insert(userScore);
                            }
                        }
                        if(null != th){
                            UserScore userScore = countIncome(product, parentUser, 1, config);
                            if(null != userScore){
                                userScoreMapper.insert(userScore);
                            }
                        }
                    }
                    // 计算积分 结束
                    // 计算购买商品的欢喜券开始
                    if(RoleConstant.AGENT_SUPPER_MEMBERS.equals(user.getRoleId())){
                        // 本身的欢喜券
                        IncomeDetail incomeDetail = getIncomeDetail(orderId,user, user, product);
                        incomeDetailMapper.insert(incomeDetail);
                    }
                    if(null != parentUser){
                        // 计算一级分销的欢喜券
                        if(RoleConstant.AGENT_SUPPER_MEMBERS.equals(parentUser.getRoleId())){
                            IncomeDetail incomeDetail = getIncomeDetail(orderId,user,parentUser, product);
                            incomeDetailMapper.insert(incomeDetail);
                        }
                    }
                    // 计算购买商品的欢喜券结束
                }
            }
        }
        // 确认付款
    }

    private IncomeDetail getIncomeDetail(String orderId, User fromUser,User toUser, OrderProduct product) {
        IncomeDetail incomeDetail = new IncomeDetail();
        incomeDetail.setFromUserId(fromUser.getId());
        incomeDetail.setToUserId(toUser.getId());
        incomeDetail.setType(0);
        incomeDetail.setProductId(product.getProductId());
        incomeDetail.setProductName(product.getProductName());
        incomeDetail.setPrice(product.getPrice());
        incomeDetail.setNumber(product.getNumber());
        incomeDetail.setOrderId(orderId);
        incomeDetail.setProductCoverImg(product.getProductCover());
        incomeDetail.setBigDecimal(product.getTicket());
        return incomeDetail;
    }

    /**
     * 分销者的提成计算
     */
    private UserScore countIncome(OrderProduct p, User targetUser, Integer levelType, SystemConfig systemConfig){

        int score = 0;
        UserScore userScore = null;
        if(RoleConstant.REGULAR_MEMBERS.equals(targetUser.getRoleId())){
            // 普通会员
            // 暂无任何权益
        }
        else if(RoleConstant.AGENT_REGULAR_MEMBERS.equals(targetUser.getRoleId())){
            // 代理商普通会员
            // 权益：本身 商品积分、分销1级积分
            // 当前计算分销一级积分
            if(StatusConstant.YES.equals(p.getIsIntegral()) && null != p.getIntegral() && 1 == levelType){
                score = (int)Math.floor(p.getIntegral() * systemConfig.getOneRatio() / 100);
            }

            if(StatusConstant.YES.equals(p.getIsIntegral()) && null != p.getIntegral() && 0 == levelType){
                score = p.getIntegral();
            }

        }
        else if(RoleConstant.AGENT_SENIOR_MEMBERS.equals(targetUser.getRoleId())){
            // 代理商高级会员
            if(StatusConstant.YES.equals(p.getIsIntegral()) && null != p.getIntegral()){
                if(1 == levelType){
                    score = (int)Math.floor(p.getIntegral() * systemConfig.getOneRatio() / 100);
                }
                if(2 == levelType){
                    score = (int)Math.floor(p.getIntegral() * systemConfig.getTwoRatio() / 100);
                }
                if( 0 == levelType){
                    score = p.getIntegral();
                }
            }
        }
        else if(RoleConstant.AGENT_VIP_MEMBERS.equals(targetUser.getRoleId()) ||
                RoleConstant.AGENT_SUPPER_MEMBERS.equals(targetUser.getRoleId())){
            // 代理商VIP会员
            if(StatusConstant.YES.equals(p.getIsIntegral()) && null != p.getIntegral()){
                if(1 == levelType){
                    score = (int)Math.floor(p.getIntegral() * systemConfig.getOneRatio() / 100);
                }
                else if(2 == levelType){
                    score = (int)Math.floor(p.getIntegral() * systemConfig.getTwoRatio() / 100);
                }
                else if( 3 == levelType){
                    score = (int)Math.floor(p.getIntegral() * systemConfig.getThreeRatio() / 100);
                }
                else if(0 == levelType){
                    score = p.getIntegral();
                }
            }
        }
        if(score > 0){
            userScore = new UserScore();
            userScore.setIsAdd(StatusConstant.YES);
            userScore.setOrderId(p.getOrderId());
            userScore.setUserId(targetUser.getId());
            userScore.setScore(score);
            userScore.setProductName(p.getProductName());
            userScore.setProductCoverImg(p.getProductCover());
            userScore.setNumber(p.getNumber());
            userScore.setPrice(p.getPrice());
            userScore.setProductId(p.getProductId());
        }
        return userScore;
    }

    @Override
    public List<OrderListVO> getOrderList(String userId, Integer status, Integer pageNO, Integer pageSize) {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("status",status);
        map.put("limit",(pageNO - 1) * pageSize);
        map.put("limitSize",pageSize);
        List<OrderListVO> voList = orderMapper.queryOrderList(map);
        if(null != voList && voList.size() > 0){
            for (OrderListVO order : voList) {
                if(StatusConstant.ORDER_WAITING_PAY.equals(order.getStatus()) || StatusConstant.ORDER_CANCEL.equals(order.getStatus())){
                    // 未支付的订单，数据读取实时数据
                    BigDecimal price = new BigDecimal(0.0);
                    if(null != order.getProducts()){
                        for (OrderProduct orderProduct : order.getProducts()) {
                            orderProduct.setPrice(1 == orderProduct.getProduct().getIsPromotion() ?
                                    orderProduct.getProduct().getPromotionPrice() : orderProduct.getProduct().getPrice());
                            orderProduct.setProductCover(orderProduct.getProduct().getCoverImg());
                            orderProduct.setProductName(orderProduct.getProduct().getName());
                            price = price.add(orderProduct.getPrice().multiply(new BigDecimal(orderProduct.getNumber().toString())));
                        }
                    }
                    order.setPrice(price);
                }
            }
        }
        return voList;
    }

    @Override
    public OrderDetailVO getOrderById(String orderId) {
        OrderDetailVO detail = orderMapper.queryOrderDetail(orderId);
        if(null == detail){
            throw new InterfaceCommonException(StatusConstant.OBJECT_NOT_EXIST,"订单不存在");
        }
        List<OrderProduct> orderProductList = orderProductMapper.queryOrderProduct(orderId);
        if(null != orderProductList && orderProductList.size() > 0){
            if(StatusConstant.ORDER_WAITING_PAY.equals(detail.getStatus()) || StatusConstant.ORDER_CANCEL.equals(detail.getStatus())){
                BigDecimal price = new BigDecimal(0.0);
                for (OrderProduct product : orderProductList) {
                    product.setProductName(product.getProduct().getName());
                    product.setProductCover(product.getProduct().getCoverImg());
                    product.setPrice(1 == product.getProduct().getIsPromotion() ?
                        product.getProduct().getPromotionPrice() : product.getProduct().getPrice());
                    price = price.add(product.getPrice().multiply(new BigDecimal(product.getNumber().toString())));
                }
                detail.setPrice(price);
            }
            detail.setOrderProducts(orderProductList);
        }
        return detail;
    }

    /**
     * 后台订单列表
     * @param pages
     * @param map
     * @return
     */
    @Override
    public Pages<Order> list(Pages pages, Map<String, Object> map) {
        int count = orderMapper.listCount(map);
        pages.setTotal(count);
        if (count > 0) {
            pages.setCurrent(pages.getCurrent()-1);
            map.put("pages",pages);
            pages.setRecords(orderMapper.list(map));
        }
        return pages;
    }

    @Override
    public void refundOrder(String orderId) {
        Order order = orderMapper.selectById(orderId);
        if(null == order){
            throw new InterfaceCommonException(StatusConstant.OBJECT_NOT_EXIST,"订单不存在");
        }
        if(!StatusConstant.ORDER_REFUND.equals(order.getStatus())){
            throw new InterfaceCommonException(StatusConstant.OBJECT_NOT_EXIST,"订单状态错误");
        }
        Order o = new Order();
        o.setStatus(StatusConstant.ORDER_FINISHED);
        o.setId(orderId);
        orderMapper.updateById(o);
        // 逻辑删除订单相关收益、积分信息
        // 清除收益
        List<IncomeDetail> incomeDetails = incomeDetailMapper.queryIncomeDetailByOrder(orderId);
        if(null != incomeDetails && incomeDetails.size() > 0){
            for (IncomeDetail incomeDetail : incomeDetails) {
                incomeDetail.setIsValid(StatusConstant.NO);
                incomeDetailMapper.updateById(incomeDetail);
            }
        }
        // 清除积分
        List<UserScore> userScoreList = userScoreMapper.queryUserScoreByOrder(orderId);
        if(null != userScoreList && userScoreList.size() > 0){
            for (UserScore userScore : userScoreList) {
                userScore.setIsValid(StatusConstant.NO);
                userScoreMapper.updateById(userScore);
            }
        }
    }
}
