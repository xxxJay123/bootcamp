public record Person1(String name, int age) implements TestInterface {
  // Immutable Objects
  // final class, support Generics
  // Support Interface, but cannot further extend (extends Object.class)
  // private final String name;
  // private final int age;
  // All-args constructor ONLY
  // All Getters
  // No Setters (final instance variable)
  // custom static methods, static variables
  // custom constant
  // custom instance methods
  // No other instance variables
  // Already @Override equals(), hashCode(), toString()

  // int salary;

  static int counter = 0; // class variable

  static final int MIN_PAY = 50; // constant

  public boolean isElderly(int age) {
    return age >= 65;
  }

  @Override
  public void read() {

  }

  // Tools
  public static int add(int x, int y) {
    return x + y;
  }

}
