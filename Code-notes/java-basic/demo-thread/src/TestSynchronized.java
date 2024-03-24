public class TestSynchronized {

  int number;

  public synchronized void increment() { // Like a "Atomic" method
    this.number++; // non-atomic operation
  }

  public static void main(String[] args) {
    TestSynchronized i = new TestSynchronized();
    // i.number++; // Non-Atomic Operation
    // System.out.println(i.number); // 1

    Runnable formula = () -> {
      for (int x = 0; x < 1000000; x++) {
        i.increment();
      }
    };

    Thread thread1 = new Thread(formula);
    Thread thread2 = new Thread(formula);

    thread1.start();
    thread2.start();

    try {
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {

    }
    System.out.println(i.number);
  }
}
