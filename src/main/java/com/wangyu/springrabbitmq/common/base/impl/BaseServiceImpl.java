package com.wangyu.springrabbitmq.common.base.impl;

import com.google.common.collect.Lists;
import com.wangyu.springrabbitmq.common.base.BaseMapper;
import com.wangyu.springrabbitmq.common.base.BaseService;
import com.wangyu.springrabbitmq.common.base.BaseEntity;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author wangyu
 * @Date 2019/9/26 14:48
 * @Version 1.0
 */
public class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

  @Autowired
  protected BaseMapper<T> baseMapper;

  @Override
  public T get(Serializable id) {
    return baseMapper.get(id);
  }

  @Override
  public List<T> findList(Map<String, Object> map) {
    return baseMapper.findList(map);
  }

  @Override
  public List<T> findAll() {
    return baseMapper.findList(new HashMap<String,Object>());
  }

  @Override
  public List<T> findByIds(Long[] ids) {
    if(ids!=null && ids.length>0){
      return baseMapper.findByIds(ids);
    }
    return Lists.newArrayList();
  }

  @Override
  public long countNums(Map<String, Object> map) {
    return baseMapper.countNums(map);
  }

  @Override
  public int insert(T entity) {
    return baseMapper.insert(entity);
  }

  @Override
  public int update(T entity) {
    return baseMapper.update(entity);
  }

  @Override
  public int delete(T entity) {
    return baseMapper.delete(entity);
  }

  @Override
  public int delete(Serializable id) {
    return baseMapper.delete(id);
  }

  @Override
  public int batchDelete(Long[] ids) {
    return baseMapper.batchDelete(ids);
  }
}
