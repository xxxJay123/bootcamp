package com.hkjava.codetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class MockTest {

  @Mock
  Calculator calculator;

  @InjectMocks
  Checkout checkout;

  @Test
  void testSubstract() {
    Calculator selfNew = new Calculator(3);
    assertEquals(-7, selfNew.substract(10, 6));
    assertEquals(6, selfNew.multiply(2, 3));
  }

  @Test
  void testAdd1() {
    when(calculator.substract(3, 4)).thenReturn(100);
    int result = checkout.add(3, 4); // Scenario: x > 1
    assertEquals(104, result);
    verify(calculator, times(1)).substract(3, 4);
  }

  @Test
  void testAdd2() {
    when(calculator.substract(1, 4)).thenReturn(1000);
    int result = checkout.add(1, 4); // Scenario: x <= 1
    assertEquals(5, result);
    verify(calculator, never()).substract(1, 4);
  }

  @Test
  void testMultiply() {
    when(calculator.substract(7, 9)).thenReturn(10000);
    when(calculator.multiply(7, 9)).thenReturn(10000);
    int result = checkout.multiply(7, 9); // Scenario: x <= 1
    assertEquals(10009, result);
  }

  @Test
  void testMultiply2() {
    when(calculator.substract(-1, 8)).thenReturn(10000);
    int result = checkout.multiply(-1, 8); // 0 + 10000
    assertEquals(10000, result);
  }

}
