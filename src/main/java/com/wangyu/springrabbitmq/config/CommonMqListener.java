package com.wangyu.springrabbitmq.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wangyu.springrabbitmq.entity.SystemUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * 消费端
 *
 * @Author wangyu
 * @Date 2019/9/26 17:11
 * @Version 1.0
 */
@Component
public class CommonMqListener {

  private static final Logger log = LoggerFactory.getLogger(CommonMqListener.class);

  @Autowired
  private ObjectMapper objectMapper;

  @RabbitListener(queues = "local.log.user.queue.name", containerFactory = "singleListenerContainer")
  public void consumeUserLogQueue(@Payload byte[] message) {
    try {
      SystemUser systemUser = objectMapper.readValue(message, SystemUser.class);
      log.info("监听消费用户日志 监听到消息： {} ", systemUser.getNickName());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
