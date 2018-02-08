package com.magicbeans.happygo.service;

import com.magicbeans.base.BaseService;
import com.magicbeans.happygo.entity.Product;
import com.magicbeans.happygo.vo.ProductVO;

import java.util.List;
import java.util.Map;

/**
 * 商品
 * @author lzh
 * @create 2018/1/30 15:41
 */
public interface IProductService extends BaseService<Product> {

    /**
     * 搜索商品
     * @param productName 商品名称
     * @param pageNO 分页参数
     * @param pageSize 分页参数
     * @return 商品明细
     */
    List<ProductVO> searchProduct(String productName,Integer pageNO,Integer pageSize,String categoryId);

    /**
     *  获取商品列表
     * @param productCategoryId 分类ID
     * @param isPromotion 是否为促销商品  1：是
     * @param isIntegral 是否是积分商品  1：是
     * @param isHot 是否为热门商品  1：是
     * @param pageNO 分页参数
     * @param pageSize 分页参数
     * @return 商品列表
     */
    List<ProductVO> getProduct(String productCategoryId,Integer isPromotion,
                               Integer isIntegral,Integer isHot,Integer pageNO,Integer pageSize);
}
