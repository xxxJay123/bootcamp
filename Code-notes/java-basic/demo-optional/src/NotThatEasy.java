import java.util.ArrayList;
import java.util.List;

public class NotThatEasy {

  static final List<Character> characters;
  // private static final char[] chars = {'J', 'a', 'c', 'k', 'y'};
  // int a;

  {
    // characters.add('V');
    System.out.println("instance block");
  }

  static {
    characters = new ArrayList<>();
    System.out.println("static block");
  }
  // execute only when New Object of current class is created


  public static void main(String[] args) {
    // NotThatEasy easy = new NotThatEasy();
    // System.out.println("start");
   characters.add('a');
   characters.remove(0);
  }
}
