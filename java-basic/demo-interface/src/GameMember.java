import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public abstract class GameMember {

  private int score;

  public int getScore() {
    return this.score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public void addScore(int score) {
    this.score += score;
  }

  public void print() {
    System.out.println("GameMember is jumping.");
  }

  public abstract void up();

  public abstract void down();

  public abstract void left();

  public abstract void right();

  public static void upOnce(GameMember... members) { // multiple args
    for (GameMember member : members) {
      member.up(); // dog / cat objects
    }
  }

  public static void moveOnce(Move[] members) { // multiple args
    for (Move member : members) {
      member.jump(); // dog / cat objects
    }
  }

  public static void main(String[] args) {
    Dog dog = new Dog();
    Cat cat = new Cat();
    GameMember.upOnce(dog, cat);
    System.out.println(dog.getScore()); // 2
    System.out.println(cat.getScore()); // 1

    Move[] members = new Move[] {dog, cat};
    GameMember.moveOnce(members);
    System.out.println(dog.getScore()); // 5 (2+3)
    System.out.println(cat.getScore()); // 5 (1+4)

    // Interface Move default instance method
    dog.print();
    cat.print();
    // static method
    System.out.println(Move.concat("abc", "def"));
    Queue<String> strings = new ArrayDeque<>();
    ArrayList<Object> strings2 = new ArrayList<>();
  }

}
