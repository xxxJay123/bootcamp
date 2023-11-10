public class Operators {
  public static void main(String[] args) {
    int a = 1;
    a = a + 1; // 2
    a = a - 2; // 0
    int b = 10 / 5; // 2
    b = b * 3 + 5; // 11
    System.out.println("a append b=" + a + b); // a append b 011

    // + 1 Operations
    int x = 1;
    x = x + 1;
    x++; // means x = x + 1;
    ++x; // means x = x + 1;
    x += 1; // means x = x + 1;
    System.out.println("x=" + x); // x=5

    // -1 Operations
    int y = 10;
    y = y - 1;
    y--;
    --y;
    y -= 1;
    System.out.println("y=" + y); // y=6

    // Other +,-,*,/,%
    int z = 4;
    z = z + 2;
    z += 2;
    int i = 6;
    i = i - 3;
    i -= 3;
    int w = 9;
    w = w * 3;
    w *= 3;
    int u = 81;
    u = u / 9;
    u /= 3;
    int integer = 12 % 5; // 2
    int integer2 = 12;
    integer2 %= 5; // 2

    // ++, --
    int m = 3;
    m++; // 4
    int preIncrement = ++m; // m+1 first, assignement later
    System.out.println("preIncrement=" + preIncrement); // 5
    int postIncrement = m++; // assignement first, m+1 later
    System.out.println("postIncrement=" + postIncrement); // 5
    System.out.println("m=" + m); // 6

    int n = 5;
    --n; // 4
    int preDecrement = --n; // n-1 first
    System.out.println("preDecrement=" + preDecrement); // 3
    int postDecrement = n--; // assignement first, n-1 later
    System.out.println("postDecrement=" + postDecrement); // 3
    System.out.println("n=" + n); // 2

    // String +=
    String str = "hello";
    str += " world"; // hello world

  }
}
