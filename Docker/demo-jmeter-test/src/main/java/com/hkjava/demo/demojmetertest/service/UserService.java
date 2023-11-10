package com.hkjava.demo.demojmetertest.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hkjava.demo.demojmetertest.entity.User;
import com.hkjava.demo.demojmetertest.infra.RedisHelper;
import com.hkjava.demo.demojmetertest.mapper.UserMapper;
import com.hkjava.demo.demojmetertest.model.UserRedis;
import com.hkjava.demo.demojmetertest.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserRedisService userRedisService;

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public User save(User user) {
    return userRepository.save(user);
  }

  public User findById(Long id) {
    Optional<UserRedis> userFromRedis = userRedisService.get(id);
    if (userFromRedis.isPresent())
      return UserMapper.map(userFromRedis.get());
    Optional<User> userFromDb = userRepository.findById(id);
    if (userFromDb.isPresent()) {
      userRedisService.setUser(UserMapper.map(userFromDb.get()));
      return userFromDb.get();
    }
    throw new EntityNotFoundException("User Not Found id=" + id);
  }

}
