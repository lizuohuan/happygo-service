package com.magicbeans.happygo.service.impl;

import com.magicbeans.base.BaseServiceImp;
import com.magicbeans.happygo.entity.IncomeDetail;
import com.magicbeans.happygo.mapper.IncomeDetailMapper;
import com.magicbeans.happygo.service.IIncomeDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 收益明细 服务实现类
 * </p>
 *
 * @author null123
 * @since 2018-02-01
 */
@Service
public class IncomeDetailServiceImpl extends BaseServiceImp<IncomeDetailMapper, IncomeDetail> implements IIncomeDetailService {

    @Resource
    private IncomeDetailMapper incomeDetailMapper;

    @Override
    public List<IncomeDetail> getIncomeDetail(String fromUserId, String toUserId, Integer pageNO, Integer pageSize) {
        return incomeDetailMapper.queryIncomeDetailByItem(fromUserId,toUserId,(pageNO - 1) * pageSize,pageSize);
    }

    @Override
    public Map<String, Object> countIncome(String toUserId) {
        return incomeDetailMapper.countIncome(toUserId);
    }
}
