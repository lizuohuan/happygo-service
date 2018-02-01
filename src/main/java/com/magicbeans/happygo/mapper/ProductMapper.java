package com.magicbeans.happygo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.magicbeans.happygo.entity.Product;
import com.magicbeans.happygo.vo.ProductVO;
import org.apache.ibatis.annotations.CacheNamespaceRef;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author lzh
 * @create 2018/1/30 15:33
 */
@CacheNamespaceRef(ProductMapper.class)
public interface ProductMapper extends BaseMapper<Product> {


    /**
     * 搜索商品
     * @param productName 商品名称
     * @param limit 分页参数
     * @param limitSize 分页参数
     * @return 商品明细
     */
    List<ProductVO> searchProduct(@Param("productName") String productName,
                                  @Param("limit") Integer limit, @Param("limitSize") Integer limitSize);

    /**
     * 获取商品列表
     * @param map
     * @return
     */
    List<ProductVO> getProduct(Map<String,Object> map);




}
