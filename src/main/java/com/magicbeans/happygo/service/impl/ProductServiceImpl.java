package com.magicbeans.happygo.service.impl;

import com.magicbeans.base.BaseServiceImp;
import com.magicbeans.happygo.entity.Product;
import com.magicbeans.happygo.mapper.ProductMapper;
import com.magicbeans.happygo.service.IProductService;
import com.magicbeans.happygo.util.CommonUtil;
import com.magicbeans.happygo.vo.ProductVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<ProductVO> getProduct(String productCategoryId, Integer isPromotion, Integer isIntegral, Integer isHot,
                                      Integer pageNO, Integer pageSize) {
        Map<String,Object> map = new HashMap<>();
        map.put("productCategoryId", CommonUtil.isEmpty(productCategoryId) ? null : productCategoryId);
        map.put("isPromotion", isPromotion);
        map.put("isIntegral", isIntegral);
        map.put("isHot", isHot);
        map.put("limit", (pageNO - 1) * pageSize);
        map.put("limitSize", pageSize);
        return productMapper.getProduct(map);
    }
}
