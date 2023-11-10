package objects;

import java.util.Objects;
import shapes.Circle10;
import shapes.Shape;

public class ObjectDemo {
  // Rule 1: All class extends Object implicitly
  String name = "hello";


  public static void main(String[] args) {
    // Example 1: ObjectDemo extends Object
    ObjectDemo objectDemo = new ObjectDemo();
    // hash code -> int
    objectDemo.hashCode(); // another presentation of object reference
    // Because hash code has a short range of value storage
    // so, it cannot store all memory address (object reference) in your machine

    int[] arr = new int[] {1, 2, 3};
    System.out.println(arr); // [I@6b95977
    System.out.println(arr.toString()); // [I@6b95977

    Integer i = 1;
    System.out.println(i); // = i.toString()


    String str = "abc";
    System.out.println(str); // abc

    System.out.println(objectDemo); // objects.ObjectDemo@7344699f
    System.out.println(objectDemo.toString()); // objects.ObjectDemo@7344699f

    System.out.println("abc hashcode()=" + str.hashCode()); // 96354
    // a * 31^2 + b * 31^1 + c
    System.out.println(97 * (int) Math.pow(31, 2) + 98 * 31 + 99); // 96354

    Integer i1 = 3;
    System.out.println(i1.hashCode()); // 3
    Long l1 = 100L;
    System.out.println(l1.hashCode()); // overflow

    ObjectDemo a = new ObjectDemo();
    ObjectDemo b = new ObjectDemo();
    System.out.println(a); // toString() -> hashCode
    System.out.println(b); // toString() -> hashCode
    System.out.println(a == b); // address (object reference)

    // equals()
    String s1 = "abc";
    String s2 = "abc";
    System.out.println(s1.equals(s2)); // true

    // instanceOf, Object.class
    Object obj = new String("abc"); // obj is an object reference (address)
    System.out.println(obj instanceof String); // true
    obj = Long.valueOf(10);
    System.out.println(obj instanceof String); // false
    System.out.println(obj instanceof Long); // true

    Shape shape = new Circle10(5.0d);
    // shape.print(); // no print() method in shape
    // Hide child print() method
    System.out.println(shape.area()); // 78.53981633974483, 5 * 5 * PI
    Circle10 c = (Circle10) shape;
    c.print(); // I am circle10

    // Number
    Integer int1 = Integer.valueOf(100);
    System.out.println(int1 instanceof Number); // true
    Double d1 = Double.valueOf(100);
    System.out.println(d1 instanceof Number); // true

    // Primitives, for comparsion, we use ==

    // Wrapper Class, for comparsion, we use equals
    Integer j1 = 128;
    Integer j2 = 128;
    System.out.println(j1.equals(j2)); // true
    j1 = 127;
    j2 = 127;
    System.out.println(j1.equals(j2)); // true
    Boolean bool1 = false;
    Boolean bool2 = false;
    System.out.println(bool1.equals(bool2)); // true

    System.out.println(bool1.equals(false));


  }


}
