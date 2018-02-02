package com.magicbeans.happygo.vo;

import java.util.Date;

/**
 * Created by Eric Xie on 2018/2/1 0001.
 */
public class CommentVO {

    /** 昵称 */
    private String nickName;

    /** 头像 */
    private String profilePicture;

    /** 会员等级 | 角色 */
    private Integer roleId;

    /** 评分 */
    private Integer score;

    /** 评论 */
    private String remark;

    /** 创建时间 */
    private Date createTime;

    /** 评论图片 */
    private String img;


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

    public Integer getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getScore() {
        return this.score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
