package com.magicbeans.happygo.service;

import com.magicbeans.happygo.entity.City;

import java.util.List;

/**
 * Created by Eric Xie on 2018/2/2 0002.
 */
public interface ICityService {

    /**
     *  查询某行政地区下的所属辖区
     * @param parentId 行政区ID
     * @param levelType 辖区类别
     * @return
     */
    List<City> getCityByParentId(Integer parentId, Integer levelType);


    List<City> getAllCity();


    City getCityById(Integer cityId);
}
