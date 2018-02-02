package com.magicbeans.happygo.service.impl;

import com.magicbeans.base.BaseServiceImp;
import com.magicbeans.happygo.dto.DistributionUser;
import com.magicbeans.happygo.entity.User;
import com.magicbeans.happygo.mapper.IUserMapper;
import com.magicbeans.happygo.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<String,List<DistributionUser>> getDistributionUser(String userId,Integer pageNO,Integer pageSize) {
        Map<String,List<DistributionUser>> data = new HashMap<>();
        data.put("one",userMapper.queryDistributionUser(userId,1,null,null));
        data.put("two",userMapper.queryDistributionUser(userId,2,null,null));
        data.put("three",userMapper.queryDistributionUser(userId,3,null,null));
        return data;
    }


    @Override
    public User getUserByShareCode(String shareCode) {
        return userMapper.queryUserByShareCode(shareCode);
    }
}
