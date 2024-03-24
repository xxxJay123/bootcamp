package crash;

public class X extends Y {

  private String name; // hiding

  public X() {

  }

  public X(String name) {
    super("John");
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public String getParentName() {
    return super.getName();
  }

  public static void staticMethod() {
    System.out.println("I am X");
  }

  public static void main(String[] args) {
    X x = new X("Peter");
    System.out.println(x.getName()); // Peter
    System.out.println(x.getParentName()); // John

    // Hiding
    Y y = new X("Tommy");
    y.staticMethod(); // I am Y, Hiding
    // You should practice and understand below syntax
    Y.staticMethod(); // I am Y
    X.staticMethod(); // I am X
    System.out.println(y.getName()); // Tommy
  }

}
