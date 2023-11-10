package shape;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Shape {
  abstract double area(); // implicitly public

  // public static double area(List<? extends Shape> shapes) {
  public static <T extends Shape> double area(List<T> shapes) {
    BigDecimal total = BigDecimal.ZERO;
    // shapes.add(new Circle()); // compile-time check, type-safe
    for (Shape shape : shapes) {
      total = total.add(BigDecimal.valueOf(shape.area()));
    }
    return total.doubleValue();
  }

  public static void main(String[] args) {
    Shape shape = new Circle(); // Polymorphism
    Shape shape2 = new Square(); // Polymorphism
    List<Shape> shapes = new ArrayList<>();
    shapes.add(new Circle());
    // shapes = new ArrayList<Circle>(); // compile-error

    List<? extends Shape> list = new ArrayList<Circle>();
    list = new ArrayList<Square>(); // OK
    // list.add(new Circle()); // compile check refer to declaration
    for (Shape s : list) {
      s.area();
    }
    List<Map<String, String>> list2 = new ArrayList<>();
    list2.add(new HashMap<>());
  }

}
