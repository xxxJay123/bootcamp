package com.hkjava.demo.demojmetertest.service;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hkjava.demo.demojmetertest.entity.User;
import com.hkjava.demo.demojmetertest.infra.RedisHelper;
import com.hkjava.demo.demojmetertest.model.UserRedis;

public class UserRedisService extends RedisHelper {

  private static final String domainService = "demojmetertest:user";

  private static final String key;

  private static final String uuid;

  static {
    uuid = UUID.randomUUID().toString();
    key = getServiceKey();
  }

  public UserRedisService(RedisConnectionFactory factory) {
    super(factory);
  }

  public Optional<UserRedis> get(Long userId) {
    String userKey = key.concat(":").concat(userId.toString());
    Object obj = super.get(userKey); // return Object.class
    if (obj == null)
      return Optional.empty();
    UserRedis user = new ObjectMapper().convertValue(obj, UserRedis.class);
    return Optional.of(user);
  }

  public void setUser(UserRedis user) {
    String userKey = key.concat(":").concat(user.getId().toString());
    super.set(userKey, user);
  }

  private static String getServiceKey() {
    return domainService.concat(":").concat(uuid);
  }


}
