package com.magicbeans.happygo.entity;

import com.magicbeans.base.BaseEntity;

import java.util.Date;

/**
 * 用户entity
 * Created by Eric Xie on 2018/1/30 0030.
 */
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
    private String deviceType;

    /** 分销的上一级 */
    private Integer parentId;

    /** 用户状态，详细查询 StatusConstant.java*/
    private Integer status;


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

    public String getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public Integer getParentId() {
        return this.parentId;
    }

    public void setParentId(Integer parentId) {
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
}
