import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoArrayList {
  public static void main(String[] args) {
    List<String> strings = new ArrayList<>();
    strings.add("abc");
    strings.add("ghi");
    strings.add("def");

    // for-each
    List<String> list2 = new ArrayList<>();
    for (String s : strings) {
      if (s.startsWith("a"))
        list2.add(s);
    }
    // Stream
    Stream<String> streamStrings = strings.stream();
    // Stream.filter
    streamStrings = streamStrings.filter(s -> s.startsWith("a"));
    // Stream.forEach
    streamStrings.forEach(s -> System.out.println(s)); // abc

    strings.stream() //
        .filter(s -> s.endsWith("i")) //
        .forEach(s -> System.out.println(s)); // ghi

    List<String> strings2 = strings.stream() //
        .filter(s -> s.length() == 3) //
        .collect(Collectors.toList());

    System.out.println(strings2.size()); // 3

    // Stream.map()
    List<Integer> lengths = strings2.stream() //
        .filter(e -> e.startsWith("a") || e.startsWith("d"))
        .map(e -> e.length()) // Stream<Integer>
        .collect(Collectors.toList()); // List<Integer>

    lengths.forEach(e -> System.out.println(e)); // 3 3

    // Stream.sorted()
    strings2.stream() //
        .sorted((s1, s2) -> s2.compareTo(s1)) // descending order
        .forEach(s -> System.out.println(s));

    // Stream.anyMatch()
    if (strings2.stream().anyMatch(e -> e.startsWith("a"))) {
      System.out.println("One of the elements starts with a");
    }

    // interminate operations of Stream:
    // filter(), map(), sorted(), anyMatch()

    // terminated operations of Stream:
    // collect(), forEach(), count()

    // Stream can only terminate once,
    // but it may have multiple interminate operations

    List<Person> persons =
        Arrays.asList(new Person("John", 30), new Person("Mary", 25));
    // stream -> get all the names from persons
    List<String> names = persons.stream() //
        .map(e -> {
          String word = " words ...";
          return e.getName() + word;
        }) // Stream<String>
        .collect(Collectors.toList());

    System.out
        .println(names.stream().filter(e -> e.startsWith("John")).count());

    // Stream static method
    Predicate<String> lengthFunc = e -> e.length() == 3;

    long l = Stream.of("abc", "defz", "ghivv", "abc") //
        .filter(lengthFunc) //
        .distinct() // remove duplicates
        .count(); // 1

    List<Integer> integers = Stream.of(1, 2, 3, 4) //
        // .filter(e -> e == 2) //
        .map(e -> {
          System.out.println("map=" + e); // 2
          return 2;
        }) //
        // .forEach(e -> System.out.println(e)); // 2
        .collect(Collectors.toList());

    System.out.println(integers); // [2, 2, 2, 2]

    int setSize = Stream.of(1, 2, 3, 3) //
        .collect(Collectors.toSet()).size();
    System.out.println(setSize); // 3

    // .count(); // terminate operation

    Stream.of(1, 2, 3, 3, 5) //
        .filter(e -> e < 6 && e > 2) //
        .forEach(e -> System.out.println(e)); // 3 3 5

    List<String> animals = Arrays.asList("lion", "tiger", "bear");

    Map<String, Integer> animalMap = animals.stream() //
        .collect(Collectors.toMap(str -> str, str -> str.length()));

    // Loop Map
    for (Map.Entry<String, Integer> entry : animalMap.entrySet()) {
      System.out.println(entry.getKey() + " " + entry.getValue());
    }

    // Stream.iterate()
    Stream.iterate(1, n -> n + 2) //
        .limit(10) //
        .forEach(e -> System.out.println(e));
    
    // Group by
    
  }

  public static boolean findElderly(List<Person> persons) {
    return persons.stream() // Stream<>
        .filter(e -> e.isElderly()) // Stream<>
        .findFirst() // Optional<Person>
        .isPresent(); // boolean
  }


}
