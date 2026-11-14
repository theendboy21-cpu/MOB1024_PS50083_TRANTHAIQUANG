package Lab2;

import Lab2.model.Student;
import Lab2.service.StudentService;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        List<Student> students = StudentService.createSampleStudents();

        System.out.println("In toàn bộ danh sách sinh viên: ");
        StudentService.printStudents(students);
        System.out.println("Đếm số lượng sinh viên theo loại: ");
        StudentService.printStudentCountByType(students);
        System.out.println("In danh sách sinh viên theo loại: ");
        StudentService.printStudentCountByType(students);
    }
    
}

