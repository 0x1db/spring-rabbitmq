package com.wangyu.springrabbitmq.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import com.wangyu.springrabbitmq.entity.SystemUser;
import com.wangyu.springrabbitmq.service.SystemUserService;
import java.util.List;
import java.util.Map;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.AbstractJavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制层
 *
 * @Author wangyu
 * @Date 2019/9/26 11:53
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class SystemController {

  @Autowired
  private SystemUserService systemUserService;
  @Autowired
  private RabbitTemplate rabbitTemplate;
  @Autowired
  private ObjectMapper objectMapper;

  @GetMapping("/{id}")
  public String getOne(@PathVariable("id") String id) {
    Map<String, Object> map = Maps.newHashMap();
    map.put("id", id);
    List<SystemUser> list = systemUserService.findList(map);
    rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
    rabbitTemplate.setExchange("local.log.user.exchange.name");
    rabbitTemplate.setRoutingKey("local.log.user.routing.key.name");

    Message message= null;
    try {
      message = MessageBuilder.withBody(objectMapper.writeValueAsBytes(list.get(0))).setDeliveryMode(
          MessageDeliveryMode.PERSISTENT).build();
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    message.getMessageProperties().setHeader(AbstractJavaTypeMapper.DEFAULT_CONTENT_CLASSID_FIELD_NAME, MessageProperties.CONTENT_TYPE_JSON);
    rabbitTemplate.convertAndSend(message);
    return list.get(0).getNickName();
  }

  @PostMapping("/")
  public void save(@RequestBody SystemUser user) {
    systemUserService.insert(user);
  }
}
