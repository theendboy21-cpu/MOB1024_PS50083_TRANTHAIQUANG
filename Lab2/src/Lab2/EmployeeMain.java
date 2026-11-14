package Lab2;

import java.util.Scanner;

import Lab2.modelEmployee.Employee;
import Lab2.serviceEmployee.EmployeeService;

public class EmployeeMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeService employeeService = new EmployeeService();
        employeeService.addEmployee(new Employee("NV01", "Nguyễn Văn An", 15000000));
        employeeService.addEmployee(new Employee("NV02", "Trần Thị Bình", 18500000));
        int choice;
        do {
            System.out.println("\n========= QUẢN LÝ NHÂN VIÊN =========");
            System.out.println("1. Thêm nhân viên mới");
            System.out.println("2. Hiển thị danh sách nhân viên");
            System.out.println("3. Tìm nhân viên theo mã");
            System.out.println("4. Cập nhật lương nhân viên theo mã");
            System.out.println("0. Thoát chương trình");
            System.out.print("Chọn chức năng: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Nhập mã nhân viên: ");
                    String id = sc.nextLine();
                    System.out.print("Nhập tên nhân viên: ");
                    String name = sc.nextLine();
                    System.out.print("Nhập mức lương: ");
                    try {
                        double salary = Double.parseDouble(sc.nextLine());
                        if (salary < 0) {
                            System.out.println("Lương không được âm!");
                            break;
                        }
                        boolean isAdded = employeeService.addEmployee(new Employee(id, name, salary));
                        if (isAdded) {
                            System.out.println("Thêm nhân viên thành công!");
                        } else {
                            System.out.println("Thất bại: Mã nhân viên đã tồn tại.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi: Mức lương phải là một con số.");
                    }
                    break;

                case 2:
                    employeeService.displayAll();
                    break;

                case 3:
                    System.out.print("Nhập mã nhân viên cần tìm: ");
                    String searchId = sc.nextLine();
                    Employee found = employeeService.findById(searchId);
                    if (found != null) {
                        System.out.println("Thông tin nhân viên tìm thấy:");
                        System.out.println(found);
                    } else {
                        System.out.println("Không tìm thấy nhân viên có mã: " + searchId);
                    }
                    break;

                case 4:
                    System.out.print("Nhập mã nhân viên cần cập nhật lương: ");
                    String updateId = sc.nextLine();
                    if (employeeService.findById(updateId) == null) {
                        System.out.println("Không tìm thấy nhân viên có mã: " + updateId);
                        break;
                    }
                    System.out.print("Nhập mức lương mới: ");
                    try {
                        double newSalary = Double.parseDouble(sc.nextLine());
                        if (newSalary < 0) {
                            System.out.println("Lương mới không được âm!");
                            break;
                        }
                        if (employeeService.updateSalary(updateId, newSalary)) {
                            System.out.println("Cập nhật lương thành công!");
                            employeeService.displayAll();
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi: Mức lương phải là một con số.");
                    }
                    break;

                case 0:
                    System.out.println("Đã thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
            }
        } while (choice != 0);

        sc.close();
    }
}
