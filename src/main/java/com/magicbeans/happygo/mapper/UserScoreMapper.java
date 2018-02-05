package com.magicbeans.happygo.mapper;

import com.magicbeans.happygo.entity.UserScore;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户积分明细 Mapper 接口
 * </p>
 *
 * @author null123
 * @since 2018-02-02
 */
public interface UserScoreMapper extends BaseMapper<UserScore> {

    List<UserScore> queryUserScoreByOrder(@Param("orderId") String orderId);

}
