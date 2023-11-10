import java.util.ArrayList;
import java.util.List;

public class NotThatEasy {

  static final List<Character> characters = method(); // static method
  private static final char[] chars = {'J', 'a', 'c', 'k', 'y'};

  final int x = method2(); // static method

  static List<Character> method() {
    System.out.println("I am static method, called by static variable");
    return new ArrayList<>();
  }

  static int method2() {
    System.out.println("I am static method, called by instatnce variable");
    return 1;
  }

  static {
    System.out.println("I am static code block");
    // characters = new ArrayList<>();
  }

  // object initialization code block
  {
    System.out.println("I am initialization code block");
  }

  public static void main(String[] args) {
    // Once you click the run button:
    // 1. Compile
    // 2. Run -> Class loader -> stack memory
    System.out.println("Start of main");
    NotThatEasy obj = new NotThatEasy(); //
    NotThatEasy obj2 = new NotThatEasy(); //
  }
}
