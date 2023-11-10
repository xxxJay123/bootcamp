package order;

public class ItemDesc {

  private String header;

  private String body;

  public ItemDesc(String header, String body) {
    this.header = header;
    this.body = body;
  }

  public static void main(String[] args) {
    ItemDesc itemdesc1 =
        new ItemDesc("Item A", "90% Discount, just for today!");
    ItemDesc itemdesc2 =
        new ItemDesc("Item B", "70% Discount, just for this week!");
    Transaction t = new Transaction(1, itemdesc1, 3, 10.5);
    Transaction t2 = new Transaction(1, itemdesc2, 4, 20.5);
    Transaction[] arr = new Transaction[] {t, t2};
    Order order = new Order(arr);
    System.out.println(order.getTotal()); // 3 * 10.5 + 4 * 20.5

  }

}
