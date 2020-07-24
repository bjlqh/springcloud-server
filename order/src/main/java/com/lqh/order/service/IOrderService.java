package com.lqh.order.service;

import com.lqh.domain.Order;
import com.lqh.mybatis.IBaseService;

import java.util.List;

/**
 * @author liqihua
 * @date 2020/6/17
 */
public interface IOrderService extends IBaseService<Order> {

    Order create(Order order);

    List<Order> selectAll();
}
