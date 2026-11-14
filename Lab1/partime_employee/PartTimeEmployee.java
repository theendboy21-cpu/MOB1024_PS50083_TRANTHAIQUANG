package Lab1.partime_employee;

import Lab1.employee.Employee;

public class PartTimeEmployee extends Employee {
    private double workingHours;
    private double hourlyRate;

    // Constructor đầy đủ
    public PartTimeEmployee(String id, String name, double basicSalary, double workingHours, double hourlyRate) {
        super(id, name, basicSalary);
        setWorkingHours(workingHours);
        setHourlyRate(hourlyRate);
    }

    // Getter và Setter có validate (>= 0)
    public double getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(double workingHours) {
        if (workingHours < 0) {
            throw new IllegalArgumentException("Số giờ làm việc phải >= 0!");
        }
        this.workingHours = workingHours;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate < 0) {
            throw new IllegalArgumentException("Lương theo giờ phải >= 0!");
        }
        this.hourlyRate = hourlyRate;
    }

    // Override income() = workingHours * hourlyRate
    @Override
    public double income() {
        return workingHours * hourlyRate;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Giờ làm: %5.1f | Đơn giá/h: %,8.2f (Part-time)",
                workingHours, hourlyRate);
    }
}
