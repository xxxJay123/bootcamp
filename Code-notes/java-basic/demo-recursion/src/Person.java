import java.util.Objects;

public class Person {
  private String firstName;
  private String lastName;
  private int age;

  // Constructors
  public Person() {}

  public Person(String firstName, String lastName, int age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }

  // Private Constructor, for builder class use
  private Person(PersonBuilder builder) {
    this.firstName = builder.firstName;
    this.lastName = builder.lastName;
    this.age = builder.age;
  }

  // Getters and Setters
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  // toString
  @Override
  public String toString() {
    return "Person [firstName=" + this.firstName //
        + ", lastName=" + this.lastName //
        + ", age=" + this.age + "]";
  }

  // hashCode
  @Override
  public int hashCode() {
    return Objects.hash(this.firstName, this.lastName, this.age);
  }

  // equals
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!(obj instanceof Person))
      return false;
    Person person = (Person) obj;
    return Objects.equals(this.firstName, person.firstName)
        && Objects.equals(this.lastName, person.lastName)
        && Objects.equals(this.age, person.age);
  }

  // Builder static inner class
  public static class PersonBuilder {
    private String firstName;
    private String lastName;
    private int age;

    public PersonBuilder firstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public PersonBuilder lastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public PersonBuilder age(int age) {
      this.age = age;
      return this;
    }

    public Person build() {
      return new Person(this);
    }
  }

  public static void main(String[] args) {
    Person person =
        new PersonBuilder().firstName("John").lastName("Doe").age(30).build();

    System.out.println(person.getFirstName()); // Prints: John
    System.out.println(person); // Prints: Person(firstName=John, lastName=Doe, age=30)
  }
}
