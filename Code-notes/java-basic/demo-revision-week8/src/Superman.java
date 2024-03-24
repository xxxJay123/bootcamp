import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalInt;

public class Superman implements Flyable {
  @Override
  public void fly() {
    System.out.println("I am flying");
  }

  public static void main(String[] args) {
    // 3 ways to new a flyable object
    // 1. Polymorphism
    Flyable superman = new Superman();
    // 2. Anonymous
    Flyable superman2 = new Flyable() {
      @Override
      public void fly() {
        System.out.println("I am Anonymous");
      }
    };
    // 3. Lambda
    Flyable superman3 = () -> System.out.println("I am Lambda");

    Optional<String> string = Optional.ofNullable("abc");
    // int sum = 0;
    string.ifPresent(e -> {
      // sum++;
      // String s = "";
    });
    // s = s + "hello";

    int total = 0;
    if (string.isPresent()) {
      total++;
      // String s = "";
    }
    // s = s + "";
    // Comparator
    System.out.println("yes");
    int[] count = {1,2,3,4};
    System.out.println(Arrays.stream(count)
        .min()
        .getAsInt()); // 1
        // .count(); // 4

  }

  public static double add(double a, double b) {
    return BigDecimal.valueOf(a).add(BigDecimal.valueOf(b)).doubleValue();
  }

}
