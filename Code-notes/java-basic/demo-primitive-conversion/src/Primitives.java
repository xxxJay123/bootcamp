public class Primitives {
  public static void main(String[] args) {
    // Correct Syntax
    // Upcasting (Implicit conversion/ Promotion)
    // byte -> short -> int -> long -> float -> double
    byte b = 2;
    short s = b; // byte -> short
    int i = s;
    long l = i;
    float f = l;
    double d = f;
    // char -> int
    char c = 'A';
    int j = c;

    // Downcasting
    double d2 = 10.3d;
    // float f2 = d2; // why error? double precision is larger than float
    float f2 = (float) d2; // developer take responsibilty for the risky of data loss

    short s2 = 128;
    // byte b2 = s2; // error
    byte b2 = (byte) s2; // Explicit conversion
    System.out.println("b2=" + b2); // -128

    // for (byte k = 127; k < 129; k++) { // 128 -> -128
    // System.out.println("hello");
    // }

    // int[] arr = new int[Integer.MAX_VALUE]; //
    // for (int n = 0; n < arr.length; n++) {

    // }

    char c2 = 'B'; // 66, ASCII Code
    if (c2 == 'B') {
      System.out.println("c2 is B");
    }
    if (c2 == 66) {
      System.out.println("c2 is 66");
    }
    char c3 = 67; // downcast
    System.out.println("c3="+ c3);
    if (c3 == 'C') {
      System.out.println("c3 is C");
    }

    // ASCII (int) to char
    int g2 = 66;
    char k = (char) g2; // Explicit conversion/ downcasting
    char k2 = 66; // 66 is ASCII code

    //
    int h = (int) 1000L; // downcasting, Explicit conversion
    short s10 = 128;
    byte o = (byte) s10;
    // byte o2 = 128; // error

    char character = 'a' + 1;
    if (character == 'b') {
      System.out.println("character=" + character);
    }
    if (character == 98) {
      System.out.println("character=" + character);
    }
    if (character > 'a') { // ASCII
      System.out.println("character > a");
    }
    

  }
}
