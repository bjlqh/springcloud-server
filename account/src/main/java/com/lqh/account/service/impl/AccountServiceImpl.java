package com.lqh.account.service.impl;

import com.lqh.account.mapper.AccountMapper;
import com.lqh.account.service.IAccountService;
import com.lqh.domain.Account;
import com.lqh.mybatis.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author liqihua
 * @date 2020/6/17
 */
@Slf4j
@Service
public class AccountServiceImpl extends BaseServiceImpl<AccountMapper, Account> implements IAccountService {

    @Override
    public void decrease(Account entity) {
        Account condition = new Account();
        condition.setUserId(entity.getUserId());
        Account account = this.mapper.select(condition).get(0);
        BigDecimal total = account.getTotal();
        BigDecimal used = entity.getUsed();
        if (total.compareTo(used) >= 0) {
            account.setTotal(total.subtract(used));
            this.mapper.updateByPrimaryKeySelective(account);
        } else {
            throw new RuntimeException("余额不足");
        }
    }
}
