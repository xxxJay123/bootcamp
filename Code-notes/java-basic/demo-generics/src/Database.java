import java.util.ArrayList;

public class Database<T extends Number> {
  ArrayList<T> data;

  public boolean add(T data) {
    return false;
  }

  public static <T> String add(T data) {
    return "";
  }
}
