package com.hkjava.demo;

import static com.hkjava.demo.UppercaseMatcher.*;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;

public class CustomMatcherTest {

  @Test
  void customMatcherTest() {
    String str = "HELLOWORLD";
    String str2 = "HELLO world";
    String str3 = "hello world";

    assertThat(str, containUppercaseOnly());
    assertThat(str2, not(containUppercaseOnly()));
    assertThat(str3, not(containUppercaseOnly()));
  }
}
