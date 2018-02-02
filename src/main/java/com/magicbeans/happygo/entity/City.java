package com.magicbeans.happygo.entity;

import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 城市 entity
 * Created by Eric Xie on 2017/7/12 0012.
 */
@TableName("citys")
public class City implements Serializable {

    /**
     * ID
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 父ID
     */
    private Integer parentId;

    /**
     * 短名称
     */
    private String shortName;

    /**
     * 级别
     */
    private Integer levelType;

    /**
     * 城市区号
     */
    private String cityCode;

    /**
     * 城市邮编
     */
    private String zipCode;

    /**
     * 合并名称
     */
    private String mergerName;

    /**
     * 城市拼音
     */
    private String pinYin;

    private String lng;

    private String lat;


    /**
     * 获取 ID
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * 设置 ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 名称
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取 父ID
     */
    public Integer getParentId() {
        return this.parentId;
    }

    /**
     * 设置 父ID
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取 短名称
     */
    public String getShortName() {
        return this.shortName;
    }

    /**
     * 设置 短名称
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * 获取 级别
     */
    public Integer getLevelType() {
        return this.levelType;
    }

    /**
     * 设置 级别
     */
    public void setLevelType(Integer levelType) {
        this.levelType = levelType;
    }

    /**
     * 获取 城市区号
     */
    public String getCityCode() {
        return this.cityCode;
    }

    /**
     * 设置 城市区号
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    /**
     * 获取 城市邮编
     */
    public String getZipCode() {
        return this.zipCode;
    }

    /**
     * 设置 城市邮编
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * 获取 合并名称
     */
    public String getMergerName() {
        return this.mergerName;
    }

    /**
     * 设置 合并名称
     */
    public void setMergerName(String mergerName) {
        this.mergerName = mergerName;
    }

    /**
     * 获取 城市拼音
     */
    public String getPinYin() {
        return this.pinYin;
    }

    /**
     * 设置 城市拼音
     */
    public void setPinYin(String pinYin) {
        this.pinYin = pinYin;
    }


    public String getLng() {
        return this.lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return this.lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
}
