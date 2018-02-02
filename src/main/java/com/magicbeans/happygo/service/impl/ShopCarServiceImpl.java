package com.magicbeans.happygo.service.impl;

import com.magicbeans.base.BaseServiceImp;
import com.magicbeans.happygo.entity.ShopCar;
import com.magicbeans.happygo.mapper.ShopCarMapper;
import com.magicbeans.happygo.service.IShopCarService;
import com.magicbeans.happygo.vo.ShopCarVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 购物车中间表 服务实现类
 * </p>
 *
 * @author null123
 * @since 2018-02-02
 */
@Service
public class ShopCarServiceImpl extends BaseServiceImp<ShopCarMapper, ShopCar> implements IShopCarService {

    @Resource
    private ShopCarMapper shopCarMapper;

    @Override
    public List<ShopCarVO> getShopCar(String userId) {
        return shopCarMapper.queryShopCar(userId);
    }

    @Override
    public ShopCar getShopCarByUser(String userId, String productId) {
        return shopCarMapper.queryShopCarByUser(userId,productId);
    }

    @Override
    public void del(List<String> ids) {
        if(null != ids && ids.size() > 0){
            shopCarMapper.batchDel(ids);
        }
    }

    @Override
    public List<ShopCar> getShopCar(List<String> shopCarIds) {
        if(null == shopCarIds || shopCarIds.size() == 0){
            return null;
        }
        return shopCarMapper.batchQueryShopCar(shopCarIds);
    }
}
