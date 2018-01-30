package com.magicbeans.happygo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.magicbeans.happygo.entity.Product;
import org.apache.ibatis.annotations.CacheNamespaceRef;

/**
 * @author lzh
 * @create 2018/1/30 15:33
 */
@CacheNamespaceRef(ProductMapper.class)
public interface ProductMapper extends BaseMapper<Product> {
}
