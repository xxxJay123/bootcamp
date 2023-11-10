package com.hkjava.demo.demojunittest.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import javax.swing.text.html.parser.Entity;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.hkjava.demo.demojunittest.mapper.EntityMapper;
import com.hkjava.demo.demojunittest.model.Student;
import com.hkjava.demo.demojunittest.repository.StudentRepository;

@Service
public class StudentService {

  @Autowired
  private StudentRepository studentRepository;

  @Value(value = "${api.jmeter.domain}")
  private String domain;

  @Value(value = "${api.jmeter.basePath}")
  private String basePath;

  @Value(value = "${api.jmeter.endpoint}")
  private String endpoint;

  @Autowired
  private RestTemplate restTemplate;

  public String getStudentName(String name) {
    if (name == null)
      throw new IllegalArgumentException();
    return this.getDB(); // mock "Mary"
  }

  public String getDB() { // get DB
    return new Student("John", 30).concat("Chan");
  }

  public List<Student> findAll() {
    return studentRepository.findAll().stream() //
        .map(e -> EntityMapper.map(e)) //
        .collect(Collectors.toList());
  }

  public String jmeterTest() {
    String url = UriComponentsBuilder.newInstance() //
        .scheme("http") //
        .host(domain) //
        .pathSegment(basePath) //
        .path(endpoint) //
        .build() //
        .toUriString();
    System.out.println("demo-junit-test: url=" + url);
    try {
      return restTemplate.getForObject(url, String.class);
    } catch (RestClientException e) {
      System.out.println("error");
      return null;
    }
  }
}
