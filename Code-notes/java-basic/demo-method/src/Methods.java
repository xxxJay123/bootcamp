public class Methods {

  public static void main(String[] args) { // method name: main()
    String str = "hello";
    str = str + " world"; // append operation

    // Approach 1
    System.out.println("Hello in print() method.");
    // Approach 2: by method
    print(); // print "Hello in print() method."

    // Approach 1
    int x = 10;
    int y = 100;
    int m = x + y; // m=110
    // Approach 2
    int z = sum(x, y); // z=110
    int i = sum(1000, -30); // 970
    int j = sum(80, 30); // 110

    // if (sum(1000, -30) == 970) {
    if (i == 970) {
      System.out.println("the sum is 970");
    }

    // call method2
    method2("hello"); // print string=hello
    method2("Github"); // print string=Github
    method2("");

    double circleArea = 5 * 5 * pi();
    System.out.println("circle area=" + circleArea);
  }

  public static void print() { // method name: print()
    System.out.println("Hello in print() method.");
  }

  public static int sum(int a, int b) {
    // left int = return type
    // the int inside the bracket are parameters
    int c = a + b;
    return c;
  }

  public static double substract(int x, int y) {
    return x - y; // execute x - y first, then return the result
  }

  public static void method2(String str) {
    if (str == null || "".equals(str)) { // null is not empty, empty -> ""
      return;
    }
    System.out.println("string=" + str); // main logic
  }

  public static double pi() {
    return 3.14159;
  }
}
