package box;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class Box<T extends Number> { // any class extending Object

  private ArrayList<T> numbers;

  private Box() {
    numbers = new ArrayList<>();
  }

  public Box(T number) {
    this(); // the empty constructor of Class Box
    numbers.add(number);
  }

  public ArrayList<T> getNumbers() {
    return this.numbers;
  }

  public void add(T number) {
    numbers.add(number); // null pointer
  }

  public int size() {
    return numbers.size();
  }

  // public void setNumbers(T[] numbers) {
  // this.numbers = numbers;
  // }

  public static void main(String[] args) {
    // Box<String> box1 = new Box<>();
    Box<Number> box1 = new Box<>(100); // compile-time check
    System.out.println(box1.size()); // 1
    // box1 = new Box<>("abc");  // new Box<>("abc") is not Box<Number>

    Collections.sort(null, null);
  }
}
