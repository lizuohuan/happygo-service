package com.magicbeans.happygo.service;

import com.magicbeans.happygo.entity.SystemConfig;
import com.magicbeans.base.BaseService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author null123
 * @since 2018-02-02
 */
public interface ISystemConfigService extends BaseService<SystemConfig> {


    /**
     * 获取系统配置
     * @return
     */
    SystemConfig getSystemConfig();

    /**
     * 提交更新系统配置
     * @param systemConfig
     */
    void updateSystemConfig(SystemConfig systemConfig);

}
