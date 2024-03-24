class Password {
  private String password;

  Password(String x) {
    this.password = x;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}

class Quiz {
  public static void main(String[] args) {
    Password p1 = new Password("ABC");
    Password p2 = new Password("ABC");

    System.out.println(p1.equals(p2));

    if (p1 == p2 || !p1.getPassword().equals(p2.getPassword())) { 
      p1.setPassword("DEF");
    } else if (p1.getPassword().equals(p2.getPassword())) {
      p2.setPassword("ABC");
    } else {
      p1.setPassword("XYZ");
      p2.setPassword("XYZ");
    }
    System.out.println(p1.getPassword() + p2.getPassword());
  }
}