package com.hkjava.demo.demojmetertest.mapper;

import com.hkjava.demo.demojmetertest.dto.UserDTO;
import com.hkjava.demo.demojmetertest.entity.User;
import com.hkjava.demo.demojmetertest.model.UserRedis;

public class UserMapper {

  public static User map(UserDTO userDTO) {
    return User.builder() //
        .userId(userDTO.getUserId()) //
        .userName(userDTO.getName()) //
        .age(userDTO.getAge()) //
        .build();
  }

  public static UserRedis map(User user) {
    return UserRedis.builder() //
        .id(String.valueOf(user.getId())) //
        .userId(user.getUserId()) //
        .userName(user.getUserName()) //
        .age(String.valueOf(user.getAge())) //
        .build();
  }

  public static User map(UserRedis user) {
    return User.builder() //
        .id(Long.valueOf(user.getId())) //
        .userId(user.getUserId()) //
        .userName(user.getUserName()) //
        .age(Integer.valueOf(user.getAge())) //
        .build() //
    ;
  }

}
