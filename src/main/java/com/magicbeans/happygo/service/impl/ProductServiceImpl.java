package com.magicbeans.happygo.service.impl;

import com.magicbeans.base.BaseServiceImp;
import com.magicbeans.happygo.entity.Product;
import com.magicbeans.happygo.mapper.ProductMapper;
import com.magicbeans.happygo.service.IProductService;
import org.springframework.stereotype.Service;

/**
 * @author lzh
 * @create 2018/1/30 15:42
 */
@Service
public class ProductServiceImpl extends BaseServiceImp<ProductMapper,Product> implements IProductService {
}
