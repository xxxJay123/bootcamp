package com.vtxlab.g2307.model;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
// @AllArgsConstructor
public class Staff extends Human {
  private double salary;

  // You have to manually code the constructor with Parent's attributes
  public Staff(String name, double salary) {
    super(name);
    this.salary = salary;
  }

  public static void main(String[] args) {
    Staff s1 = new Staff("John", 3000.0);
    Staff s2 = new Staff("Peter", 3000.0);
    System.out.println(s1.equals(s2)); // true

    Staff s3 = new Staff("John", 3000.0);
    System.out.println(s1.equals(s3)); // true
  }
}
