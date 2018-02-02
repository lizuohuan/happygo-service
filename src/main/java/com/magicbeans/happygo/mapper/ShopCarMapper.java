package com.magicbeans.happygo.mapper;

import com.magicbeans.happygo.entity.ShopCar;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.magicbeans.happygo.vo.ShopCarVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 购物车中间表 Mapper 接口
 * </p>
 *
 * @author null123
 * @since 2018-02-02
 */
public interface ShopCarMapper extends BaseMapper<ShopCar> {


    /**
     *  查询用户的购物车
     * @param userId 用户
     * @return 购物车列表
     */
    List<ShopCarVO> queryShopCar(@Param("userId") String userId);


    /**
     * 通过产品 和 用户 查询购物车
     * @param userId 用户
     * @param productId 产品
     * @return
     */
    ShopCar queryShopCarByUser(@Param("userId") String userId,@Param("productId") String productId);


    /**
     * 批量删除购物车
     * @param ids
     */
    void batchDel(List<String> ids);

}
