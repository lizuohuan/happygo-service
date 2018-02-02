package com.magicbeans.happygo.service.impl;

import com.magicbeans.happygo.entity.City;
import com.magicbeans.happygo.mapper.CityMapper;
import com.magicbeans.happygo.service.ICityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Eric Xie on 2018/2/2 0002.
 */

@Service
public class CityServiceImpl implements ICityService {

    @Resource
    private CityMapper cityMapper;


    @Override
    public List<City> getCityByParentId(Integer parentId, Integer levelType) {
        return cityMapper.queryCityByParentId(parentId,levelType);
    }

}
