package com.magicbeans.happygo.service.impl;

import com.magicbeans.base.Pages;
import com.magicbeans.happygo.entity.Order;
import com.magicbeans.happygo.entity.OrderProduct;
import com.magicbeans.happygo.entity.ShopCar;
import com.magicbeans.happygo.exception.InterfaceCommonException;
import com.magicbeans.happygo.mapper.AddressMapper;
import com.magicbeans.happygo.mapper.OrderMapper;
import com.magicbeans.happygo.mapper.OrderProductMapper;
import com.magicbeans.happygo.mapper.ShopCarMapper;
import com.magicbeans.happygo.service.IOrderService;
import com.magicbeans.base.BaseServiceImp;
import com.magicbeans.happygo.util.CommonUtil;
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
    private AddressMapper addressMapper;

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
                count.add(orderProduct.getProduct().getPrice().multiply(new BigDecimal(orderProduct.getNumber().toString())));
                orderProduct.setPrice(orderProduct.getProduct().getPrice());
                orderProduct.setProductName(orderProduct.getProduct().getName());
                orderProduct.setProductCover(orderProduct.getProduct().getCoverImg());
                orderProduct.setProductDetail(JSONObject.fromObject(orderProduct.getProduct()).toString());
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
    public void confirmUnderOrder(String orderId, String currentUserId, Integer status) {
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
        Order t = new Order();
        t.setStatus(StatusConstant.ORDER_PAID);
        t.setId(orderId);
        t.setAdminOk(status);
        t.setAdminId(currentUserId);
        orderMapper.updateById(t);
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
                if(StatusConstant.ORDER_WAITING_PAY.equals(order.getStatus())){
                    // 未支付的订单，数据读取实时数据
                    BigDecimal price = new BigDecimal(0.0);
                    if(null != order.getProducts()){
                        for (OrderProduct orderProduct : order.getProducts()) {
                            orderProduct.setPrice(1 == orderProduct.getProduct().getIsPromotion() ?
                                    orderProduct.getProduct().getPromotionPrice() : orderProduct.getProduct().getPrice());
                            orderProduct.setProductCover(orderProduct.getProduct().getCoverImg());
                            orderProduct.setProductName(orderProduct.getProduct().getName());
                            price.add(orderProduct.getPrice().multiply(new BigDecimal(orderProduct.getNumber().toString())));
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
            if(StatusConstant.ORDER_WAITING_PAY.equals(detail.getStatus())){
                BigDecimal price = new BigDecimal(0.0);
                for (OrderProduct product : orderProductList) {
                    product.setProductName(product.getProduct().getName());
                    product.setProductCover(product.getProduct().getCoverImg());
                    product.setPrice(1 == product.getProduct().getIsPromotion() ?
                        product.getProduct().getPromotionPrice() : product.getProduct().getPrice());
                    price.add(product.getPrice().multiply(new BigDecimal(product.getNumber().toString())));
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
        return null;
    }
}
