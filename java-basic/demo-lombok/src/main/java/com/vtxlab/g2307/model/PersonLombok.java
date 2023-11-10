package com.vtxlab.g2307.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter 
@Builder
@ToString(onlyExplicitlyIncluded = true)
public class PersonLombok {
  
  private String name;

  @ToString.Include
  private int age;

  public static void main(String[] args) {
    
    PersonLombok personLombok = new PersonLombok("Peter",13); // all args constructor
    PersonLombok p2 = new PersonLombok();
    p2.setAge(13);
    p2.setName("Eric");
    // System.out.println(p2.getAge()); // 13
    System.out.println(p2.getName()); // Eric

    System.out.println(p2.toString()); // PersonLombok(age=13)
  }
}
