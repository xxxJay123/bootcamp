import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Company {
  List<Staff> staffs;
  private static int counter;

  public Company() {
    staffs = new ArrayList<>();
  }

  public Company(List<Staff> staffs) {
    this.staffs = staffs;
  }

  public List<Staff> geStaffs() {
    return this.staffs;
  }

  public void add(Staff staff) {
    this.staffs.add(staff);
    counter++;
  }

  /**
   * Get Staff name by staff id
   * 
   * @param staffId
   * @return
   */
  public Optional<String> getStaffName(int staffId) {
    return this.staffs.stream() //
        .filter(s -> s.getId() == staffId) // List<Staff>
        .map(s -> s.getName()) // Convert List<Staff> to List<String>
        .findAny(); // Optional<String>
       // .orElse(null); // String
  }

  public static void main(String[] args) {
    Company company = new Company();
    company.geStaffs().add(new Staff(1, 20000, "John")); // OK
    company.add(new Staff(2, 10000, "Peter"));

    company.getStaffName(1); // "John"
  }
}
