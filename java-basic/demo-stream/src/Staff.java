import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Staff {
  String name;
  Department department;
  int performance;

  public Staff(String name, Department department, int performance) {
    this.name = name;
    this.department = department;
    this.performance = performance;
  }

  @Override
  public String toString() {
    return "Staff[" //
        + "name=" + this.name //
        + "dept=" + this.department //
        + "]";
  }

  public static void main(String[] args) {
    List<Staff> staffs =
        Arrays.asList(new Staff("Mary", new Department("HR"), 50) //
            , new Staff("Peter", new Department("IT"), 60),
            new Staff("Eric", new Department("IT"), 70));

    Map<Department, List<Staff>> deptMap = staffs.stream() //
        .collect(Collectors.groupingBy(staff -> staff.department));

    deptMap.forEach(
        (dept, staffList) -> System.out.println(dept + " " + staffList));

    for (Staff staff : deptMap.get(new Department("IT"))) { // equals() & hashCode()
      System.out.println(staff.name);
    }

    //
    Map<Boolean, List<Staff>> gradeMap = staffs.stream() //
        .collect(Collectors.partitioningBy(staff -> staff.performance >= 65));

    gradeMap.entrySet().stream() // list, set -> stream()
        .forEach(e -> System.out.println(e));
  }
}
