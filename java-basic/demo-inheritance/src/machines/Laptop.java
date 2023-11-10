package machines;

import java.util.Objects;

public class Laptop extends Machine {
  // Laptop is subclass (child), Machine is superclass (parent)
  // Inherit Machine attribute ("double weight")
  // Inherit Machine methods (start() and stop())

  private Keyboard keyboard;
  private Monitor monitor;

  private int volume;

  // subclass constructor must call one of superclass constructors

  public Laptop() {
    // super(); // new Machine();
    // implicitly call superclass empty constructor
    // new Machine()
  }

  public Laptop(Keyboard keyboard, Monitor monitor) {
    // implicitly call superclass empty constructor
    this.keyboard = keyboard;
    this.monitor = monitor;
  }

  public Laptop(String buttonType, int noOfButton, double length,
      double width) {
    // implicitly call superclass empty constructor
    this.keyboard = new Keyboard(buttonType, noOfButton);
    this.monitor = new Monitor(length, width);
  }

  public Laptop(double weight, Keyboard keyboard, Monitor monitor) {
    super(weight); // super(); + this.setWeight(weight);
    this.keyboard = keyboard;
    this.monitor = monitor;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Laptop))
      return false;
    Laptop laptop = (Laptop) o;
    return Objects.equals(laptop.keyboard, this.keyboard)
        && Objects.equals(laptop.monitor, this.monitor);
  }

  @Override // Method Overriding
  public void start() {
    // super.start(); // Machine Start ...
    System.out.println("Laptop Start ...");
  }

  @Override // Method Overriding
  public void stop() {
    System.out.println("Laptop Stop ...");
  }

  // You cannot override the final method in superclass
  // public static String staticMethod(String x, String y) {

  // }

  public void mute() {
    this.volume = 0;
  }

  public static void main(String[] args) {
    Laptop laptop = new Laptop("abc", 100, 15, 10);
    laptop.setWeight(3.0d);
    System.out.println(laptop.getWeight()); // 3.0
    laptop.start(); // Laptop Start ...
    laptop.stop(); // Laptop Stop ...

    Machine machine = new Machine(); // weight = 0.0
    machine.setWeight(5.0d);
    System.out.println(machine.getWeight()); // 5.0
    machine.start(); // Machine Start ...
    machine.stop(); // Machine Stop ...

    Laptop laptop2 = new Laptop(); // empty constructor
    laptop2.setWeight(10.0d);
    System.out.println(laptop2.getWeight()); // 10.0

    Laptop laptop3 = new Laptop();
    System.out.println(laptop3.getWeight()); // 1.0
    System.out.println(Machine.staticMethod("abc", "def")); // abcdef
    System.out.println(Laptop.staticMethod("abc", "def")); // abcdef
    // laptop3.staticMethod("abc", "def"); // not recommended



  }

}
