public class Ball implements Comparable<Ball> {
  int id;
  Color color;

  public Ball(int id, Color color) {
    this.id = id;
    this.color = color;
  }

  // Sort by id, descending
  @Override
  public int compareTo(Ball ball) {
    // 1 -> means you want put ball to left
    // -1 -> means you want put this to left
    return this.id < ball.id? 1 : -1;
  }

  @Override
  public String toString() {
    return "[id=" + this.id //
        + ", color=" + this.color //
        + "]";
  }

}
