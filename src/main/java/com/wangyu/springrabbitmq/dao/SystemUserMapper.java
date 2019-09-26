package com.wangyu.springrabbitmq.dao;

import com.wangyu.springrabbitmq.common.base.BaseMapper;
import com.wangyu.springrabbitmq.entity.SystemUser;
import org.springframework.stereotype.Repository;

/**
 * 用户持久层
 *
 * @Author wangyu
 * @Date 2019/9/26 11:49
 * @Version 1.0
 */
@Repository("systemUserMapper")
public interface SystemUserMapper extends BaseMapper<SystemUser> {

}
