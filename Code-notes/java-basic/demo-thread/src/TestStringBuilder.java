public class TestStringBuilder {
  public static void main(String[] args) throws InterruptedException {
    StringBuilder sbuilder = new StringBuilder("");
    // sbuilder (refenece) -> object (StringBuilder Object) -> object (array)

    Runnable appendS = () -> {
      for (int x = 0; x < 100; x++) {
        sbuilder.append("s");
      }
    };

    Thread thread1 = new Thread(appendS);
    Thread thread2 = new Thread(appendS);

    thread1.start();
    thread2.start();

    thread1.join();
    thread2.join();
    System.out.println(sbuilder.length()); // java.lang.ArrayIndexOutOfBoundsException
  }
}
