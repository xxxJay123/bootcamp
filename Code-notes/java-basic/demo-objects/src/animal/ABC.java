package animal;

import fruit.Lemon;

public class ABC extends Lemon {

  public void read() {
    this.name = "abc";
  }

  public String hello() {
    return this.greeting();
  }
  
}
