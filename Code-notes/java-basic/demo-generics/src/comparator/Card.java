package comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Card extends Paper {
  int number;

  public Card(int number, int size) {
    super(size);
    this.number = number;
  }

  @Override // Compiler
  public String toString() {
    return "Card[number=" + this.number //
        + ", size=" + super.size //
        + "]";
  }

  public static void main(String[] args) {
    List<Card> cards = Arrays.asList(new Card(1, 2), new Card(4, 3));
    Collections.sort(cards, new SortBySize());
    System.out.println(cards);

    List<? extends Number> numbers = new ArrayList<Integer>();
    numbers = new ArrayList<Double>();
    // numbers.add(1); // At compile-time, type-safty issue
    // numbers.add(1.0d); // At compile-time, type-safty issue

    Number number = Integer.valueOf(10); // Polymorphism
    number = Double.valueOf(2.3); // Polymorphism
  }

}
