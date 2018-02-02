package com.magicbeans.happygo.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.magicbeans.base.BaseEntity;

/**
 * <p>
 * banner
 * </p>
 *
 * @author
 * @since 2018-02-02
 */
@TableName("t_banner")
public class Banner extends BaseEntity<Banner> {

    private static final long serialVersionUID = 1L;

    /**
     * 名
     */
    private String name;

    /**
     * 标题
     */
    private String title;

    /**
     * 商品id
     */
    private String productId;
    /**
     * banner图片
     */
    private String img;
    /**
     * 跳转链接
     */
    private String link;
    /**
     * banner类型  0：商品banner  1：外链banner 
     */
    private Integer type;

    /************************ 业务字段 ************************/

    /**
     * 关联商品
     */
    @TableField(exist = false)
    private Product product;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Banner{" +
        "productId=" + productId +
        ", img=" + img +
        ", link=" + link +
        ", type=" + type +
        "}";
    }

    /**
     * 获取 名
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置 名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取 标题
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * 设置 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取 关联商品
     */
    public Product getProduct() {
        return this.product;
    }

    /**
     * 设置 关联商品
     */
    public void setProduct(Product product) {
        this.product = product;
    }
}
