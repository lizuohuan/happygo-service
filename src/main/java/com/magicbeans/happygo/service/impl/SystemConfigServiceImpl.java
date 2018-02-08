package com.magicbeans.happygo.service.impl;

import com.magicbeans.happygo.entity.SystemConfig;
import com.magicbeans.happygo.mapper.SystemConfigMapper;
import com.magicbeans.happygo.service.ISystemConfigService;
import com.magicbeans.base.BaseServiceImp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author null123
 * @since 2018-02-02
 */
@Service
public class SystemConfigServiceImpl extends BaseServiceImp<SystemConfigMapper, SystemConfig> implements ISystemConfigService {

    @Resource
    private SystemConfigMapper systemConfigMapper;


    @Override
    public SystemConfig getSystemConfig() {
        return systemConfigMapper.querySystemConfig();
    }


    @Override
    public void updateSystemConfig(SystemConfig systemConfig) {
        if(null != systemConfig.getId()){
            systemConfig.setId(null);
        }
        systemConfigMapper.insert(systemConfig);
    }
}
