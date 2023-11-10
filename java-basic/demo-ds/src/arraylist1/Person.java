public class Person implements Player {

  Pocket[] pockets;

  public Person() {
    pockets = new Pocket[2];
    pockets[0] = new Pocket();
    pockets[1] = new Pocket();
  }

  @Override
  public int totalScore() {
    return this.getLeftPocket().totalScore()
        + this.getRightPocket().totalScore();
  }

  public Pocket getLeftPocket() {
    return this.pockets[0];
  }

  public Pocket getRightPocket() {
    return this.pockets[1];
  }

}
