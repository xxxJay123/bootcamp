public class LogicalOperators {
  public static void main(String[] args) {
    boolean isExpensive = true;
    boolean isWorthToBuy = false;
    // && Operator -> AND
    // true, true -> true
    // true, false -> false
    // false, true -> false
    // false, false -> false
    boolean result = isExpensive && isWorthToBuy; // false
    // || Operator -> OR
    // true, true -> true
    // true, false -> true
    // false, true -> true
    // false , false -> false
    boolean result2 = isExpensive || isWorthToBuy; // true

    int a = 5;
    int b = 10;
    int c = 13;
    boolean result3 = a > 6 && b < 12; // false
    // Logical Operator
    boolean result4 = c < 15 || a > 6 && b < 12; // true
    boolean result5 = c < 15 || (a > 6 && b < 12); // true
    boolean result6 = a < 6 || b < 9 || c < 9; // true

    // ==, >=, <=, !=
    // ==, means asking if a equals b? -> true/ false
    // =, assignement
    boolean result7 = a == b; // false
    boolean result8 = a >= 5; // true
    boolean result9 = c <= 13; // true
    boolean result10 = c != 13; // false
    // ! -> NOT
    // asking if the event of (c < 13) is false
    boolean result11 = !(c < 13); // true
    boolean result12 = !(b == 9) && c != 13; // true && false -> false

    // Operators Precedence
    int result13 = (1 + 9) * 3; // 30
    int result14 = ++result13 + 1; // result14=32
    int i = 27;
    int result15 = i++ + 1; // result15=28, i=28

    boolean result16 = 25 + 2 < result15 + 1; // true

    //
    int x = 5;
    int y = 10;
    int z = x += 3 * y; // Step1: 3 * 10 -> 30, Step2: 5 + 30 -> 35

    x = 5;
    int result17 = (x++ + 2) * x++;
    // (x++ + 2) -> 7, x become 6
    // 7 * 6 -> 42, x become 7
    System.out.println("result17=" + result17); // 42
    System.out.println("x=" + x); // 7

    // More Examples
    int o = 7;
    int g = o++ * 2 + o++;
    System.out.println(g); // 22
    // 7 * 2 + 8 = 22

    o = 7;
    int g2 = o++ + o++ * 2;
    System.out.println(g2); // 23
    // from left to right
    // 7 + 8 * 2 = 23

    o = 7;
    int g3 = o++ * (o++ + 2);
    System.out.println(g3); // 70
    // 7 * (8 + 2) = 

    o = 7;
    int g4 = o++ * (2 + o++);
    System.out.println(g4); // 70
    // 7 * 10

    o = 7;
    o = o++ + o++ * o++;
    System.out.println("o=" + o); // 79
    // 7 + 8 * 9 = 79

    o = 7;
    o = o++ * o++ + o++;
    System.out.println("o=" + o); // 65
    // 7 * 8 + 9

    o = 7;
    o = o++ * (o++ + o++);
    System.out.println("o=" + o); // 119
    // 7 * (8 + 9)
  }
}
