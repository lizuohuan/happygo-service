package com.magicbeans.happygo.mapper;

import com.magicbeans.happygo.entity.Address;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户地址 Mapper 接口
 * </p>
 *
 * @author null123
 * @since 2018-02-02
 */
public interface AddressMapper extends BaseMapper<Address> {


    /**
     * 获取用户地址列表
     * @param userId
     * @param limit
     * @param limitSize
     * @return
     */
    List<Address> queryAddress(@Param("userId") String userId,@Param("limit") Integer limit,@Param("limitSize") Integer limitSize);

    /**
     * 获取用户默认地址
     * @param userId 用户
     * @return
     */
    Address queryDefault(@Param("userId") String userId);

}
