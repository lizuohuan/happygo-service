package com.magicbeans.happygo.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.magicbeans.base.BaseEntity;

/**
 * <p>
 * 购物车中间表
 * </p>
 *
 * @author null123
 * @since 2018-02-02
 */
@TableName("t_shop_car")
public class ShopCar extends BaseEntity<ShopCar> {

    private static final long serialVersionUID = 1L;

    /**
     * 商品ID
     */
    private String productId;
    /**
     * 数量
     */
    private Integer number;
    /**
     * 用户ID
     */
    private String userId;


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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "ShopCar{" +
        "productId=" + productId +
        ", number=" + number +
        ", userId=" + userId +
        "}";
    }
}
