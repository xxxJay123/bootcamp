import java.util.ArrayList;
import java.util.List;

public class App {

  public static void main(String[] args) throws Exception {
    List<Object> objects = new ArrayList<>();
    objects.add(new Student());
    objects.add(new Book());

    for (Object o : objects) {
      if (o instanceof Student) {
        Student s = (Student) o;
        s.getName();
      } else if (o instanceof Book) {
        Book b = (Book) o;
        b.getHello();
      }
    }
  }
}
