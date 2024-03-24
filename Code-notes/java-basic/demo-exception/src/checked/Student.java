package checked;

public class Student {
  String name;
  long pocketMoney;

  public Student() {

  }

  public Student(String name) {
    this.name = name;
  }

  public void setName(String name) throws NameTooLongException {
    if (name.length() > 10)
      throw new NameTooLongException("Name is too long (> 50)");
    this.name = name;
  }

  public void setPocketMoney(long pocketMoney) throws AmountZeroException {
    if (pocketMoney <= 0)
      throw new AmountZeroException("Amount <= 0");
    this.pocketMoney = pocketMoney;
  }

  public static void main(String[] args) {
    Student student = new Student("John");
    try {
      // checked exception
      // int i = 10 / 0 ;
      student.setPocketMoney(-3);
      student.setName("Peter"); // if exception, throw it to the caller
    } catch (NameTooLongException | AmountZeroException e) {
      System.out.println("Student Setter Issue, message:" + e.getMessage());
    } catch (RuntimeException e) {
      System.out.println(e.getMessage()); // / by zero
    } finally {
      System.out.println("finally");
    }

    Student student2 = new Student();
    // student2.name.length(); // null pointer, unchecked exception

  }
}
