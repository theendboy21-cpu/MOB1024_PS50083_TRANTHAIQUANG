import model.Student;
import service.StudentService;

public class StudenMain {
    public static void main(String[] args) {
        //danh sách sinh viên
        StudentService studentService = new StudentService();
        studentService.addStudent(new Student("S001", "Nguyen Van A", 3.5));
        studentService.addStudent(new Student("S002", "Tran Thi B", 3.8));
        studentService.addStudent(new Student("S001", "Le Van C", 3.2)); // duplicate ID, should not be added
        studentService.displayStudents();
        System.out.println("Danh sách sinh sau khi xóa:");
        studentService.removeStudent("S001");
        studentService.displayStudents();
        System.out.println("Tìm kiếm sinh viên theo ID:");
        System.out.println(studentService.findStudentById("S001"));
        System.out.println("Cập nhật thông tin sinh viên:");
        studentService.updateStudent(new Student("S002", "Tran Thi B Updated", 3.9));
        studentService.displayStudents();
    }

}

