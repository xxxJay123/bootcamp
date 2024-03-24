package hashmap1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import hashset1.Book;

public class DemoHashMap2 {
  public static void main(String[] args) {
    HashMap<Integer, Book> books = new HashMap<>();
    // key = Address of Byte or value of Byte?
    books.put(128, new Book("dummy", "Book1"));
    books.put(128, new Book("dummy", "Book2"));
    System.out.println(books.size()); // 1

    HashMap<Author, Book> bookMap = new HashMap<>();
    // Author unqiue key? -> equals(), hashCode()
    Author author1 = new Author("John", 30);
    Author author2 = new Author("John", 29);
    bookMap.put(author1, new Book("dummy", "Book3"));
    bookMap.put(author2, new Book("dummy", "Book4"));
    System.out.println(bookMap.size()); // 1

    HashMap<Author, ArrayList<Book>> bookMap2 = new HashMap<>();
    ArrayList<Book> booklist1 = new ArrayList<>();
    booklist1.add(new Book("dummy", "Book1"));
    booklist1.add(new Book("dummy", "Book2"));
    ArrayList<Book> booklist2 = new ArrayList<>();
    booklist2.add(new Book("dummy", "Book3"));
    booklist2.add(new Book("dummy", "Book4"));

    bookMap2.put(author1, booklist1);
    // Override, because author1.equals(author2) -> true
    bookMap2.put(author2, booklist2);

    System.out.println(bookMap2.size()); // 1

    // Loop bookMap2, print out all the books from each Author
    for (HashMap.Entry<Author, ArrayList<Book>> entry : bookMap2.entrySet()) {
      // author.getValue() -> Book ArrayList
      for (Book book : entry.getValue()) {
        System.out.println("Author Name: " + entry.getKey().name //
            + ", Book Name: " + book.getName());
      }
    }

    for (Book book : bookMap2.get(new Author("John", 0))) {
      System.out.println(book);
    }

  }
}
