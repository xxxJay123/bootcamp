package swimable;
// Annotation: check if this interface has one abstarct method only
// if no, compile-error

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@FunctionalInterface
public interface Swimable {
  void swim();

  public static void main(String[] args) {
    // Lambda: You have to use "return", if you use {}
    Comparator<Person> sortByNameDesc = (Person p1, Person p2) -> {
      return p2.name.charAt(0) > p1.name.charAt(0) ? 1 : -1;
    };
    List<Person> persons =
        Arrays.asList(new Person("Alison"), new Person("Eric"));
    Collections.sort(persons, sortByNameDesc);
    System.out.println(persons);

    // new object <- "() -> System.out.println("Person 1 is swimming");"
    Swimable person1 = () -> System.out.println("Person 1 is swimming");
    person1.swim();

    Swimable person2 = () -> {
      System.out.println("Person 2 starts to swim");
      System.out.println("Person 2 stop swimming");
    };
    person2.swim();

    Swimable person3 = () -> {
      System.out.println("Person 3 starts to swim");
    };
    person3.swim();
  }
}
