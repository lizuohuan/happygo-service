package com.magicbeans.happygo.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.magicbeans.base.BaseEntity;

/**
 * <p>
 * 用户地址
 * </p>
 *
 * @author null123
 * @since 2018-02-02
 */
@TableName("t_address")
public class Address extends BaseEntity<Address> {

    /**
     * 城市ID
     */
    private Integer cityId;
    /**
     * 联系人
     */
    private String contacts;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 详细地址
     */
    private String detailAddress;
    /**
     * 是否I为默认地址
     */
    private Integer isDefault;
    /**
     * 用户ID
     */
    private String userId;

    private Integer isValid;

    // 业务字段

    @TableField(exist = false)
    private String cityName;


    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
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
        return "Address{" +
        "cityId=" + cityId +
        ", contacts=" + contacts +
        ", phone=" + phone +
        ", detailAddress=" + detailAddress +
        ", isDefault=" + isDefault +
        ", userId=" + userId +
        "}";
    }

    public Integer getIsValid() {
        return this.isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
