package com.magicbeans.happygo.mapper;

import com.magicbeans.happygo.entity.IncomeDetail;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 收益明细 Mapper 接口
 * </p>
 *
 * @author null123
 * @since 2018-02-01
 */
public interface IncomeDetailMapper extends BaseMapper<IncomeDetail> {


    /**
     * 分页查询收益明细
     * @param fromUserId 收益来源用户|收益产生用户
     * @param toUserId 为谁产生的收益 | 收益目标用户
     * @param limit 分页参数
     * @param limitSize 分页参数
     * @return 收益明细集合
     */
    List<IncomeDetail> queryIncomeDetailByItem(@Param("fromUserId") String fromUserId,@Param("toUserId") String toUserId,
                                               @Param("limit") Integer limit,@Param("limitSize") Integer limitSize);


    /**
     * 欢喜券页 统计
     * 今日收益(todayIncome)、总券(balance)、
     * 总收益(totalIncome)、欢喜积分(totalScore)、分销收益(distributionIncome)
     * @param toUserId 用户ID
     * @return
     */
    Map<String,Object>  countIncome(@Param("toUserId") String toUserId);


}
