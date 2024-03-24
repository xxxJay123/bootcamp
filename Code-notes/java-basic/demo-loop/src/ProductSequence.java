public class ProductSequence {
  public static void main(String[] args) {
    // 0, 1, 2, 3, 4, 5 ....
    // print out 0, 2, 6, 12, 20 ....
    // Print the first 20 numbers, based on the above requirement
    int a, b, c; // declare 2 variables in one go
    for (int i = 0; i < 20; i++) {
      a = i;
      b = i + 1;
      c = a * b;
      System.out.print(c + " ");
    }
  }
}
