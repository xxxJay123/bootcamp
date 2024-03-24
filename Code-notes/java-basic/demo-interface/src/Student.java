public class Student extends Person //
    implements Runnable, Swimable, Move { // class signature

  private String name;

  private int score;

  @Override
  public void jump() {

  }

  @Override
  public void bigJump() {
    
  }

  @Override
  public void breath() {
    System.out.println("Student is breath");
  }

  @Override
  public void run() {
    System.out.println("Student is running");
  }

  @Override
  public void swim() {
    System.out.println("Student is swimming");
  }

  public static void main(String[] args) {
    // MAX_SPEED
    System.out.println(Move.MAX_SPEED); // 10

    Move student = new Student();
    student.jump();
    // System.out.println(move.MAX_SPEED); // Not recommended

    Move dog = new Dog();
    dog.jump();

    Swimable swimable = new Student();
    swimable.swim();

    Person person = new Student();
    person.breath();
    person.getAge();
  }


}
