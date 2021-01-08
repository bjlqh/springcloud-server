package com.lqh.order.feign;

import com.lqh.common.ResponseResult;
import com.lqh.domain.Storage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author liqihua
 * @date 2020/6/20
 */
@FeignClient(value = "storage-service")
public interface StorageFeignClient {

    @PutMapping("/storage/decrease")
    ResponseResult decrease(@RequestBody Storage storage);
}
