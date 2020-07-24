package com.lqh.order.controller;

import com.lqh.common.RequestStatus;
import com.lqh.common.ResponseResult;
import com.lqh.domain.Order;
import com.lqh.order.feign.PayFeignClient;
import com.lqh.order.service.IOrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liqihua
 * @date 2020/6/3
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Resource
    private PayFeignClient payFeignClient;
    @Resource
    private IOrderService orderService;

    @RequestMapping("create")
    @GlobalTransactional
    public ResponseResult create(@RequestBody Order entity) {
        Order order = orderService.create(entity);
        return new ResponseResult(true, RequestStatus.OK, "订单" + order.getId() + "，创建成功");
    }

    @RequestMapping("selectAll")
    public List<Order> selectAll() {
        return orderService.selectAll();
    }

}
