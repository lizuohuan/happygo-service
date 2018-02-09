package com.magicbeans.happygo.vo;

import java.math.BigDecimal;

/**
 * Created by Eric Xie on 2018/2/1 0001.
 */
public class ProductVO {

    /** 商品ID */
    private String productId;

    /** 商品名 */
    private String productName;

    /** 商品封面图 */
    private String productCoverImg;

    /** 单价 */
    private BigDecimal price;

    /** 促销价格 */
    private BigDecimal promotionPrice;

    /** 商品评论数 */
    private Integer comments;

    /** 商品好评率 */
    private Double commentRatio;

    /** 积分 */
    private Integer integral;


    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCoverImg() {
        return this.productCoverImg;
    }

    public void setProductCoverImg(String productCoverImg) {
        this.productCoverImg = productCoverImg;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getComments() {
        return this.comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Double getCommentRatio() {
        return this.commentRatio;
    }

    public void setCommentRatio(Double commentRatio) {
        this.commentRatio = commentRatio;
    }

    /** 获取 促销价格 */
    public BigDecimal getPromotionPrice() {
        return this.promotionPrice;
    }

    /** 设置 促销价格 */
    public void setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    /** 获取 积分 */
    public Integer getIntegral() {
        return this.integral;
    }

    /** 设置 积分 */
    public void setIntegral(Integer integral) {
        this.integral = integral;
    }
}
