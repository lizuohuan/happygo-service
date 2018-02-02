package com.magicbeans.happygo.mapper;

import com.magicbeans.happygo.entity.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 城市 Mapper
 * Created by Eric Xie on 2017/7/12 0012.
 */
public interface CityMapper {



    /**
     * 通过ID 和 城市级别 查询城市
     * @param parentId
     * @param levelType
     * @return
     */
    List<City> queryCityByParentId(@Param("cityId") Integer parentId, @Param("levelType") Integer levelType);



}
