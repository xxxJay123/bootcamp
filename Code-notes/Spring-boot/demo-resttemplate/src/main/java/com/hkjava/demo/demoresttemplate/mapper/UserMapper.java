package com.hkjava.demo.demoresttemplate.mapper;

import com.hkjava.demo.demoresttemplate.model.User;
import com.hkjava.demo.demoresttemplate.model.UserDTO;

public class UserMapper {

  public static UserDTO map(User user) {
    return UserDTO.builder() //
        .id(user.getId()) //
        .name(user.getName()) //
        .username(user.getUsername()) //
        .build();
  }
  
}
