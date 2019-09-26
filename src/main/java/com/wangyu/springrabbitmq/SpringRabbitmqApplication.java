package com.wangyu.springrabbitmq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wangyu.springrabbitmq.dao")
public class SpringRabbitmqApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringRabbitmqApplication.class, args);
  }

}
