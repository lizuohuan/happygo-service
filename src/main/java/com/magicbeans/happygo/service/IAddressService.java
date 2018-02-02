package com.magicbeans.happygo.service;

import com.magicbeans.happygo.entity.Address;
import com.magicbeans.base.BaseService;

import java.util.List;

/**
 * <p>
 * 用户地址 服务类
 * </p>
 *
 * @author null123
 * @since 2018-02-02
 */
public interface IAddressService extends BaseService<Address> {

    /**
     * 获取用户地址列表
     * @param userId
     * @param pageNO
     * @param pageSize
     * @return
     */
    List<Address> getAddressList(String userId,Integer pageNO,Integer pageSize);

    /**
     * 获取用户默认地址
     * @param userId
     * @return
     */
    Address getDefaultAddress(String userId);

}
