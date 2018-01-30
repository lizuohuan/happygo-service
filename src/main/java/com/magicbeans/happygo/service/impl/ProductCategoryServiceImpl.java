package com.magicbeans.happygo.service.impl;

import com.magicbeans.base.BaseServiceImp;
import com.magicbeans.happygo.entity.ProductCategory;
import com.magicbeans.happygo.mapper.ProductCategoryMapper;
import com.magicbeans.happygo.service.IProductCategoryService;
import org.springframework.stereotype.Service;

/**
 * 商品分类
 * @author lzh
 * @create 2018/1/30 16:35
 */
@Service
public class ProductCategoryServiceImpl
        extends BaseServiceImp<ProductCategoryMapper,ProductCategory>
        implements IProductCategoryService {
}
