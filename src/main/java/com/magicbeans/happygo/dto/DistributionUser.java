package com.magicbeans.happygo.dto;

import java.math.BigDecimal;

/**
 * Created by Eric Xie on 2018/2/1 0001.
 */
public class DistributionUser {

    /** 用户ID */
    private String userId;

    /** 昵称 */
    private String nickName;

    /** 头像 */
    private String profilePicture;

    /** 带来的收益 积分 */
//    private BigDecimal bigDecimal;
    private Integer bigDecimal;


    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public DistributionUser setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public String getProfilePicture() {
        return this.profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    /** 获取 带来的收益 */
    public Integer getBigDecimal() {
        return this.bigDecimal;
    }

    /** 设置 带来的收益 */
    public void setBigDecimal(Integer bigDecimal) {
        this.bigDecimal = bigDecimal;
    }

//    public BigDecimal getBigDecimal() {
//        return this.bigDecimal;
//    }
//
//    public void setBigDecimal(BigDecimal bigDecimal) {
//        this.bigDecimal = bigDecimal;
//    }
}
