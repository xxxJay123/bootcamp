// Outer Class
// Can Access static nested class attribute

import java.util.ArrayList;
import java.util.List;

public class Student { // Outer class

  private String name;
  // constructor, getter, setter, static method & variable
  private Bag bag;

  public Student(String name) {
    this.name = name;
    bag = new Student.Bag(); // Bag Con
  }

  // method -> Bag.method, instance variable
  public int getBagSize() {
    return new Student.Bag().getSize();
  }

  public void clearBag() {
    // Outer Class access "Static nested class" static method
    Bag.clear(this.bag);
  }

  public static int add(int a, int b) {
    return a + b;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public String toString() {
    return "Student[name=" + this.name //
        + "," + this.bag + "]" //
        + "]";
  }

  // Static nested class
  // Cannot access Outer Class Attribute
  private static class Bag {
    int size;
    List<String> strings;

    // constuctor
    // getter, setter
    // instance method
    public int getSize() {
      return this.size;
    }

    // static method & variable
    public static void clear(Bag bag) {
      bag.strings.clear();
      // add(1 + 3); compile-error
    }

    public void printStudentGrade() {
      System.out.println();
    }

    public static void printHello() {
      Grade.printHello();
    }

    @Override
    public String toString() {
      return "Bag[size=" + this.size //
          + ",strings=" + this.strings //
          + "]";
    }

  }
  // Inner class (non-static nested class)
  public class Grade {
    int score;

    public int getScore() {
      return this.score;
    }

    // isMale()
    // isElderly()
    public char getGrade() {
      switch (this.score) {
        case 90:
          return 'A';
        case 80:
          return 'B';
        case 70:
          return 'C';
        default:
          return 'F';
      }
    }

    public Grade(int score) {
      this.score = score;
    }

    public void printStudentName() {
      System.out.println(Student.this.getName()); // John
    }

    public static void printHello() {
      System.out.println("Hello");
    }

  }

  public static void main(String[] args) {
    Student student = new Student("John"); // Student's constructor
    Student.Bag bag = new Student.Bag(); // Bag's constructor

    System.out.println(student.toString()); // name, bag

    Student.Grade grade = student.new Grade(70);
    grade.printStudentName(); // John

    List list = new ArrayList<>();
    list.add("abc");
    list.add(123);
    list.add('a');
    int a = (Integer) list.get(1);

    
  }


}
