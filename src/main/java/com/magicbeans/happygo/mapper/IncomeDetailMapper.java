package com.magicbeans.happygo.mapper;

import com.magicbeans.happygo.entity.IncomeDetail;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

}
