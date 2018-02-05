package com.magicbeans.happygo.entity;

import java.io.Serializable;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.magicbeans.base.BaseEntity;

/**
 * <p>
 * 订单
 * </p>
 *
 * @author null123
 * @since 2018-02-02
 */
@TableName("t_order")
public class Order extends BaseEntity<Order> {

    private static final long serialVersionUID = 1L;

    /**
     * 订单编号
     */
    private String orderNumber;
    /**
     * 用户
     */
    private String userId;
    /**
     * 订单状态
     */
    private Integer status;
    /**
     * 配送地址ID
     */
    private String addressId;
    /**
     * 订单总价(不包含运费)
     */
    private BigDecimal price;
    /**
     * 付款方式
     */
    private Integer payMethod;
    /**
     * 运费
     */
    private BigDecimal freight;

    /** 该订单对当前用户是否有效  0 无效 1 有效 */
    private Integer userIsValid;

    /** 上传的流水图 */
    private String bankImg;

    /**
     * 如果为线下支付，后台需要确认此订单已经支付，
     * 如果确认已经支付 更改值为1，
     * 如果不确认 则更改为 2
     * 初始化为 0
     */
    private Integer adminOk;

    /**
     * 操作此线下订单确认的后台管理者
     */
    private String adminId;

    /** 快递单号 */
    private String expressNumber;


    public String getExpressNumber() {
        return expressNumber;
    }

    public Order setExpressNumber(String expressNumber) {
        this.expressNumber = expressNumber;
        return this;
    }

    public String getAdminId() {
        return adminId;
    }

    public Order setAdminId(String adminId) {
        this.adminId = adminId;
        return this;
    }

    public Integer getAdminOk() {
        return adminOk;
    }

    public Order setAdminOk(Integer adminOk) {
        this.adminOk = adminOk;
        return this;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Order{" +
        "orderNumber=" + orderNumber +
        ", userId=" + userId +
        ", status=" + status +
        ", addressId=" + addressId +
        ", price=" + price +
        ", payMethod=" + payMethod +
        ", freight=" + freight +
        "}";
    }

    /** 获取 该订单对当前用户是否有效  0 无效 1 有效 */
    public Integer getUserIsValid() {
        return this.userIsValid;
    }

    /** 设置 该订单对当前用户是否有效  0 无效 1 有效 */
    public void setUserIsValid(Integer userIsValid) {
        this.userIsValid = userIsValid;
    }

    /** 获取 上传的流水图 */
    public String getBankImg() {
        return this.bankImg;
    }

    /** 设置 上传的流水图 */
    public void setBankImg(String bankImg) {
        this.bankImg = bankImg;
    }
}
