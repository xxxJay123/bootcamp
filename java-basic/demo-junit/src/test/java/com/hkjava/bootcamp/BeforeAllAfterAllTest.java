package com.hkjava.bootcamp;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BeforeAllAfterAllTest {

  private int x;
  
  @BeforeAll
  void beforeAll() {
    System.out.println("beforeAll start x=");
  }

  @AfterAll
  void afterAll() {
    System.out.println("afterAll start");
  }

  @Test
  void test() { // instance method
    this.x++; // this.x
    System.out.println("test x="+ this.x);
    assertTrue(x == 1);
  }

  @Test
  void test2() {
    x++;
    System.out.println("test2 x="+ x);
    assertTrue(x == 2);
  }
}
