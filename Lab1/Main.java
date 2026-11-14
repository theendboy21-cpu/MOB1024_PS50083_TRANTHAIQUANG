package Lab1;

import Lab1.employee.Employee;
import Lab1.partime_employee.PartTimeEmployee;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();

        // Tạo tối thiểu 5 nhân viên (3 Full-time / Employee và 2 Part-time)
        list.add(new Employee("NV01", "Nguyễn Văn A", 12000000));
        list.add(new Employee("NV02", "Trần Thị B", 15000000));
        list.add(new Employee("NV03", "Lê Văn C", 10000000));
        list.add(new PartTimeEmployee("NV04", "Phạm Văn D", 0, 80, 50000));
        list.add(new PartTimeEmployee("NV05", "Hoàng Thị E", 0, 110, 60000));

        // In danh sách nhân viên + thu nhập
        System.out.println("============================== DANH SÁCH NHÂN VIÊN ==============================");
        for (Employee emp : list) {
            System.out.println(emp);
        }

        // Tìm nhân viên có income() cao nhất
        Employee maxIncomeEmp = list.get(0);
        for (Employee emp : list) {
            if (emp.income() > maxIncomeEmp.income()) {
                maxIncomeEmp = emp;
            }
        }

        System.out.println("\n================ NHÂN VIÊN CÓ THU NHẬP CAO NHẤT ================");
        System.out.println(maxIncomeEmp);
    }
}