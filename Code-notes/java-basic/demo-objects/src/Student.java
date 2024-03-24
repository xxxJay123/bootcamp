public class Student {

  int age;

  

  private String name = "abc";

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public static void main(String[] args) {
    // String name = "Hello";
    Student s1 = new Student();
    Student s2 = new Student();
    s2.setName("abcd");
    s2.setName("abc");
  }
}
