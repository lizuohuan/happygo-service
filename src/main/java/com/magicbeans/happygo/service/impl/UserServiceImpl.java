package com.magicbeans.happygo.service.impl;

import com.magicbeans.base.BaseServiceImp;
import com.magicbeans.happygo.entity.User;
import com.magicbeans.happygo.mapper.IUserMapper;
import com.magicbeans.happygo.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Eric Xie on 2018/1/30 0030.
 */
@Service
public class UserServiceImpl extends BaseServiceImp<IUserMapper,User> implements IUserService {

    @Resource
    private IUserMapper userMapper;

    @Override
    public User getUserByPhone(String phone) {
        return userMapper.queryUserByPhone(phone);
    }
}
