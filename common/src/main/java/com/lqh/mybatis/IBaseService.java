package com.lqh.mybatis;

import java.io.Serializable;
import java.util.List;

/**
 * @author liqihua
 * @date 2020/6/20
 */
public interface IBaseService<T> {

    boolean insert(T var1);

    T selectById(Serializable var1);

    Integer deleteById(Serializable var1);

    Integer updateById(T var1);

    Integer updateByIdSelective(T var1);

    T selectOne(T var1);

    List<T> selectByIds(String var1);

    int deleteByIds(String var1);

    List<T> queryListByEntity(T var1);
}
