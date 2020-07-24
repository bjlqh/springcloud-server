package com.lqh.account.controller;

import com.lqh.account.service.IAccountService;
import com.lqh.common.RequestStatus;
import com.lqh.common.ResponseResult;
import com.lqh.domain.Account;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liqihua
 * @date 2020/6/3
 */
@RestController
@RequestMapping("account")
public class AccountController {

    @Resource
    private IAccountService accountService;

    @PutMapping("decrease")
    public ResponseResult decrease(@RequestBody Account entity) {
        accountService.decrease(entity);
        return new ResponseResult(true, RequestStatus.OK, "账户扣减成功");
    }

}
