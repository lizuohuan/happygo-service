package com.magicbeans.happygo.service.impl;

import com.magicbeans.happygo.entity.OrderProduct;
import com.magicbeans.happygo.mapper.OrderProductMapper;
import com.magicbeans.happygo.service.IOrderProductService;
import com.magicbeans.base.BaseServiceImp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 订单包含的产品 服务实现类
 * </p>
 *
 * @author null123
 * @since 2018-02-02
 */
@Service
public class OrderProductServiceImpl extends BaseServiceImp<OrderProductMapper, OrderProduct> implements IOrderProductService {

    @Resource
    private OrderProductMapper orderProductMapper;


}
