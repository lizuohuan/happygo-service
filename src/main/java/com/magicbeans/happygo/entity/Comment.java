package com.magicbeans.happygo.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.magicbeans.base.BaseEntity;

/**
 * 评论
 * Created by Eric Xie on 2018/2/1 0001.
 */
@TableName("t_comment")
public class Comment extends BaseEntity<IncomeDetail> {

    /** 商品ID */
    private String productId;

    /** 得分   百分制 */
    private Integer score;

    /** 评论用户 */
    private String userId;

    /** 内容 */
    private String remark;

    /** 图片 */
    private String img;


    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getScore() {
        return this.score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    /** 获取 图片 */
    public String getImg() {
        return this.img;
    }

    /** 设置 图片 */
    public void setImg(String img) {
        this.img = img;
    }
}
