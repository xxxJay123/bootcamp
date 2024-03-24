@FunctionalInterface
public interface Readable {

  // abstract method (100%)
  void read();

  public static void main(String[] args) {
    Readable readable = () -> System.out.println("hello");
    
  }
}
