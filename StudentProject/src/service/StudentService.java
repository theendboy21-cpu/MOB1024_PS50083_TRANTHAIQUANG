package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import model.Student;

public class StudentService {
    //lưu danh sách sinh viên
    List<Student> students = new ArrayList<>();
    //lưu mã số sinh viên
    Set<String> studentIds = new HashSet<>();
    
    //thêm sinh viên
    public Boolean addStudent(Student student) {
        String id = student.getId();
        if (studentIds.contains(id)) {
            return false;
        } else{
            students.add(student);
            studentIds.add(id);
        return true;
        }
    }
    //in ra danh sách sinh viên
    public void displayStudents() {
        System.out.println("ID         Name                GPA");
        for (Student student : students) {
            System.out.println(student);
        }
    }
    //xóa sinh viên theo mã số
    public Boolean removeStudent(String id) {
        for (Student student : students) {
            if (student.getId().equalsIgnoreCase(id)) {
                students.remove(student);
                studentIds.remove(id);
                return true;
            }
        }
        return false;
    }
    //tìm kiếm sinh viên theo id
    public Boolean findStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }
    //cập  nhật thông tin sinh viên theo id
    public Boolean updateStudent(Student student) {
        String id = student.getId();
        Student oldStudent = findStudentById(id) ? student : null;
        if(oldStudent != null) {
            return false;
        }
        else {
            student.setGpa(student.getGpa());
            student.setName(student.getName());
            return true;
        }
    }
}
