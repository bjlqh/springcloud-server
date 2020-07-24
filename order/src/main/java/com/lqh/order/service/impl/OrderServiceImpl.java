package com.lqh.order.service.impl;

import com.lqh.domain.Account;
import com.lqh.domain.Order;
import com.lqh.domain.Storage;
import com.lqh.mybatis.BaseServiceImpl;
import com.lqh.order.feign.AccountFeignClient;
import com.lqh.order.feign.StorageFeignClient;
import com.lqh.order.mapper.OrderMapper;
import com.lqh.order.service.IOrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liqihua
 * @date 2020/6/17
 */
@Slf4j
@Service
public class OrderServiceImpl extends BaseServiceImpl<OrderMapper, Order> implements IOrderService {

    @Resource
    private StorageFeignClient storageFeignClient;
    @Resource
    private AccountFeignClient accountFeignClient;

    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
    @Override
    public Order create(Order order) {
        //1.创建订单
        log.info("----->开始新建订单");
        order.setStatus(0);
        this.insert(order);

        //2.扣减库存
        log.info("----->订单微服务开始调用库存，做扣减Count");
        Storage storage = new Storage();
        storage.setProductId(order.getProductId());
        storage.setUsed(order.getCount());
        storageFeignClient.decrease(storage);
        log.info("----->订单微服务开始调用库存，做扣减end");

        //3.扣减账户余额
        log.info("----->订单微服务开始调用账户，做扣减Money");
        Account account = new Account();
        account.setUserId(order.getUserId());
        account.setUsed(order.getMoney());
        accountFeignClient.decrease(account);
        log.info("----->订单微服务开始调用账户，做扣减end");

        //4.修改订单状态
        log.info("----->修改订单状态开始");
        //int i=1/0;
        order.setStatus(1);
        this.updateByIdSelective(order);
        log.info("----->修改订单状态结束");
        return order;
    }

    @Override
    public List<Order> selectAll() {
        return this.mapper.selectAll();
    }
}
