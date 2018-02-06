package com.magicbeans.happygo.mapper;

import com.magicbeans.happygo.entity.Banner;
import com.magicbeans.happygo.entity.Order;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.magicbeans.happygo.vo.OrderDetailVO;
import com.magicbeans.happygo.vo.OrderListVO;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
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


    List<OrderListVO> queryOrderList(Map<String,Object> map);


    OrderDetailVO queryOrderDetail(@Param("orderId") String orderId);


    /**
     * 订单集合
     * @param map
     * @return
     */
    List<Banner> list(Map<String ,Object> map);

    /**
     * 订单集合 条数
     * @param map
     * @return
     */
    int listCount(Map<String ,Object> map);

}
