package com.magicbeans.happygo.service;

import com.magicbeans.base.BaseService;
import com.magicbeans.happygo.entity.ShopCar;
import com.magicbeans.happygo.vo.ShopCarVO;

import java.util.List;

/**
 * <p>
 * 购物车中间表 服务类
 * </p>
 *
 * @author null123
 * @since 2018-02-02
 */
public interface IShopCarService extends BaseService<ShopCar> {

    /**
     * 获取用户的购物车
     * @param userId 用户ID
     * @return 购物车列表
     */
    List<ShopCarVO> getShopCar(String userId);


    /**
     * 通过产品 和 用户 查询购物车
     * @param userId 用户
     * @param productId 产品
     * @return
     */
    ShopCar getShopCarByUser(String userId,String productId);


    /***
     * 批量删除
     * @param ids
     */
    void del(List<String> ids);

}
