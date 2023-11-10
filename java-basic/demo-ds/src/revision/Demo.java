package revision;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class Demo {
  public static void main(String[] args) {
    // ArrayDeque & LinkedList -> different underlying structure
    Deque<String> arrayDeque = new ArrayDeque<>(); // array
    arrayDeque.addFirst("a");
    arrayDeque.addLast("a");
    arrayDeque.pollFirst();
    arrayDeque.pollLast();
    Deque<String> linkedDeque = new LinkedList<>(); // linked list
    linkedDeque.addFirst("a");
    linkedDeque.addLast("a");
    linkedDeque.pollFirst();
    linkedDeque.pollLast();

    Queue<String> arrayQueue = new ArrayDeque<>(); // array
    arrayQueue.add("a");
    arrayQueue.poll();
    Queue<String> linkedQueue = new LinkedList<>(); // linked list
    linkedQueue.add("a");
    linkedQueue.poll();

    Queue<String> pQueue = new PriorityQueue<>(); // array
    pQueue.add("a");
    pQueue.poll();

    List<Integer> arraylist = new ArrayList<>(); // array
    arraylist.add(3);
    arraylist.remove(3);
    List<Integer> linkedlist = new LinkedList<>(); // linked list
    // linkedlist.poll();
    linkedlist.add(3);
    linkedlist.remove(3);

    List<String> stack = new Stack<>(); //
    stack.add("abc");
    stack.remove(0);

    Vector<String> stack2 = new Stack<>(); // Vector vs List
    stack2.add("abc");
    stack2.remove(0);

    Stack<String> stack3 = new Stack<>();
    stack3.push("abc");
    stack3.pop();

  }
}
