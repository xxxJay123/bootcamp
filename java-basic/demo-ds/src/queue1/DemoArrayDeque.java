package queue1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class DemoArrayDeque {
  public static void main(String[] args) {
    ArrayDeque<String> strings = new ArrayDeque<>();
    strings.add("abc");
    strings.add("def");
    strings.add("abc");
    System.out.println(strings.poll()); // abc
    System.out.println(strings.size()); // 2
    strings.addLast("xyz"); // addLast() = add()
    System.out.println(strings.poll()); // def
    strings.addFirst("ijk"); // head
    System.out.println(strings.peek()); // ijk
    System.out.println(strings.pollFirst()); // ijk, pollFirst() = poll()
    System.out.println(strings.pollLast()); // xyz

    Deque<String> deque = new LinkedList<>(); // Polymorhism
    Queue<String> queue = new LinkedList<>(); // Polymorhism

    queue.add("abc");
    deque.add("abc");
    deque.addFirst("def");
    deque.addLast("ijk");

    run1(new LinkedList<>()); // linkedlist
    run1(new ArrayDeque<>()); // array
    // run1(new PriorityQueue<>()); // compile-error

    run2(new LinkedList<>()); // linkedlist
    run2(new ArrayDeque<>()); // array
    run2(new PriorityQueue<>());

    Collection<String> arraylist = new ArrayList<>();
    
    List<String> list = new LinkedList<>(); // hide deque methods
  }

  public static int run3(Collection<String> collection) {
    collection.add(null);
    collection.add(null);
    collection.add(null);
    return collection.size();
  }

  public static void run1(Deque<String> deque) {
    deque.add("ss");
    deque.add("ss");
  }

  public static void run2(Queue<String> queue) {
    queue.add("ss");
    queue.add("ss");
  }
}
