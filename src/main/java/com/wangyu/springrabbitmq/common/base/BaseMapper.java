package com.wangyu.springrabbitmq.common.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Author wangyu
 * @Date 2019/9/26 14:49
 * @Version 1.0
 */
public interface BaseMapper<T> {

  /**
   * 获取单条数据
   */
  T get(Serializable id);

  /**
   * 根据指定id，查询数据列表
   */
  List<T> findByIds(Long[] ids);

  /**
   * 查询数据列表
   */
  List<T> findList(Map<String, Object> map);

  /**
   * 查询数据分页列表
   * @param page
   * @return
   */
//  List<T> findList(Page<T> page);

  /**
   * 按照条件统计
   */
  long countNums(Map<String, Object> map);


  /**
   * 查询所有数据列表
   */
  List<T> findAll();

  /**
   * 插入数据
   */
  int insert(T entity);

  /**
   * 更新数据
   */
  int update(T entity);

  /**
   * 删除数据
   *
   * @see public int delete(T entity)
   */
  int delete(Serializable id);

  /**
   * 删除数据
   */
  int delete(T entity);

  /**
   * 批量删除数据
   */
  int batchDelete(Long[] ids);
}
