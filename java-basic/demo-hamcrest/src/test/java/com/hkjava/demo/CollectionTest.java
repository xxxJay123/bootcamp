package com.hkjava.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;

public class CollectionTest {

  @Test
  void testList() {
    List<String> strings = Arrays.asList("apple", "banana", "cherry");
    assertThat(strings, hasItem("cherry"));
    assertThat(strings, hasItems("cherry", "apple"));
    assertThat(strings, hasSize(3));
    // number of items + ordering
    assertThat(strings, contains("apple", "banana", "cherry")); 
    assertThat(strings, not(contains("apple", "cherry", "banana")));
    assertThat(strings, not(contains("apple", "cherry")));
    // number of items + ignore ordering
    assertThat(strings, containsInAnyOrder("apple", "cherry", "banana"));
    assertThat(strings, not(containsInAnyOrder("apple", "banana")));

    List<String> emptylist = new ArrayList<>();
    assertThat(emptylist, empty());
    
  }
}
