package com.magicbeans.happygo.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.magicbeans.happygo.entity.Log;
import org.apache.ibatis.annotations.CacheNamespaceRef;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author magicbeans
 * @since 2017-12-26
 */
@CacheNamespaceRef(LogMapper.class)
public interface LogMapper extends BaseMapper<Log> {

}