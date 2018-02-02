package com.magicbeans.happygo.service.impl;

import com.magicbeans.happygo.entity.Order;
import com.magicbeans.happygo.entity.OrderProduct;
import com.magicbeans.happygo.entity.ShopCar;
import com.magicbeans.happygo.mapper.OrderMapper;
import com.magicbeans.happygo.mapper.OrderProductMapper;
import com.magicbeans.happygo.mapper.ShopCarMapper;
import com.magicbeans.happygo.service.IOrderService;
import com.magicbeans.base.BaseServiceImp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
}
