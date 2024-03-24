package person;

import java.util.List;

public interface Swimable {
  void swim();

  // public static <T extends Swimable> void start(List<T> humans) {
  public static void start(List<? extends Swimable> humans) {
    for (Swimable human : humans) {
      human.swim();
    }
  }
}
