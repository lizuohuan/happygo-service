package com.magicbeans.happygo.entity;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.magicbeans.base.BaseEntity;
import com.magicbeans.happygo.util.CommonUtil;

import java.math.BigDecimal;

/**
 * 商品信息
 * @author lzh
 * @create 2018/1/30 15:29
 */
@TableName("t_product")
public class Product extends BaseEntity<Product> {

    /** 商品名 */
    private String name;

    /** 商品编号 */
    private String number;

    /** 商品描述 */
    private String describe;

    /** 商品分类id */
    private String productCategoryId;

    /** 价格 */
    private BigDecimal price;

    /** 是否为促销商品 0：否 1：是 */
    private Integer isPromotion;

    /** 当商品为促销商品时，配置促销价 */
    private BigDecimal promotionPrice;

    /** 是否是积分商品 0：否 1：是 */
    private Integer isIntegral;

    /** 当商品为积分商品时，配置积分 */
    private Integer integral;

    /** 是否为热门商品 0：否 1：是 */
    private Integer isHot;

    /** 封面图 */
    private String coverImg;

    /** 图片json集合 字符串类型 */
    private String imgJsonAryStr;


    /********************  业务字段  ***********************/

    /** 商品分类名 */
    @TableField(exist=false)
    private String productCategoryName;

    /** 图片json集合 */
    @TableField(exist=false)
    private JSONArray imgJsonArray;

    /** 获取 商品名 */
    public String getName() {
        return this.name;
    }

    /** 设置 商品名 */
    public void setName(String name) {
        this.name = name;
    }

    /** 获取 商品编号 */
    public String getNumber() {
        return this.number;
    }

    /** 设置 商品编号 */
    public void setNumber(String number) {
        this.number = number;
    }

    /** 获取 商品描述 */
    public String getDescribe() {
        return this.describe;
    }

    /** 设置 商品描述 */
    public void setDescribe(String describe) {
        this.describe = describe;
    }

    /** 获取 商品分类id */
    public String getProductCategoryId() {
        return this.productCategoryId;
    }

    /** 设置 商品分类id */
    public void setProductCategoryId(String productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    /** 获取 价格 */
    public BigDecimal getPrice() {
        return this.price;
    }

    /** 设置 价格 */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /** 获取 是否为促销商品 0：否 1：是 */
    public Integer getIsPromotion() {
        return this.isPromotion;
    }

    /** 设置 是否为促销商品 0：否 1：是 */
    public void setIsPromotion(Integer isPromotion) {
        this.isPromotion = isPromotion;
    }

    /** 获取 当商品为促销商品时，配置促销价 */
    public BigDecimal getPromotionPrice() {
        return this.promotionPrice;
    }

    /** 设置 当商品为促销商品时，配置促销价 */
    public void setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    /** 获取 是否是积分商品 0：否 1：是 */
    public Integer getIsIntegral() {
        return this.isIntegral;
    }

    /** 设置 是否是积分商品 0：否 1：是 */
    public void setIsIntegral(Integer isIntegral) {
        this.isIntegral = isIntegral;
    }

    /** 获取 当商品为积分商品时，配置积分 */
    public Integer getIntegral() {
        return this.integral;
    }

    /** 设置 当商品为积分商品时，配置积分 */
    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    /** 获取 是否为热门商品 0：否 1：是 */
    public Integer getIsHot() {
        return this.isHot;
    }

    /** 设置 是否为热门商品 0：否 1：是 */
    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    /** 获取 商品分类名 */
    public String getProductCategoryName() {
        return this.productCategoryName;
    }

    /** 设置 商品分类名 */
    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    /** 获取 封面图 */
    public String getCoverImg() {
        return this.coverImg;
    }

    /** 设置 封面图 */
    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }


    /** 获取 图片json集合 字符串类型 */
    public String getImgJsonAryStr() {
        return this.imgJsonAryStr;
    }

    /** 设置 图片json集合 字符串类型 */
    public void setImgJsonAryStr(String imgJsonAryStr) {
        this.imgJsonAryStr = imgJsonAryStr;
    }

    /** 获取 图片json集合 */
    public JSONArray getImgJsonArray() {
        if (CommonUtil.isEmpty2(imgJsonAryStr)) {
            return JSONArray.parseArray(imgJsonAryStr);
        }
        return this.imgJsonArray;
    }

    /** 设置 图片json集合 */
    public void setImgJsonArray(JSONArray imgJsonArray) {
        this.imgJsonArray = imgJsonArray;
    }
}
