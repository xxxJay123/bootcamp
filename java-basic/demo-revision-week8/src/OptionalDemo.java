import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {
  public static void main(String[] args) {
    List<String> addresses = new ArrayList<>();
    addresses.add("Hong Kong");
    addresses.add("Mainland");
    addresses.add("Japan");
    Person2 p1 = new Person2("Ann Chan", addresses);

    List<String> addresses2 = new ArrayList<>();
    addresses2.add("Taiwan");
    addresses2.add("US");
    Person2 p2 = new Person2("Betty Chen", addresses2);

    List<Person2> persons = new ArrayList<>();
    persons.add(p1);
    persons.add(p2);
    System.out.println(getFromDb(persons, "Chan")); // true
    System.out.println(getFromDb(persons, "Lau")); // false

    Optional<Person2> result = getFromDb2(persons, "Chan");
    result.ifPresent(person -> {
      person.getAddresses().stream() //
          .forEach(addr -> {
            System.out.println(addr);
          });
    });
  }

  public static Optional<Person2> getFromDb2(List<Person2> persons //
      , String lastName) {
    return persons.stream() //
        .filter(p -> p.getName().endsWith(lastName)) // Stream
        .findAny(); // Optional<Person2>
  }

  public static boolean getFromDb(List<Person2> persons //
      , String lastName) {
    return persons.stream() //
        .filter(p -> p.getName().endsWith(lastName)) // Stream
        .findAny() // Optional<Person2>
        .isPresent();
  }
}
