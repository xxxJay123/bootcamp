import java.util.Vector;

public class DemoArrayList3 {
  public static void main(String[] args) {
    Person p1 = new Person();

    Player.fillThePocket(p1.getLeftPocket());
    System.out.println(p1.getLeftPocket().getSize()); // 5

    Player.fillThePocket(p1.getRightPocket());
    System.out.println(p1.getRightPocket().getSize()); // 5

    System.out.println("p1 Total Score:" + p1.totalScore());
    System.out.println(
        "p1 Left Pocket Ball Details:" + p1.getLeftPocket().toString());
    System.out.println(
        "p1 Right Pocket Ball Details:" + p1.getRightPocket().toString());

    Person p2 = new Person();
    Player.fillThePocket(p2.getLeftPocket());
    Player.fillThePocket(p2.getRightPocket());
    
  }
}
