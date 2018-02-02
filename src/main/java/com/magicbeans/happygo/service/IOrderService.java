package com.magicbeans.happygo.service;

import com.magicbeans.happygo.entity.Order;
import com.magicbeans.base.BaseService;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 订单 服务类
 * </p>
 *
 * @author null123
 * @since 2018-02-02
 */
public interface IOrderService extends BaseService<Order> {


    void addOrder(Order order, List<String> shopCarIdList);

    /**
     * 统计订单的总价格
     * @param orderId
     * @return
     */
    BigDecimal countOrderPrice(String orderId);


    /**
     * 订单支付成功处理业务
     * 如果为线下支付后，后台点击确认支付也同时调用此接口
     * @param payMethod 支付方式 StatusConstant 查询
     * @param orderId 订单ID
     * @param price 价格 如果为线下支付 则 为空
     */
    void paySuccess(Integer payMethod,Integer orderId,BigDecimal price);

}
