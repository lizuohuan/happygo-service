package com.magicbeans.happygo.service.impl;

import com.magicbeans.base.PageableUtils;
import com.magicbeans.base.Pages;
import com.magicbeans.happygo.entity.Member;
import com.magicbeans.happygo.mapper.MemberMapper;
import com.magicbeans.base.BaseServiceImp;
import com.magicbeans.base.db.Filter;
import com.magicbeans.happygo.service.IMemberService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author magicbeans
 * @since 2017-09-26
 */
@Service
public class MemberServiceImpl extends BaseServiceImp<MemberMapper, Member> implements IMemberService {
    @Override
    public Pages<Member> selectPage(Pages pagination) {
        return PageableUtils.query(pagination, new PageableUtils.PageCallBack<Member>() {
            @Override
            public List<Member> call() {
                Filter[] betweenFilters = new Filter[]{
                        Filter.between("create_time", "2017-10-12 16:52:29", "2017-10-13 16:52:29")
                };
                return findList("name","asdasdadasd");
            }
        });
    }
}
