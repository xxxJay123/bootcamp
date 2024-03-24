package fruit;

import animal.Dog;

public class Banana {
  public static void main(String[] args) {
    // Because Apple.java and Banana.java are under same package
    Apple apple = new Apple();

    // Because Dog.java is public class, 
    // which can be referenced by the class in another package
    Dog dog = new Dog();

    Lemon lemon = new Lemon();
    lemon.name = "hello"; // because Banana and Lemon are under same package
  }
}
