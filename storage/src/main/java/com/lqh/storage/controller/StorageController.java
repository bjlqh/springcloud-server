package com.lqh.storage.controller;

import com.lqh.common.RequestStatus;
import com.lqh.common.ResponseResult;
import com.lqh.domain.Storage;
import com.lqh.storage.service.IStorageService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liqihua
 * @date 2020/6/17
 */
@RestController
@RequestMapping("storage")
public class StorageController {

    @Resource
    private IStorageService storageService;

    @PutMapping("decrease")
    public ResponseResult decrease(@RequestBody Storage storage) {
        storageService.decrease(storage);
        return new ResponseResult(true, RequestStatus.OK, storage.getProductId() + "库存扣减成功");
    }
}
