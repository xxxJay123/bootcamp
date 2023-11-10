public class Book {

  // 17 types
  // custom class
  // Data structires (array, list, etc)
  // Constructor (private, public, overloading, method signature, etc)
  // method (private, public, overloading, method signature, etc)
  // build pattern
  // getter setter, lombok, toString

  public String getHello() {
    return "hello";
  }

  public static void main(String[] args) {
    Object x = "123";  // local variable
    if (x instanceof String) {
      System.out.println("it is string");
    }
    x = 123; // local variable
    if (x instanceof Integer) {
      System.out.println("it is integer");
    }
    Object y = new Square(7);
    Shape s = new Square(9);
    if (s instanceof Square) {
      System.out.println("it is a square");
    }
    if (y instanceof Square) {
      System.out.println("it is a square");
    }
    System.out.println(s.area()); // 81.0
    // but you cannot s.setLength()
    
  }
}
