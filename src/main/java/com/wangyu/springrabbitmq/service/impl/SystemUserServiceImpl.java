package com.wangyu.springrabbitmq.service.impl;

import com.wangyu.springrabbitmq.common.base.impl.BaseServiceImpl;
import com.wangyu.springrabbitmq.dao.SystemUserMapper;
import com.wangyu.springrabbitmq.entity.SystemUser;
import com.wangyu.springrabbitmq.service.SystemUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务层实现
 *
 * @Author wangyu
 * @Date 2019/9/26 11:47
 * @Version 1.0
 */
@Service("systemUserService")
public class SystemUserServiceImpl extends BaseServiceImpl<SystemUser> implements
    SystemUserService {

  private static Logger LOG = LoggerFactory.getLogger(SystemUserServiceImpl.class);

  @Autowired
  private SystemUserMapper userMapper;

}
