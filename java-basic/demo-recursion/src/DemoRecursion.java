import java.util.Objects;

public class DemoRecursion {
  public static void main(String[] args) {
    // algorithm -> algo
    System.out.println(sum(5)); // 15
    System.out.println(sum2(6)); // 8
    print(5); // 5 4 3 2 1 1 2 3 4 5
  }

  // Question 1:
  // k + (k - 1) + (k - 2) + .... + 0
  public static int sum(int k) {
    if (k < 1) // base condition
      return k;
    return k + sum(k - 1);
    // 15 , return
    // 5 + 10 , return
    // 4 + 6, return
    // 3 + 3, return
    // 2 + 1, return
    // 1 + 0, return
    // 0 < 1, return 0;
  }

  // Question 2:
  // 0, 1, 1, 2, 3, 5, 8, 13 ... kth elements [0, 1, 2, 3 ...]
  // k = 6, return 8
  public static int sum2(int k) {
    // base condition
    if (k <= 1)
      return k;
    return sum2(k - 1) + sum2(k - 2);
  }

  // Question 3:
  // non-tail recursion
  // 3 2 1 1 2 3, k = 3
  public static void print(int k) {
    // base condition
    if (k < 1)
      return;
    System.out.print(k + " "); // 1
    print(k - 1); // print(0)
    System.out.print(k + " "); // 1
  }
}
