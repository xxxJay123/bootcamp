public class Computer {
  // arttributes
  private int ram;
  private int weight;
  private String color;

  // Constructors
  public Computer() {

  }

  public Computer(String color) { // (1) No return type, (2) Constructor name = Class name
    this.color = color;
  }

  public Computer(int ram, int weight, String color) { // (1) No return type, (2) Constructor name = Class name
    this.ram = ram;
    this.weight = weight;
    this.color = color;
  }

  public String getColor() {
    return this.color;
  }

  // methods
  public void setRam(int ram) {
    this.ram = ram;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public void setColor(String color) {
    this.color = color;
  }

}
