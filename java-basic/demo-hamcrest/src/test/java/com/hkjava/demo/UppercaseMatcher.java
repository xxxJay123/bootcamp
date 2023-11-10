package com.hkjava.demo;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class UppercaseMatcher extends TypeSafeMatcher<String> {
  //  1 <- 100 -> 199
  @Override
  protected boolean matchesSafely(String str) {
    return str.matches("[A-Z]+");
  }

  @Override
  public void describeTo(Description description) {
    description.appendText("String should contain uppercase letter only.");
  }

  public static Matcher<String> containUppercaseOnly() {
    return new UppercaseMatcher();
  }
}
