package machines;
public class Machine {

  private double weight;

  public Machine() {

  }

  public Machine(double weight) {
    this.weight = weight;
  }

  public double getWeight() {
    return this.weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public void start() {
    System.out.println("Machine Start ...");
  }

  public void stop() {
    System.out.println("Machine Stop ...");
  }

  public static final String staticMethod(String x, String y) {
    return x + y;
  }

  // Factory Pattern
  public static Machine produce(int code) {
    switch (code) {
      case 1:
        return new Machine();
      case 2:
        return new Laptop();
    }
    return new Machine();
  }

  public static void stop(int code) { // what machine going to stop????
    Machine machine = Machine.produce(code);
    machine.stop(); // different child class will have different implementation
  }

  public static void main(String[] args) {
    int pockeyMoney = 100;
    boolean stopCondition = pockeyMoney < 0; // ???
    int code = 1;

    if (stopCondition) {
      Machine.stop(code); // Machine Stop ...
    }

  }

}
