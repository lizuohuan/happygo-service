package com.magicbeans.happygo.vo;

import java.math.BigDecimal;

/**
 * Created by Eric Xie on 2018/2/2 0002.
 */
public class ShopCarVO {

    /** 购物车ID */
    private String id;

    /** 商品ID */
    private String productId;

    /** 商品名称 */
    private String productName;

    /** 商品封面图 */
    private String productCover;

    /** 商品单价 */
    private BigDecimal price;

    /** 数量 */
    private Integer number;


    public String getId() {
        return id;
    }

    public ShopCarVO setId(String id) {
        this.id = id;
        return this;
    }

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

    public String getProductCover() {
        return this.productCover;
    }

    public void setProductCover(String productCover) {
        this.productCover = productCover;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getNumber() {
        return this.number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
