import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Bai2Stream {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("NV01", "An", 18_000_000));
        employees.add(new Employee("NV02", "Binh", 12_500_000));
        employees.add(new Employee("NV03", "anh", 22_000_000));
        employees.add(new Employee("NV04", "Cuong", 15_000_000));
        employees.add(new Employee("NV05", "Dung", 9_800_000));
        employees.add(new Employee("NV06", "Hoang", 25_000_000));
        employees.add(new Employee("NV07", "Au", 14_000_000));
        employees.add(new Employee("NV08", "Minh", 19_500_000));

        System.out.println("--- 1. Nhân viên có lương >= 15,000,000 ---");
        employees.stream()
                .filter(emp -> emp.getSalary() >= 15_000_000)
                .forEach(System.out::println);

        System.out.println("\n--- 2. Danh sách sắp xếp theo lương giảm dần ---");
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .forEach(System.out::println);

        System.out.println("\n--- 3. Danh sách tên nhân viên ---");
        List<String> employeeNames = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(employeeNames);

        long countStartWithA = employees.stream()
                .filter(emp -> emp.getName().toLowerCase().startsWith("a"))
                .count();
        System.out.println("\n--- 4. Số nhân viên tên bắt đầu bằng chữ 'A': " + countStartWithA + " ---");
    }
}