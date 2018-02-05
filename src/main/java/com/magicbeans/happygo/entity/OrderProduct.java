package com.magicbeans.happygo.entity;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.List;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.magicbeans.base.BaseEntity;

/**
 * <p>
 * 订单包含的产品
 * </p>
 *
 * @author null123
 * @since 2018-02-02
 */
@TableName("t_order_product")
public class OrderProduct extends BaseEntity<OrderProduct> {

    private static final long serialVersionUID = 1L;

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 产品ID
     */
    private String productId;
    /**
     * 数量
     */
    private Integer number;
    /**
     * 产品单价
     */
    private BigDecimal price;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 产品封面图
     */
    private String productCover;
    /**
     * 产品JSON明细数据
     */
    private String productDetail;

    // 业务字段

    @TableField(exist=false)
    private Product product;


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCover() {
        return productCover;
    }

    public void setProductCover(String productCover) {
        this.productCover = productCover;
    }

    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
        "orderId=" + orderId +
        ", productId=" + productId +
        ", number=" + number +
        ", price=" + price +
        ", productName=" + productName +
        ", productCover=" + productCover +
        ", productDetail=" + productDetail +
        "}";
    }

    public Product getProduct() {
        return product;
    }

    public OrderProduct setProduct(Product product) {
        this.product = product;
        return this;
    }
}
