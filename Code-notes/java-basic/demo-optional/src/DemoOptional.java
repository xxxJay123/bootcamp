import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DemoOptional {
  public static void main(String[] args) throws Exception {

    // Optional<Book> -> Book -> String
    Optional<Book> o = getBook(); // call method
    if (!o.isPresent()) {

    }
    o.ifPresent(e -> {

    });

    List<Book> books = new ArrayList<>();
    books.add(new Book("John"));
    books.add(new Book("Mary"));
    books.add(new Book("Peter"));

    Optional<Book> book = books.stream() // object book is not null
        .filter(b -> b.author.startsWith("T")) //
        .findAny();

    book.ifPresent(b -> {
      System.out.println(b);
      // codes ...
    });

    if (book.isPresent()) {
      System.out.println(book.get());
    } else {
      System.out.println("No Book found");
    }

    Optional<Book> book2 = Optional.of(new Book("Eric"));
    // Optional<Book> book3 = Optional.of(null); // runtime-error
    Optional<Book> book4 = Optional.ofNullable(null);
    System.out.println(book4.isPresent()); // false
    Optional<Book> book5 = Optional.ofNullable(new Book("Jenny"));
    Optional<Book> book6 = Optional.empty();
    System.out.println(book6.isPresent()); // false

    // Optional<Book> book7 = null;

    // Optional<Book> -> Book
    Book newBook = book6.orElse(new Book("default"));
    Book newBook2 = book6.orElseGet(() -> new Book("default"));
    Book newBook3 = book6.orElseThrow(() -> new Exception());

  }

  public static Optional<Book> getBook() {
    // get book logic ...
    return Optional.ofNullable(null);
  }

}
