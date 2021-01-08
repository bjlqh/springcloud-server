package com.lqh.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liqihua
 * @date 2020/6/4
 */
@FeignClient(value = "pay-service")
public interface PayFeignClient {

    @RequestMapping(value = "/pay/create", method = RequestMethod.GET, consumes = "application/json")
    String pay(@RequestParam("uid") String uid);
}
