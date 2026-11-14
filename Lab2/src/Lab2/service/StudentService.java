package Lab2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import Lab2.model.Student;
import Lab2.model.StudentType;

public class StudentService {
    public static List<Student> createSampleStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("SV01", "Nguyễn Văn Sáng", StudentType.REGULAR));
        students.add(new Student("SV02", "Trần Thị Bưởi", StudentType.PART_TIME));
        students.add(new Student("SV03", "John Smith", StudentType.INTERNATIONAL));
        students.add(new Student("SV04", "Phạm Hoàng Duy", StudentType.REGULAR));
        students.add(new Student("SV05", "Vũ Thị Thúy Em", StudentType.PART_TIME));
        students.add(new Student("SV06", "David Miller", StudentType.INTERNATIONAL));
        return students;
    }
    public static void printStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
    
    public static Map<StudentType, Integer> countStudentsByType(List<Student> students) {
        Map<StudentType, Integer> countMap = new HashMap<>();
        for (Student student : students) {
            StudentType type = student.getType();
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }
        return countMap;
    }
    public static void printStudentCountByType(List<Student> students) {
        Map<StudentType, Integer> countMap = countStudentsByType(students);
        System.out.println("--- SỐ LƯỢNG SINH VIÊN THEO LOẠI ---");
        for (Map.Entry<StudentType, Integer> entry : countMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}