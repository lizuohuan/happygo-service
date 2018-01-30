package com.magicbeans.happygo.service;

import com.magicbeans.base.Pages;
import com.magicbeans.happygo.entity.Member;
import com.magicbeans.base.BaseService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author magicbeans
 * @since 2017-09-26
 */
public interface IMemberService extends BaseService<Member> {

    Pages<Member> selectPage(Pages pagination);
}
