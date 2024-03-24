public class Person { // template
  // Describe the person by attributes
  private int age;
  private char gender; // week 6 -> ENUM
  // ...
  
  public static boolean isMale(char gender) { // belongs to class
    if (gender == 'F') {
      return false;
    }
    return true;
  }

  public boolean isMale() { // each object has this method
    if (this.gender == 'F') {
      return false;
    }
    return true;
  }

  // getter
  public int getAge() {
    return this.age; // this.age
  }

  // setter
  public void setAge(int age) {
    this.age = age;
  }

  public char getGender() {
    return this.gender;
  }

  public void setGender(char gender) {
    this.gender = gender;
  }

  public static void main(String[] args) {
    String s = new String("abc"); // new an object in heap
    String s2 = "abcd"; // new an object in heap
    String s3 = String.valueOf("abcde"); // new an object in heap
    Boolean b = new Boolean("true"); // new an object in heap
    Boolean b2 = Boolean.valueOf("false"); // new an object in heap
    Boolean b3 = true; // auto-box // new an object in heap

    Person p = new Person(); // Produce empty person object, with default value
    Person p2 = new Person(); // Produce empty person object, with default value
    p.setAge(13);

    // Static vs non-static
    // static
    System.out.println(Person.isMale('F')); // -> false

    // non-static
    p.setGender('M');
    p.isMale(); // true

    Computer computer = new Computer(); // Computer() -> empty constructor
    computer.setColor("RED");
    computer.setRam(128);
    computer.setWeight(2);

    Computer computer2 = new Computer("Yellow"); // kind of setter
    computer2.getColor(); // -> Yellow
    computer2.setColor("Black");
    computer2.getColor(); // -> Black

  }


}
