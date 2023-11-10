package shape;

import java.math.BigDecimal;
import java.util.List;

public class Circle extends Shape {
  int radius;

  @Override
  public double area() {
    return Math.pow(this.radius, 2) * Math.PI;
  }

 
}
