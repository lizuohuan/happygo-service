package com.magicbeans.happygo.service.impl;

import com.magicbeans.base.BaseServiceImp;
import com.magicbeans.happygo.dto.DistributionUser;
import com.magicbeans.happygo.entity.User;
import com.magicbeans.happygo.exception.InterfaceCommonException;
import com.magicbeans.happygo.mapper.IUserMapper;
import com.magicbeans.happygo.redis.RedisService;
import com.magicbeans.happygo.service.IUserService;
import com.magicbeans.happygo.util.CommonUtil;
import com.magicbeans.happygo.util.RoleConstant;
import com.magicbeans.happygo.util.StatusConstant;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by Eric Xie on 2018/1/30 0030.
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImp<IUserMapper,User> implements IUserService {

    @Resource
    private IUserMapper userMapper;
    @Resource
    private RedisService redisService;

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


    @Override
    public Map<String, Object> countLastDay() {
        return userMapper.countLastDay();
    }


    @Override
    public void setAgent(String userId, Integer status) {
        if(status != 1 && status != 2){
            throw new InterfaceCommonException(StatusConstant.ARGUMENTS_EXCEPTION,"参数错误");
        }
        User user = userMapper.selectById(userId);
        if(null == user){
            throw new InterfaceCommonException(StatusConstant.OBJECT_NOT_EXIST,"用户不存在");
        }
        if(null == user.getBusinessStatus() || 1 == user.getBusinessStatus()
                || !RoleConstant.REGULAR_MEMBERS.equals(user.getRoleId())){
            throw new InterfaceCommonException(StatusConstant.Fail_CODE,"该用户没有申请或者已经是代理商");
        }
        user.setBusinessStatus(status);
        if(status == 1){
            user.setRoleId(RoleConstant.AGENT_REGULAR_MEMBERS);
        }
        userMapper.updateById(user);
        if(!CommonUtil.isEmpty(user.getToken())){
            redisService.set(user.getToken(),user,StatusConstant.LOGIN_VALID, TimeUnit.DAYS);
        }
    }
}
