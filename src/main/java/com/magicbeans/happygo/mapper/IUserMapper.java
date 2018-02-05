package com.magicbeans.happygo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.magicbeans.happygo.dto.DistributionUser;
import com.magicbeans.happygo.entity.User;
import org.apache.ibatis.annotations.CacheNamespaceRef;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户管理 Mapper
 * Created by Eric Xie on 2018/1/30 0030.
 */

@CacheNamespaceRef(AdminMapper.class)
public interface IUserMapper extends BaseMapper<User> {


    /**
     * 通过手机号查询用户的所有基础字段
     * @param phone
     * @return
     */
    User queryUserByPhone(@Param("phone") String phone);


    /**
     * 查询用户的分销
     * @param userId
     * @param levelType 分销级别 取值(1/2/3)
     * @return
     */
    List<DistributionUser> queryDistributionUser(@Param("userId") String userId, @Param("levelType") Integer levelType,
                                                 @Param("limit") Integer limit, @Param("limitSize") Integer limitSize);


    User queryUserByShareCode(@Param("shareCode") String shareCode);


    /**
     * 查询所有用户的当前积分 用于兑换欢喜券
     * 用户查询部分字段
     * @return
     */
    List<User> queryAllUser();

}
