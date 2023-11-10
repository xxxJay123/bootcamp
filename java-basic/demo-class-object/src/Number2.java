public class Number2 {
  int number1;
  int number2;

  public void setNumber1(int number1) {
    this.number1 = number1;
  }

  public void setNumber2(int number2) {
    this.number2 = number2;
  }

  public int divide() { // non-static
    this.print(); // non-static method call non-static method
    System.out.println(Number2.add(this.number1, this.number2)); // n1 -> 13+26
    return this.number2 / this.number1;
  }

  public static int divide(int number1, int number2) { // static
    return number2 / number1;
  }

  public void print() {
    System.out.println("this.number1=" + this.number1);
    System.out.println("this.number2=" + this.number2);
  }

  public static int add(int number1, int number2) {
    return number1 + number2;
  }

  public static void main(String[] args) {
    Number2 n1 = new Number2();
    n1.setNumber1(13);
    n1.setNumber2(26);

    Number2 n2 = new Number2();
    n2.setNumber1(10);
    n2.setNumber2(100);

    System.out.println(n1.divide()); // 26/13=2
    System.out.println(n2.divide()); // 100/10=10

    Number2.divide(3, 6); // 6/3=2

    n1.print();
    n2.print();

  }
}
