package com.magicbeans.happygo.vo;

import com.magicbeans.happygo.entity.OrderProduct;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Eric Xie on 2018/2/5 0005.
 */
public class OrderListVO {

    /** 订单ID */
    private String orderId;

    /** 订单号 */
    private String orderNumber;

    /** 订单状态 */
    private Integer status;

    /** 订单总价 */
    private BigDecimal price;

    /** 订单运费 */
    private BigDecimal freight;


    /** 产品 */
    private List<OrderProduct> products;

    public String getOrderId() {
        return orderId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderListVO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public OrderListVO setFreight(BigDecimal freight) {
        this.freight = freight;
        return this;
    }

    public OrderListVO setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public OrderListVO setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public OrderListVO setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public List<OrderProduct> getProducts() {
        return products;
    }

    public OrderListVO setProducts(List<OrderProduct> products) {
        this.products = products;
        return this;
    }
}