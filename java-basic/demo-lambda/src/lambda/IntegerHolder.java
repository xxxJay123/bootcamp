package lambda;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class IntegerHolder {
  // static AtomicInteger integer = new AtomicInteger(0);
  int integer = 0;

  public static void main(String[] args) throws InterruptedException {
    IntegerHolder holder = new IntegerHolder();

    Runnable runnable = () -> {
      for (int i = 0; i < 10000; i++) {
        holder.integer++; // atomic-operation
      }
    };
    Thread thread1 = new Thread(runnable);
    Thread thread2 = new Thread(runnable);

    thread1.start();
    thread2.start();

    thread1.join();
    thread2.join();
    System.out.println(holder.integer);

  }

}
