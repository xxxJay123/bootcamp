package com.hkjava.demo.demojunittest.service;

import org.springframework.stereotype.Service;
import com.hkjava.demo.demojunittest.model.Student;

@Service
public class StudentService {

  public String getStudentName(String name) {
    if (name == null)
      throw new IllegalArgumentException();
    return this.getDB(); // mock "Mary"
  }

  public String getDB() { // get DB
    return new Student("John", 30).concat("Chan");
  }

  
}
