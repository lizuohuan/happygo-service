package com.magicbeans.happygo.mapper;

import com.magicbeans.happygo.entity.Order;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Map;

/**
 * <p>
 * 订单 Mapper 接口
 * </p>
 *
 * @author null123
 * @since 2018-02-02
 */
public interface OrderMapper extends BaseMapper<Order> {

    /**
     * 计算订单的价格
     * @param orderId
     * @return
     */
    BigDecimal countOrderPrice(@Param("orderId") String orderId);


}
