package order;

public class Order {

  private Transaction[] transactions; // items

  public Order(Transaction[] transactions) {
    // Pass by reference
    this.transactions = transactions;
    
  }

  // getTotal() -> sum up subtotal
  public double getTotal() {
    double total = 0;
    for (int i = 0; i < this.transactions.length; i++) {
      total += this.transactions[i].subtotal(); // object.method()
    }
    return total;
  }
}
