package com.magicbeans.happygo.entity;

import java.io.Serializable;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.magicbeans.base.BaseEntity;

/**
 * <p>
 * 收益明细
 * </p>
 *
 * @author null123
 * @since 2018-02-01
 */
@TableName("t_income_detail")
public class IncomeDetail extends BaseEntity<IncomeDetail> {

    private static final long serialVersionUID = 1L;

    /**
     * 收益来源用户|收益产生用户
     */
    private String fromUserId;
    /**
     * 收益目标用户
     */
    private String toUserId;
    /**
     * 收益来源类型 0:商品返回  1:积分红包兑换 2 : 支出
     */
    private Integer type;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 单价
     */
    private BigDecimal price;
    /**
     * 数量
     */
    private Integer number;
    /**
     * 产品封面图
     */
    private String productCoverImg;
    /**
     * 产生的收益金额
     */
    private BigDecimal bigDecimal;
    /**
     * 订单ID
     */
    private String orderId;
    /**
     * 产品ID
     */
    private String productId;

    /**
     * 是否有效
     */
    private Integer isValid;


    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getProductCoverImg() {
        return productCoverImg;
    }

    public void setProductCoverImg(String productCoverImg) {
        this.productCoverImg = productCoverImg;
    }

    public BigDecimal getBigDecimal() {
        return bigDecimal;
    }

    public void setBigDecimal(BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
    }

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

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "IncomeDetail{" +
        "fromUserId=" + fromUserId +
        ", toUserId=" + toUserId +
        ", type=" + type +
        ", productName=" + productName +
        ", price=" + price +
        ", number=" + number +
        ", productCoverImg=" + productCoverImg +
        ", bigDecimal=" + bigDecimal +
        ", orderId=" + orderId +
        ", productId=" + productId +
        "}";
    }

    /**
     * 获取 是否有效
     */
    public Integer getIsValid() {
        return this.isValid;
    }

    /**
     * 设置 是否有效
     */
    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }
}
