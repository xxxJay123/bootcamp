package order;

public class Transaction {

  private int itemNo;

  private ItemDesc itemDesc; // 

  private int quantity;

  private double unitPrice;

  // private Discount discount;

  public Transaction(int itemNo, ItemDesc itemDesc, int quantity,
      double unitPrice) {
    this.itemNo = itemNo;
    this.itemDesc = itemDesc;
    this.quantity = quantity;
    this.unitPrice = unitPrice;
  }

  // getSubtotal(), no new attribute
  public double subtotal() {
    return this.unitPrice * this.quantity;
  }

  public int getItemNo() {
    return this.itemNo;
  }

  public double getUnitPrice() {
    return this.unitPrice;
  }

  public ItemDesc getItemDesc() {
    return this.itemDesc;
  }

  public int getQuantity() {
    return this.quantity;
  }

  public void setItemNo(int itemNo) {
    this.itemNo = itemNo;
  }

  public void setUnitPrice(double unitPrice) {
    this.unitPrice = unitPrice;
  }

  public void setItemDesc(ItemDesc itemDesc) {
    this.itemDesc = itemDesc;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }


}
