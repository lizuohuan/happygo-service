package com.magicbeans.happygo.service;

import com.magicbeans.base.BaseService;
import com.magicbeans.happygo.entity.User;

/**
 * Created by Eric Xie on 2018/1/30 0030.
 */
public interface IUserService extends BaseService<User> {

    User getUserByPhone(String phone);

}
