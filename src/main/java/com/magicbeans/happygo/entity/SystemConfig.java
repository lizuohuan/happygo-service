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
}
