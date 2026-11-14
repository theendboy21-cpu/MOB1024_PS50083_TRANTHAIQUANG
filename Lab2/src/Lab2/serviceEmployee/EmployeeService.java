package Lab2.serviceEmployee;

import Lab2.modelEmployee.Employee;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private List<Employee> employeeList = new ArrayList<>();
    //thêm nhân viên
    public boolean addEmployee(Employee employee) {
        for (Employee emp : employeeList) {
            if (emp.getId().equalsIgnoreCase(employee.getId())) {
                return false; // Employee with the same ID already exists
            }
        }
        employeeList.add(employee);
        return true; 
    }
    //hiển thị danh sách nhân viên
    public void displayAll() {
        System.out.println("Mã NV     Tên nhân viên          Lương");
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
    //tìm nhân viên theo mã
    public Employee findById(String id) {
        for (Employee employee : employeeList) {
            if (employee.getId().equalsIgnoreCase(id)) {
                return employee;
            }
        }
        return null; 
    }
    //cập nhật lương nhân viên theo mã
    public Boolean updateSalary(String id, double newSalary) {
        Employee employee = findById(id);
        if (employee != null) {
            employee.setSalary(newSalary);
            return true;
        }
        return false;
    }
    //xóa nhân viên theo mã
    public boolean removeEmployee(String id) {
        Employee employee = findById(id);
        if (employee != null) {
            employeeList.remove(employee);
            return true; 
        }
        return false;
    }
}
