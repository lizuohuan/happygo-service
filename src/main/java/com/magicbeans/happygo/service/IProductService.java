package com.magicbeans.happygo.service;

import com.magicbeans.base.BaseService;
import com.magicbeans.happygo.entity.Product;
import com.magicbeans.happygo.vo.ProductVO;

import java.util.List;

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
    List<ProductVO> searchProduct(String productName,Integer pageNO,Integer pageSize);
}
