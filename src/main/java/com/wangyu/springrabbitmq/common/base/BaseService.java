package com.wangyu.springrabbitmq.common.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Author wangyu
 * @Date 2019/9/26 14:44
 * @Version 1.0
 */
public interface BaseService<T extends BaseEntity> {

  /**
   * 获取单条数据
   * @param id
   * @return
   */
  T get(Serializable id);

  /**
   * 查询列表数据
   * @param map
   * @return
   */
  List<T> findList(Map<String,Object> map);

  /**
   * 查询所有数据
   * @return
   */
  List<T> findAll();

  /**
   * 查询列表数据,根据数据ids
   * @param ids
   * @return
   */
  List<T> findByIds(Long[] ids);

  /**
   * 查询分页数据
   * @param page 分页对象
   * @return
   */
//  Page<T> findList(Page<T> page);


  /**
   * 统计个数
   * @param map
   * @return
   */
  long countNums(Map<String,Object> map);

  /**
   * 插入数据
   * @param entity
   */
  int insert(T entity);

  /**
   * 更新数据
   * @param entity
   */
  int update(T entity);

  /**
   * 删除数据
   * @param entity
   */
  int delete(T entity);

  /**
   * 删除数据
   * @param id
   */
  int delete(Serializable id);


  /**
   * 批量删除
   * @param ids
   * @return
   */
  int batchDelete(Long[] ids);
}
