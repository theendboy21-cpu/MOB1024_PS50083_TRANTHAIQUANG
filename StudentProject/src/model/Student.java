package model;
public class Student {
    private String id;
    private String name;
    private double gpa;

    public Student(String id, String name, double gpa) {
        // this.id = id;
        // this.name = name;
        // this.gpa = gpa;
        setId(id);
        setName(name);
        setGpa(gpa);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        if (gpa < 0 || gpa > 4) {
            throw new IllegalArgumentException("GPA must be between 0 and 4");
        }
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "%s       %s        %.2f".formatted(id, name, gpa);
    }
    
}
