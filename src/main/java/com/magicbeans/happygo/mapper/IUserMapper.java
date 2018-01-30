package com.magicbeans.happygo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.magicbeans.happygo.entity.User;
import org.apache.ibatis.annotations.CacheNamespaceRef;
import org.apache.ibatis.annotations.Param;

/**
 * 用户管理 Mapper
 * Created by Eric Xie on 2018/1/30 0030.
 */

@CacheNamespaceRef(AdminMapper.class)
public interface IUserMapper extends BaseMapper<User> {



    User queryUserByPhone(@Param("phone") String phone);


}
