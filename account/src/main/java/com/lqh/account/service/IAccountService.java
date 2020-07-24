package com.lqh.account.service;

import com.lqh.domain.Account;
import com.lqh.mybatis.IBaseService;

/**
 * @author liqihua
 * @date 2020/6/17
 */
public interface IAccountService extends IBaseService<Account> {

    void decrease(Account entity);
}
