package com.magicbeans.happygo.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.magicbeans.base.BaseEntity;
import com.magicbeans.happygo.dto.DistributionUser;

import java.util.Date;
import java.util.List;

/**
 * 用户entity
 * Created by Eric Xie on 2018/1/30 0030.
 */
@TableName("t_users")
public class User extends BaseEntity<User> {

    /** 手机号 */
    private String phone;

    /** 密码 */
    private String pwd;

    /** 支付密码 */
    private String payPwd;

    /** 昵称 */
    private String nickName;

    /** 头像 */
    private String profilePicture;

    /** email */
    private String email;

    /** 身份证号码 */
    private String idNumber;

    /** 性别 0：男、1：女 */
    private Integer gender;

    /** 生日日期 */
    private Date birthday;

    /** 角色ID */
    private Integer roleId;

    /** 身份证附件地址 */
    private String idNumberAttachment;

    /** 法人姓名 */
    private String legalPerson;

    /** 营业执照图片地址 */
    private String businessLicenseImg;

    /** 营业执照号码 */
    private String businessLicenseNumber;

    /** 申请原因 */
    private String applyReason;

    /** 请求令牌 */
    private String token;

    /** 设备token */
    private String deviceToken;

    /** 设备类型 0:android  1:ios */
    private Integer deviceType;

    /** 分销的上一级 */
    private String parentId;

    /** 用户状态，详细查询 StatusConstant.java*/
    private Integer status;

    /** 积分 */
    private Integer score;

    /** 姓名字段 */
    private String realName;

    /** 邀请码 */
    private String shareCode;

    /** 成为代理商的电话号码备注 */
    private String businessPhone;

    /** 申请代理商的状态 0 申请中  1 通过  2 拒绝通过 */
    private Integer businessStatus;

    // 业务类


    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPayPwd() {
        return this.payPwd;
    }

    public void setPayPwd(String payPwd) {
        this.payPwd = payPwd;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getProfilePicture() {
        return this.profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdNumber() {
        return this.idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Integer getGender() {
        return this.gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getIdNumberAttachment() {
        return this.idNumberAttachment;
    }

    public void setIdNumberAttachment(String idNumberAttachment) {
        this.idNumberAttachment = idNumberAttachment;
    }

    public String getLegalPerson() {
        return this.legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getBusinessLicenseImg() {
        return this.businessLicenseImg;
    }

    public void setBusinessLicenseImg(String businessLicenseImg) {
        this.businessLicenseImg = businessLicenseImg;
    }

    public String getBusinessLicenseNumber() {
        return this.businessLicenseNumber;
    }

    public void setBusinessLicenseNumber(String businessLicenseNumber) {
        this.businessLicenseNumber = businessLicenseNumber;
    }

    public String getApplyReason() {
        return applyReason;
    }

    public User setApplyReason(String applyReason) {
        this.applyReason = applyReason;
        return this;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getDeviceToken() {
        return this.deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public Integer getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public String getParentId() {
        return this.parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /** 获取 用户状态，详细查询 StatusConstant.java*/
    public Integer getStatus() {
        return this.status;
    }

    /** 设置 用户状态，详细查询 StatusConstant.java*/
    public void setStatus(Integer status) {
        this.status = status;
    }

    /** 获取 积分 */
    public Integer getScore() {
        return this.score;
    }

    /** 设置 积分 */
    public void setScore(Integer score) {
        this.score = score;
    }

    /** 获取 姓名字段 */
    public String getRealName() {
        return this.realName;
    }

    /** 设置 姓名字段 */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getShareCode() {
        return this.shareCode;
    }

    public void setShareCode(String shareCode) {
        this.shareCode = shareCode;
    }

    /** 获取 成为代理商的电话号码备注 */
    public String getBusinessPhone() {
        return this.businessPhone;
    }

    /** 设置 成为代理商的电话号码备注 */
    public void setBusinessPhone(String businessPhone) {
        this.businessPhone = businessPhone;
    }

    /** 获取 申请代理商的状态 0 申请中  1 通过  2 拒绝通过 */
    public Integer getBusinessStatus() {
        return this.businessStatus;
    }

    /** 设置 申请代理商的状态 0 申请中  1 通过  2 拒绝通过 */
    public void setBusinessStatus(Integer businessStatus) {
        this.businessStatus = businessStatus;
    }
}
