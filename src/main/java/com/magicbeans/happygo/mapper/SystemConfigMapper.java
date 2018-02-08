package com.magicbeans.happygo.mapper;

import com.magicbeans.happygo.entity.SystemConfig;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author null123
 * @since 2018-02-02
 */
public interface SystemConfigMapper extends BaseMapper<SystemConfig> {


    /**
     * 获取最新的一条配置记录
     * @return
     */
    SystemConfig querySystemConfig();

}
