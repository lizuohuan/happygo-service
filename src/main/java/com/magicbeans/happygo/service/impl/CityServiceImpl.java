package com.magicbeans.happygo.service.impl;

import com.magicbeans.happygo.entity.City;
import com.magicbeans.happygo.mapper.CityMapper;
import com.magicbeans.happygo.service.ICityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    @Override
    public List<City> getAllCity() {
        List<City> cityList = cityMapper.queryAllCity();
        // 装配城市
        return setCity(cityList);
    }


    private List<City> setCity(List<City> cityList) {
        // 省
        List<City> provinceList = new ArrayList<City>();
        // 市
        List<City> townList = new ArrayList<City>();
        // 区县
        List<City> countyList = new ArrayList<City>();
        if (cityList.size() > 0) {
            for (City City : cityList) {
                if (City.getLevelType() == 3) {
                    countyList.add(City);
                }
                if (City.getLevelType() == 2) {
                    townList.add(City);
                }
                if (City.getLevelType() == 1) {
                    provinceList.add(City);
                }
            }
            // 设置 区县级列表到市级集合
            for (City town : townList) {
                for (City county : countyList) {
                    if(county.getParentId().equals(town.getId())){
                        town.getCityList().add(county);
                    }
                }
            }
            for (City province : provinceList) {
                for (City town : townList) {
                    if(town.getParentId().equals(province.getId())){
                        province.getCityList().add(town);
                    }
                }
            }
        }
        return provinceList;
    }

    @Override
    public City getCityById(Integer cityId) {
        return cityMapper.queryCityById(cityId);
    }
}
