package com.lqh.order.feign;

import com.lqh.common.ResponseResult;
import com.lqh.domain.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author liqihua
 * @date 2020/6/20
 */
@FeignClient(value = "account-service")
public interface AccountFeignClient {

    @PutMapping("/account/decrease")
    ResponseResult decrease(@RequestBody Account entity);
}
