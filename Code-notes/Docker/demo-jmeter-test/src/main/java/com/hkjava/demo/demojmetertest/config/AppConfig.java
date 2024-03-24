package com.hkjava.demo.demojmetertest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import com.hkjava.demo.demojmetertest.service.UserRedisService;

@Configuration
public class AppConfig {

  @Bean
  UserRedisService userRedisService(RedisConnectionFactory factory) {
    return new UserRedisService(factory);
  }

}
