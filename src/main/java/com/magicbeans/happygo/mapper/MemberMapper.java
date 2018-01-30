package com.magicbeans.happygo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.magicbeans.happygo.entity.Member;
import org.apache.ibatis.annotations.CacheNamespaceRef;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author magicbeans
 * @since 2017-09-26
 */
@CacheNamespaceRef(MemberMapper.class)
public interface MemberMapper extends BaseMapper<Member> {




}