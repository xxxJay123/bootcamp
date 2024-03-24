package com.hkjava.demo.demojmetertest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hkjava.demo.demojmetertest.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  
}
