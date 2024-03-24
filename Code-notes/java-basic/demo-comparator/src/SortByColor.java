import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortByColor implements Comparator<Ball> {

  @Override
  public int compare(Ball b1, Ball b2) {
    return b2.color.id < b1.color.id ? 1 : -1;
  }

  public static void main(String[] args) {
    ArrayList<Ball> balls = new ArrayList<>();
    balls.add(new Ball(4, Color.YELLOW));
    balls.add(new Ball(1, Color.BLUE));
    balls.add(new Ball(5, Color.YELLOW));
    balls.add(new Ball(100, Color.RED));
    Collections.sort(balls, new SortByColor());
    System.out.println(balls); 
    // [[id=100, color=RED], [id=5, color=YELLOW], [id=4, color=YELLOW], [id=1, color=BLUE]]
  }
}
