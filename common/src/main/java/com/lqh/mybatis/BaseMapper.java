package com.lqh.mybatis;

import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author liqihua
 * @date 2020/6/20
 */
public interface BaseMapper<T> extends Mapper<T>, IdsMapper<T> {
}
