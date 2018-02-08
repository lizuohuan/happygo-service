package com.magicbeans.happygo.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.magicbeans.base.BaseEntity;

/**
 * <p>
 * 银行卡信息
 * </p>
 *
 * @author null123
 * @since 2018-02-08
 */
@TableName("t_bank")
public class Bank extends BaseEntity<Bank> {

    private static final long serialVersionUID = 1L;

    private String userId;
    /**
     * 开户人姓名
     */
    private String accountName;
    /**
     * 银行卡号
     */
    private String bankNumber;
    /**
     * 开户行
     */
    private String bankName;
    /**
     * 是否有效 
     */
    private Integer isValid;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Bank{" +
        "userId=" + userId +
        ", accountName=" + accountName +
        ", bankNumber=" + bankNumber +
        ", bankName=" + bankName +
        ", isValid=" + isValid +
        "}";
    }
}
