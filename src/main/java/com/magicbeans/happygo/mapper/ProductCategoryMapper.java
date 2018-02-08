package com.magicbeans.happygo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.magicbeans.happygo.entity.ProductCategory;
import org.apache.ibatis.annotations.CacheNamespaceRef;

import java.util.List;

/**
 * 商品分类
 * @author lzh
 * @create 2018/1/30 16:26
 */
@CacheNamespaceRef(ProductCategoryMapper.class)
public interface ProductCategoryMapper extends BaseMapper<ProductCategory> {


}
