package com.magicbeans.happygo.service;

import com.magicbeans.base.BaseService;
import com.magicbeans.happygo.entity.IncomeDetail;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 收益明细 服务类
 * </p>
 *
 * @author null123
 * @since 2018-02-01
 */
public interface IIncomeDetailService extends BaseService<IncomeDetail> {

    /**
     *  查询收益明细
     * @param fromUserId 收益来源用户|收益产生用户
     * @param toUserId 为谁产生的收益 | 收益目标用户
     * @param pageNO 分页参数
     * @param pageSize 分页参数
     * @return 收益明细集合
     */
    List<IncomeDetail> getIncomeDetail(String fromUserId,String toUserId,Integer pageNO,Integer pageSize);


    /**
     * 欢喜券页 统计
     * 今日收益(todayIncome)、总券(balance)、
     * 总收益(totalIncome)、欢喜积分(totalScore)、分销收益(distributionIncome)
     * @param toUserId 用户ID
     * @return
     */
    Map<String,Object> countIncome(String toUserId);

}
