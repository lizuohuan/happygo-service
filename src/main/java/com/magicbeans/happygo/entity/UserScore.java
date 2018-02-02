package com.magicbeans.happygo.entity;

import java.io.Serializable;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.magicbeans.base.BaseEntity;

/**
 * <p>
 * 用户积分明细
 * </p>
 *
 * @author null123
 * @since 2018-02-02
 */
@TableName("t_user_score")
public class UserScore extends BaseEntity<UserScore> {

    /**
     * 订单ID
     */
    private String orderId;
    /**
     * 是否增加  0:否  1:是
     */
    private Integer isAdd;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 发生积分数量
     */
    private Integer score;
    /**
     * 商品名称 订单商品的集合
     */
    private String productName;
    /**
     * 产品封面图
     */
    private String productCoverImg;
    /**
     * 数量
     */
    private Integer number;
    /**
     * 单价
     */
    private BigDecimal price;


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getIsAdd() {
        return isAdd;
    }

    public void setIsAdd(Integer isAdd) {
        this.isAdd = isAdd;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCoverImg() {
        return productCoverImg;
    }

    public void setProductCoverImg(String productCoverImg) {
        this.productCoverImg = productCoverImg;
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

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "UserScore{" +
        "orderId=" + orderId +
        ", isAdd=" + isAdd +
        ", userId=" + userId +
        ", score=" + score +
        ", productName=" + productName +
        ", productCoverImg=" + productCoverImg +
        ", number=" + number +
        ", price=" + price +
        "}";
    }
}
