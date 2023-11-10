package com.hkjava.bootcamp;

import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_METHOD) // default
@DisplayName("Assert Method Tests")
public class AssertTest {

  private int x; // instance variable
  
  @Test
  @DisplayName("AssertEquals Test")
  void testAssertEqual() {
    // Assertions.assertEquals(expected value, actual value);
    assertEquals(5, App.add(2, 3));
    assertEquals(7, App.add(2, 5));
    assertEquals(0, App.add(0, 0));
    assertEquals(-8, App.add(-6, -2));
    x++;
    assertEquals(1, x);
  }

  @Test
  @DisplayName("AssertNotEquals Test")
  void testAssertNotEqual() {
    assertNotEquals(4, App.add(1, 2));
    x++;
    assertEquals(1, x);
  }

  @Test
  void testAssertTrue() {
    assertTrue(12 == App.add(7, 5));
  }

  @Test
  void testAssertFalse() {
    assertFalse(13 == App.add(7, 5));
  }

  @Test
  void testAssertNull() {
    String str = null;
    assertNull(str);
  }

  @Test
  void testAssertNotNull() {
    Student student = new Student();
    assertNotNull(student.getSubjects());
  }

  @Test
  void testAssertThrows() {
    assertThrows(ArithmeticException.class, () -> {
      App.divide(10, 0);
    });

    assertDoesNotThrow(() -> {
      App.divide(10, 5);
    });
  }

  @Test
  void testAssertNotTimeout() {
    assertTimeout(Duration.ofMillis(100), () -> {
      Thread.sleep(50); // ms
    });
  }

  @Test
  void testCombine() {
    assertAll(
      () -> assertTrue(10 > 3),
      () -> assertEquals(10, App.add(4, 6)),
      () -> assertNull(null)
    );
  }

  @Test
  void testSame() {
    String s1 = new String("JUnit");
    String s2 = new String("JUnit");
    assertNotSame(s1, s2); // test object reference
    assertEquals(s1, s2);
    
    String s3 = "JUnit";
    String s4 = "JUnit";
    assertSame(s3, s4);
    assertEquals(s3, s4);
  }


}
