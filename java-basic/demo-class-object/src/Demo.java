public class Demo {
  public static void main(String[] args) {
    Car car = new Car(); // empty constructor
    Car car2 = new Car(4, 7, "RED");
    // print car2
    System.out.println(car2.getCapacity()); // sysout
    System.out.println(car2.getColor()); // RED
    System.out.println(car2.getNoOfWheel());

    car2.setColor("YELLOW"); // car2 -> object reference, storing the object address
    car.setColor("BLUE");
    // car2 -> YELLOW
    // car -> BLUE
    System.out.println(car2); // Car@6b95977 -> Object reference storing object address

    car2 = new Car(3, 4, "Black"); // ????
    car2 = null;
    car2 = new Car(10, 3, "PINK");

    
    //
    int[] arr = new int[] {1, 3, 2};
    Integer sum = 0; // sum -> reference, an object contains 0
    for (int i = 0; i < arr.length; ++i) {
      sum = sum + arr[i]; //
    }

    CarFactory carFactory = new CarFactory();
    carFactory.changeColor(car2, "WHITE");
    System.out.println(car2.getColor()); // white

    Person person = new Person(); // Constructor
    Computer computer = new Computer();
    String str = new String("Hello"); // str -> object reference
    System.out.println(str); // Hello

    person.setAge(15);
    person.getAge(); // 15

    Student student = new Student("Eric", "Lau", 30);
    System.out.println(student.fullName()); // Eric Lau
    
  }
}
