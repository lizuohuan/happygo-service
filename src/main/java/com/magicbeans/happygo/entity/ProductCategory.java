package com.magicbeans.happygo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.magicbeans.base.BaseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品分类
 * @author lzh
 * @create 2018/1/30 16:24
 */
@TableName("t_product_category")
public class ProductCategory extends BaseEntity<ProductCategory> {

    /** 分类名 */
    private String name;

    /** 上级分类id */
    private String parentId;

    /** 分类图标URL */
    private String icon;

    /**********************  业务字段  ************************/

    /** 分类子类 */
    @TableField(exist=false)
    private List<ProductCategory> childList = new ArrayList<>();

    /** 上级分类名 */
    @TableField(exist=false)
    private String parentName;



    /** 获取 分类名 */
    public String getName() {
        return this.name;
    }

    /** 设置 分类名 */
    public void setName(String name) {
        this.name = name;
    }

    /** 获取 上级分类id */
    public String getParentId() {
        return this.parentId;
    }

    /** 设置 上级分类id */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /** 获取 分类子类 */
    public List<ProductCategory> getChildList() {
        return this.childList;
    }

    /** 设置 分类子类 */
    public void setChildList(List<ProductCategory> childList) {
        this.childList = childList;
    }

    /** 获取 上级分类名 */
    public String getParentName() {
        return this.parentName;
    }

    /** 设置 上级分类名 */
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    /** 获取 分类图标URL */
    public String getIcon() {
        return this.icon;
    }

    /** 设置 分类图标URL */
    public void setIcon(String icon) {
        this.icon = icon;
    }
}
