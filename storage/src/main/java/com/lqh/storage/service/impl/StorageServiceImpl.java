package com.lqh.storage.service.impl;

import com.lqh.domain.Storage;
import com.lqh.mybatis.BaseServiceImpl;
import com.lqh.storage.mapper.StorageMapper;
import com.lqh.storage.service.IStorageService;
import org.springframework.stereotype.Service;

/**
 * @author liqihua
 * @date 2020/6/17
 */
@Service
public class StorageServiceImpl extends BaseServiceImpl<StorageMapper, Storage> implements IStorageService {
    @Override
    public void decrease(Storage entity) {
        Long productId = entity.getProductId();
        Storage condition = new Storage();
        condition.setProductId(productId);
        Storage storage = this.mapper.select(condition).get(0);
        Integer total = storage.getTotal();
        Integer used = entity.getUsed();
        if (total >= used) {
            storage.setTotal(total - used);
            this.mapper.updateByPrimaryKeySelective(storage);
        } else {
            throw new RuntimeException("库存不足");
        }

    }
}
