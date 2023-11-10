package shapes;

import java.math.BigDecimal;

public abstract class Shape { // implicitly extends Object

  public abstract double area(); // area()

  public static void main(String[] args) {
    // BigDeimal Example
    double total = 0.0d;
    BigDecimal b = BigDecimal.valueOf(total);
    b = b.add(BigDecimal.valueOf(5));
    System.out.println(b.doubleValue()); // 5.0

    // Shapes area() example
    Circle10 circle = new Circle10(10.0d);
    Square10 square = new Square10(3.0d);
    Shape[] shapes = new Shape[] {circle, square}; //
    System.out.println(Shape.area(shapes)); // 10 * 10 * PI + 3 * 3
  }
  //
  public static double area(Shape[] shapes) {
    BigDecimal total = BigDecimal.valueOf(0);
    for (Shape s : shapes) {
      total = total.add(BigDecimal.valueOf(s.area()));
    }
    return total.doubleValue();
  }

}
