package Lab2.modelEmployee;

public class Employee {
    private String id;
    private String name;
    private double salary;

    // Constructors
    public Employee() {
    }

    public Employee(String id, String name, double salary) {
        // this.id = id;
        // this.name = name;
        // this.salary = salary;
        setId(id);
        setName(name);
        setSalary(salary);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Employee ID cannot be null or empty.");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Employee name cannot be null or empty.");
        }
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Employee salary cannot be negative.");
        }
        this.salary = salary;
    }

    // Override toString()
    @Override
    public String toString() {
        return String.format("Employee{id='%s', name='%s', salary=%.2f}", id, name, salary);
    }
}
