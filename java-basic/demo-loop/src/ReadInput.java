import java.util.Scanner;

public class ReadInput {
  public static void main(String[] args) {
    String str = "Hello";
    str.charAt(0); // H

    // Scanner -> read user input
    System.out.println("Please input the loop count:");
    Scanner s = new Scanner(System.in);
    int input = s.nextInt(); // read user input, expecting it is an integer
    System.out.println("input=" + input);

    for (int i = 0; i < input; i++) {
      System.out.println("i=" + i + ", Hello!");
    }

  }
}
