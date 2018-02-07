package com.magicbeans.happygo.vo;

import com.magicbeans.happygo.entity.OrderProduct;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Eric Xie on 2018/2/5 0005.
 */
public class OrderDetailVO {

    /** 订单ID */
    private String orderId;

    /** 订单号 */
    private String orderNumber;

    /** 创建时间 */
    private Date createTime;

    /** 订单状态 */
    private Integer status;

    /** 支付方式 */
    private String payMethod;

    /** 收货人 */
    private String consignee;

    /** 电话 */
    private String phone;

    /** 地址 */
    private String address;

    /** 订单价格 */
    private BigDecimal price;

    /** 运费 */
    private BigDecimal freight;

    private Integer payMethodId;

    private String bankImg;

    private Integer adminOk;

    /** 商品 */
    private List<OrderProduct> orderProducts;


    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderNumber() {
        return this.orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPayMethod() {
        return this.payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getConsignee() {
        return this.consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getFreight() {
        return this.freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public List<OrderProduct> getOrderProducts() {
        return this.orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public Integer getPayMethodId() {
        return this.payMethodId;
    }

    public void setPayMethodId(Integer payMethodId) {
        this.payMethodId = payMethodId;
    }

    public String getBankImg() {
        return this.bankImg;
    }

    public void setBankImg(String bankImg) {
        this.bankImg = bankImg;
    }

    public Integer getAdminOk() {
        return this.adminOk;
    }

    public void setAdminOk(Integer adminOk) {
        this.adminOk = adminOk;
    }
}
