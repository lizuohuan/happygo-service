package com.magicbeans.happygo.service.impl;

import com.magicbeans.happygo.entity.Bank;
import com.magicbeans.happygo.mapper.BankMapper;
import com.magicbeans.happygo.service.IBankService;
import com.magicbeans.base.BaseServiceImp;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 银行卡信息 服务实现类
 * </p>
 *
 * @author null123
 * @since 2018-02-08
 */
@Service
public class BankServiceImpl extends BaseServiceImp<BankMapper, Bank> implements IBankService {

}
