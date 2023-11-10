import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Yellow come first, if color same, id ascending order
// if not Yellow, id descending order
public class SortByYellowAndId implements Comparator<Ball> {

  @Override
  public int compare(Ball b1, Ball b2) {
    // 1 -> means you want put b2 to left
    // -1 -> means you want put b1 to left
    if (b2.color == Color.YELLOW && b1.color == Color.YELLOW)
      return b2.id < b1.id ? 1 : -1;
    if (b2.color == Color.YELLOW)
      return 1;
    if (b1.color == Color.YELLOW)
      return -1;
    return b2.id > b1.id ? 1 : -1;
  }

  public static void main(String[] args) {
    ArrayList<Ball> balls = new ArrayList<>();
    balls.add(new Ball(4, Color.YELLOW));
    balls.add(new Ball(1, Color.BLUE));
    balls.add(new Ball(5, Color.YELLOW));
    balls.add(new Ball(100, Color.RED));
    Collections.sort(balls, new SortByYellowAndId());
    System.out.println(balls); // [[id=4, color=YELLOW], [id=5, color=YELLOW], [id=100, color=RED], [id=1, color=BLUE]]

    ArrayList<String> strings = new ArrayList<>();
  }
}
