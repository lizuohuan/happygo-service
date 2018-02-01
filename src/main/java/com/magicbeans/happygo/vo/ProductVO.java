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

    /** 商品评论数 */
    private Integer comments;

    /** 商品好评率 */
    private Double commentRatio;


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
}
