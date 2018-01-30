package com.magicbeans.happygo.entity;

import com.magicbeans.base.BaseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品分类
 * @author lzh
 * @create 2018/1/30 16:24
 */
public class ProductCategory extends BaseEntity<ProductCategory> {

    /** 分类名 */
    private String name;

    /** 上级分类id */
    private Integer parentId;

    /**********************  业务字段  ************************/

    /** 分类子类 */
    private List<ProductCategory> childList = new ArrayList<>();

    /** 获取 分类名 */
    public String getName() {
        return this.name;
    }

    /** 设置 分类名 */
    public void setName(String name) {
        this.name = name;
    }

    /** 获取 上级分类id */
    public Integer getParentId() {
        return this.parentId;
    }

    /** 设置 上级分类id */
    public void setParentId(Integer parentId) {
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
}
