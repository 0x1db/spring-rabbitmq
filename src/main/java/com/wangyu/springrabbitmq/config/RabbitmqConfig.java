package com.wangyu.springrabbitmq.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author wangyu
 * @Date 2019/9/26 16:36
 * @Version 1.0
 */
@Configuration
public class RabbitmqConfig {

  private static final Logger LOG = LoggerFactory.getLogger(RabbitmqConfig.class);


  @Autowired
  private CachingConnectionFactory connectionFactory;

  @Autowired
  private SimpleRabbitListenerContainerFactoryConfigurer factoryConfigurer;

  /**
   * 单一消费者
   * @return
   */
  @Bean(name = "singleListenerContainer")
  public SimpleRabbitListenerContainerFactory listenerContainer(){
    SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
    factory.setConnectionFactory(connectionFactory);
    factory.setMessageConverter(new Jackson2JsonMessageConverter());
    factory.setConcurrentConsumers(1);
    factory.setMaxConcurrentConsumers(1);
    factory.setPrefetchCount(1);
    factory.setTxSize(1);
    factory.setAcknowledgeMode(AcknowledgeMode.AUTO);
    return factory;
  }

  @Bean
  public RabbitTemplate rabbitTemplate(){
    connectionFactory.setPublisherConfirms(true);
    connectionFactory.setPublisherReturns(true);
    RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
    rabbitTemplate.setMandatory(true);
    rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
      @Override
      public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        LOG.info("消息发送成功:correlationData({}),ack({}),cause({})",correlationData,ack,cause);
      }
    });
    rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
      @Override
      public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        LOG.error("消息丢失:exchange({}),route({}),replyCode({}),replyText({}),message:{}",exchange,routingKey,replyCode,replyText,message);
      }
    });
    return rabbitTemplate;
  }

  @Bean(name = "logUserQueue")
  public Queue logUserQueue(){
    return new Queue("local.log.user.queue.name",true);
  }

  @Bean
  public DirectExchange logUserExchange(){
    return new DirectExchange("local.log.user.exchange.name",true,false);
  }

  @Bean
  public Binding logUserBinding(){
    return BindingBuilder.bind(logUserQueue()).to(logUserExchange()).with("local.log.user.routing.key.name");
  }
}
