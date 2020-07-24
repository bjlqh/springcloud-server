package com.lqh.mybatis;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * @author liqihua
 * @date 2020/6/20
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T extends Serializable> implements IBaseService<T> {

    @Autowired
    protected M mapper;

    public M getMapper() {
        return mapper;
    }

    public void setMapper(M mapper) {
        this.mapper = mapper;
    }

    @Override
    public boolean insert(T var1) {
        int count = this.mapper.insert(var1);
        return count >= 1;
    }

    @Override
    public T selectById(Serializable id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer deleteById(Serializable id) {
        return this.mapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer updateById(T var1) {
        return this.mapper.updateByPrimaryKey(var1);
    }

    @Override
    public Integer updateByIdSelective(T var1) {
        return this.mapper.updateByPrimaryKeySelective(var1);
    }

    @Override
    public T selectOne(T var1) {
        return this.mapper.selectOne(var1);
    }

    @Override
    public List<T> selectByIds(String ids) {
        return this.mapper.selectByIds(ids);
    }

    @Override
    public int deleteByIds(String ids) {
        return this.mapper.deleteByIds(ids);
    }

    @Override
    public List queryListByEntity(T entity) {
        return this.mapper.select(entity);
    }
}
