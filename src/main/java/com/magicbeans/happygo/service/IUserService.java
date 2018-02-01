package com.magicbeans.happygo.service;

import com.magicbeans.base.BaseService;
import com.magicbeans.happygo.dto.DistributionUser;
import com.magicbeans.happygo.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Eric Xie on 2018/1/30 0030.
 */
public interface IUserService extends BaseService<User> {

    /**
     * 通过手机号 查询用户所有基础字段
     * @param phone
     * @return
     */
    User getUserByPhone(String phone);

    /**
     * 获取该用户下的分销列表
     * @param userId
     * @return
     */
    Map<String,List<DistributionUser>> getDistributionUser(String userId,Integer pageNO,Integer pageSize);

}
