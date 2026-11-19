import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Bai3 {
    public static void main(String[] args) {
        // Dùng lại dữ liệu List<Employee> từ Bài 2
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("NV01", "An", 18_000_000));
        employees.add(new Employee("NV02", "Binh", 12_500_000));
        employees.add(new Employee("NV03", "anh", 22_000_000));
        employees.add(new Employee("NV04", "Cuong", 15_000_000));
        employees.add(new Employee("NV05", "Dung", 9_800_000));
        employees.add(new Employee("NV06", "Hoang", 25_000_000));
        employees.add(new Employee("NV07", "Au", 14_000_000));
        employees.add(new Employee("NV08", "Minh", 19_500_000));

        double totalSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();

        double avgSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);

        Optional<Employee> highestPaidEmp = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));

        System.out.println("==========================================");
        System.out.println("       THỐNG KÊ LƯƠNG NHÂN VIÊN           ");
        System.out.println("==========================================");
        System.out.printf("1. Tổng lương toàn bộ nhân viên : %,.0f VNĐ%n", totalSalary);
        System.out.printf("2. Mức lương trung bình         : %,.0f VNĐ%n", avgSalary);
        System.out.print("3. Nhân viên có lương cao nhất  : ");

        highestPaidEmp.ifPresentOrElse(
                emp -> System.out.printf("%s - %s (Lương: %,.0f VNĐ)%n", emp.getId(), emp.getName(), emp.getSalary()),
                () -> System.out.println("Danh sách nhân viên trống!"));
        System.out.println("==========================================");
    }
}