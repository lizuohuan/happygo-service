package com.magicbeans.happygo.service.impl;

import com.magicbeans.happygo.entity.Address;
import com.magicbeans.happygo.mapper.AddressMapper;
import com.magicbeans.happygo.service.IAddressService;
import com.magicbeans.base.BaseServiceImp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户地址 服务实现类
 * </p>
 *
 * @author null123
 * @since 2018-02-02
 */
@Service
public class AddressServiceImpl extends BaseServiceImp<AddressMapper, Address> implements IAddressService {

    @Resource
    private AddressMapper addressMapper;

    @Override
    public List<Address> getAddressList(String userId, Integer pageNO, Integer pageSize) {
        return addressMapper.queryAddress(userId,(pageNO - 1) * pageSize,pageSize);
    }

    @Override
    public Address getDefaultAddress(String userId) {
        return addressMapper.queryDefault(userId);
    }
}
