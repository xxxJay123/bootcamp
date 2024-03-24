import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Company2 {
  private Staff[] staffs; // 5

  public Company2() {
    staffs = new Staff[0];
  }

  public Company2(Staff[] staffs) {
    this.staffs = staffs;
  }

  public Staff[] geStaffs() {
    return this.staffs;
  }

  public void add(Staff staff) {
    Staff[] original = this.staffs; // reference
    this.staffs = new Staff[this.staffs.length + 1];
    for (int i = 0; i < original.length; i++) {
      this.staffs[i] = original[i];
    }
    this.staffs[this.staffs.length - 1] = staff;
  }

  public void remove(Staff staff) {
    int idx = -1;
    for (int i = 0; i < this.staffs.length; i++) {
      if (staffs[i].equals(staff))
        idx = i; // the index going to remove
    }
    // not found, do nothing
    if (idx == -1)
      return;
    // found, resize array and remove
    Staff[] original = this.staffs; // reference
    this.staffs = new Staff[this.staffs.length - 1];
    for (int i = 0; i < original.length; i++) {
      if (i == idx) // index of the elements to be removed
        continue;
      this.staffs[i] = original[i];
    }
  }


  public static void main(String[] args) {
    Company2 company = new Company2();
    company.add(new Staff(1, 5000, "John"));
    System.out.println(company.staffs.length); // 1
    company.add(new Staff(2, 10000, "Mary"));
    System.out.println(company.staffs.length); // 2

    List<Person2> persons = Arrays.stream(company.geStaffs()) //
        .filter(s -> s.geteSalary() > 20000) //
        .map(e -> new Person2(e.getName())) //
        .collect(Collectors.toList());
  }

}
