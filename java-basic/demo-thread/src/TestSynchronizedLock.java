public class TestSynchronizedLock {

  int x;
  Object lock = new Object();

  public int calculate(int amount) {
    int total = amount;
    synchronized (this.lock) {
      this.x++;
    }
    // codes ....
    // Can be more than one synchronized code block
    // synchronized (this.lock) {
    //   this.x++;
    // }
    return total + this.x;
  }

  // public synchronized void increment() {
  // this.x++;
  // }

  public static void main(String[] args) throws InterruptedException {
    TestSynchronizedLock obj = new TestSynchronizedLock();

    Runnable formula = () -> {
      for (int x = 0; x < 100000; x++) {
        obj.calculate(0);
      }
    };

    Thread thread1 = new Thread(formula);
    Thread thread2 = new Thread(formula);

    thread1.start();
    thread2.start();

    thread1.join();
    thread2.join();
    System.out.println(obj.x); // 200000

  }
}
