package shopping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShoppingCart {

  private ArrayList<CheckoutItem> items;

  public ShoppingCart() {
    items = new ArrayList<>();
  }

  public int totalAmount() {
    int sum = 0;
    for (CheckoutItem item : this.items) {
      sum += Math.max(0, item.getPrice()) * Math.max(0, item.getQuantity());
    }
    return sum;
  }

  public void add(int quantity, DisplayItem displayItem) {
    // construct CheckoutItem
    CheckoutItem checkoutItem =
        new CheckoutItem(quantity, displayItem.getPrice());
    items.add(checkoutItem);
  }

  public boolean remove(CheckoutItem item) {
    return items.remove(item);
  }

  public void clear() {
    this.items.clear();
  }

  public static void main(String[] args) {
    ShoppingCart cart = new ShoppingCart();
    // cart.add(new Rice());
    // ShoppingCart<Drink> cart2 = new ShoppingCart<>();
    // ShoppingCart<Food> cart3 = new ShoppingCart<>();
    // ShoppingCart<Rice> cart4 = new ShoppingCart<>();
    // ShoppingCart<Object> cart3 = new ShoppingCart<>();
    
  }

}
