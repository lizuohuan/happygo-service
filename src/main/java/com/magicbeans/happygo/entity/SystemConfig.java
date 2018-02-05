package com.magicbeans.happygo.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.magicbeans.base.BaseEntity;

/**
 * 系统配置
 * @author lzh
 * @create 2018/2/2 12:00
 */
@TableName("t_system_config")
public class SystemConfig extends BaseEntity<SystemConfig> {

    /** 今日汇率 */
    private Double parities;

    /** 提现百分比 */
    private Double withdrawalProportion;

    /** 一级分销积分比例提成 */
    private Double oneRatio;

    /** 二级分销积分比例提成 */
    private Double twoRatio;

    /** 三级分销积分比例提成 */
    private Double threeRatio;

    /** 一级分销欢喜券比例提成 */
    private Double oneTicketRatio;


    /** 获取 今日汇率 */
    public Double getParities() {
        return this.parities;
    }

    /** 设置 今日汇率 */
    public void setParities(Double parities) {
        this.parities = parities;
    }

    /** 获取 提现百分比 */
    public Double getWithdrawalProportion() {
        return this.withdrawalProportion;
    }

    /** 设置 提现百分比 */
    public void setWithdrawalProportion(Double withdrawalProportion) {
        this.withdrawalProportion = withdrawalProportion;
    }

    /** 获取 一级分销比例提成 */
    public Double getOneRatio() {
        return this.oneRatio;
    }

    /** 设置 一级分销比例提成 */
    public void setOneRatio(Double oneRatio) {
        this.oneRatio = oneRatio;
    }

    /** 获取 二级分销比例提成 */
    public Double getTwoRatio() {
        return this.twoRatio;
    }

    /** 设置 二级分销比例提成 */
    public void setTwoRatio(Double twoRatio) {
        this.twoRatio = twoRatio;
    }

    /** 获取 三级分销比例提成 */
    public Double getThreeRatio() {
        return this.threeRatio;
    }

    /** 设置 三级分销比例提成 */
    public void setThreeRatio(Double threeRatio) {
        this.threeRatio = threeRatio;
    }

    /** 获取 一级分销欢喜券比例提成 */
    public Double getOneTicketRatio() {
        return this.oneTicketRatio;
    }

    /** 设置 一级分销欢喜券比例提成 */
    public void setOneTicketRatio(Double oneTicketRatio) {
        this.oneTicketRatio = oneTicketRatio;
    }
}
