package zoo;

public class Zoo<T extends Animal> {
  T animal;

  // Constructor
  private Zoo(T animal) {
    this.animal = animal;
  }

  // Zoo<T> -> return type
  // T -> input parameter
  // <T extends Animal> -> the range of T of the method
  public static <T extends Animal> Zoo<T> of(T animal) {
    return new Zoo<>(animal);
  }


  public T getAnimal() {
    return this.animal;
  }

  public void setAnimal(T animal) {
    this.animal = animal;
  }
}
