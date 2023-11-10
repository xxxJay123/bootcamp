public enum Direction { // special keyword since Java 1.5
  // 1. public class Direction extends Enum
  // 2. enum is final class

  // 全局唯一, 4 objects (EAST, SOUTH, WEST, NORTH)
  // new Direction('E')
  EAST('E', 90), //
  SOUTH('S', 180), //
  WEST('W', 270), //
  NORTH('N', 360) //
  ;

  private char direction;
  private int degree;

  private Direction(char direction, int degree) {
    this.direction = direction;
    this.degree = degree;
  }

  public char getDirection() {
    return this.direction;
  }

  public int getDegree() {
    return this.degree;
  }

  public boolean isOppsite(Direction direction) {
    return Math.abs(this.degree - direction.getDegree()) == 180;
  }

  public static void main(String[] args) {
    System.out.println(Direction.EAST.isOppsite(Direction.WEST)); // true
    System.out.println(Direction.WEST.isOppsite(Direction.EAST)); // true
    System.out.println(Direction.WEST.isOppsite(Direction.NORTH)); // false
  }

}
