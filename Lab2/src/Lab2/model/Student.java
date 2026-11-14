package Lab2.model;
public class Student {
    private String id;
    private String name;
    private StudentType type;
    public Student() {
    }
    public Student(String id, String name, StudentType type) {
        // this.id = id;
        // this.name = name;
        setId(id);
        setName(name);
        this.type = type;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        if(id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }
    public StudentType getType() {
        return type;
    }
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", type=" + type + "]";
    }
    
    
}
