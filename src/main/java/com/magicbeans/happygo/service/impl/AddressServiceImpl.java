package com.magicbeans.happygo.service.impl;

import com.magicbeans.base.db.Filter;
import com.magicbeans.happygo.entity.Address;
import com.magicbeans.happygo.exception.InterfaceCommonException;
import com.magicbeans.happygo.mapper.AddressMapper;
import com.magicbeans.happygo.service.IAddressService;
import com.magicbeans.base.BaseServiceImp;
import com.magicbeans.happygo.util.CommonUtil;
import com.magicbeans.happygo.util.StatusConstant;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
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
@Transactional
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

    @Override
    public void setDefault(String id, String userId) {
        Address address = addressMapper.selectById(id);
        if(null == address){
            throw new InterfaceCommonException(StatusConstant.OBJECT_NOT_EXIST,"地址不存在");
        }
        List<Filter> filters = new ArrayList<>();
        filters.add(Filter.eq("userId", userId));
        filters.add(Filter.eq("isDefault", 1));
        filters.add(Filter.eq("isValid", 1));
        List<Address> addressList = findList(filters,null);
        if (null != addressList && addressList.size() > 0) {
            for (Address a : addressList) {
                a.setIsDefault(StatusConstant.NO);
                addressMapper.updateById(a);
            }
        }
        address.setIsDefault(StatusConstant.YES);
        addressMapper.updateById(address);
    }

    @Override
    public void addOrUpdate(Address address, String userId) {
        if (1 == address.getIsDefault()) {
            List<Filter> filters = new ArrayList<>();
            filters.add(Filter.eq("userId", userId));
            filters.add(Filter.eq("isDefault", 1));
            filters.add(Filter.eq("isValid", 1));
            List<Address> addressList = findList(filters, null);
            if (null != addressList && addressList.size() > 0) {
                for (Address a : addressList) {
                    a.setIsDefault(StatusConstant.NO);
                    addressMapper.updateById(a);
                }
            }
        }
        if (CommonUtil.isEmpty(address.getId())) {
            address.setUserId(userId);
            addressMapper.insert(address);
        } else {
            // 更新操作
            addressMapper.updateById(address);
        }
    }
}
