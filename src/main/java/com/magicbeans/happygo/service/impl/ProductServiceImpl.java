package com.magicbeans.happygo.service.impl;

import com.magicbeans.base.BaseServiceImp;
import com.magicbeans.happygo.entity.Product;
import com.magicbeans.happygo.mapper.ProductMapper;
import com.magicbeans.happygo.service.IProductService;
import com.magicbeans.happygo.vo.ProductVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lzh
 * @create 2018/1/30 15:42
 */
@Service
public class ProductServiceImpl extends BaseServiceImp<ProductMapper,Product> implements IProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public List<ProductVO> searchProduct(String productName, Integer pageNO, Integer pageSize) {
        return productMapper.searchProduct(productName,(pageNO - 1) * pageSize,pageSize);
    }
}
