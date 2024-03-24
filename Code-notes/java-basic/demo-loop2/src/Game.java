import java.util.Random;
import java.util.Scanner;

public class Game {
  public static void main(String[] args) {
    // 1 - 100
    // bomb = 45 (random number)
    // Next round: Please input a number (1-100):
    // user input: 30
    // Next round: Please input a number (31-100):
    // user input 60
    // Next round: Please input a number (31-59):
    // user input 45
    // exit loop. Bomb!
    int min = 1;
    int max = 100;
    int bomb = new Random().nextInt(100) + 1; // 1 - 100
    // min and max should be modified in each iteration
    int input;
    Scanner scanner;
    // do-while
    do {
      scanner = new Scanner(System.in);
      System.out.print("Please input a number (" + min + "-" + max + "): ");
      input = scanner.nextInt();
      if (input < min || input > max) {
        continue;
      }
      if (input < bomb) {
        min = input + 1;
      } else if (input > bomb) {
        max = input - 1;
      }
    } while (input != bomb);
    // input == bomb
    System.out.println("Bomb!");
    scanner.close();
  }
}
