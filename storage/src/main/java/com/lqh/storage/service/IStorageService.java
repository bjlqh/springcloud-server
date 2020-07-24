package com.lqh.storage.service;

import com.lqh.domain.Storage;
import com.lqh.mybatis.IBaseService;

/**
 * @author liqihua
 * @date 2020/6/17
 */
public interface IStorageService extends IBaseService<Storage> {

    void decrease(Storage storage);
}
