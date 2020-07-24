package com.lqh.pay.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liqihua
 * @date 2020/6/3
 */
@RestController
@RequestMapping("pay")
public class PayController {

    @RequestMapping("create")
    public String pay(String uid) {
        return uid + "支付成功";
    }

    @RequestMapping("find")
    public String find(String uid) {
        return uid + "已经支付成功";
    }
}
