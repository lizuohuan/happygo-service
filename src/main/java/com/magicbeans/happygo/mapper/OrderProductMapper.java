package com.magicbeans.happygo.mapper;

import com.magicbeans.happygo.entity.OrderProduct;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 订单包含的产品 Mapper 接口
 * </p>
 *
 * @author null123
 * @since 2018-02-02
 */
public interface OrderProductMapper extends BaseMapper<OrderProduct> {


    /**
     * 通过订单ID 查询订单相关的产品信息
     * @param orderId 订单ID
     * @return 产品信息
     */
    List<OrderProduct> queryOrderProductByOrder(@Param("orderId") String orderId);

    /**
     * 通过订单ID 查询订单相关的产品信息
     * @param orderId 订单ID
     * @return 产品信息
     */
    List<OrderProduct> queryOrderProduct(@Param("orderId") String orderId);



}
