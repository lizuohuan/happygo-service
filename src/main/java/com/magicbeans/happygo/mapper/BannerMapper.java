package com.magicbeans.happygo.mapper;

import com.magicbeans.happygo.entity.Banner;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author null123
 * @since 2018-02-02
 */
public interface BannerMapper extends BaseMapper<Banner> {

    /**
     * banner集合
     * @param map
     * @return
     */
    List<Banner> list(Map<String ,Object> map);

    /**
     * banner集合 条数
     * @param map
     * @return
     */
    int listCount(Map<String ,Object> map);

}
