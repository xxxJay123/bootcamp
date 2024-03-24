import java.util.Scanner;

public class DoWhileLoop {
  public static void main(String[] args) {
    // do-while, do first, then check condition to start looping
    int count = 0;
    do {
      System.out.println("hello, count=" + count);
      count++;
    } while (count < 3);
    

    int input = 0;
    Scanner scanner;
    do {
      scanner = new Scanner(System.in);
      System.out.println("Please a integer:");
      input = scanner.nextInt();
      // if input is even -> continue
      // odd -> exit loop and print the number
    } while (input % 2 == 0);
    System.out.println("input=" + input);
    // scanner.close();

    
    

  }
}
