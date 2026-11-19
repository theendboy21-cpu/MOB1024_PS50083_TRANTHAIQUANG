import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Bai4 {
    public static void main(String[] args) {
   
        List<Student> students = new ArrayList<>();
        students.add(new Student("SV01", "An", StudentType.REGULAR, 3.4));
        students.add(new Student("SV02", "Binh", StudentType.INTERNATIONAL, 3.6));
        students.add(new Student("SV03", "Cuong", StudentType.PART_TIME, 2.8));
        students.add(new Student("SV04", "Dung", StudentType.INTERNATIONAL, 3.1));
        students.add(new Student("SV05", "Giang", StudentType.REGULAR, 3.8));
        students.add(new Student("SV06", "Hoang", StudentType.PART_TIME, 3.0));
        students.add(new Student("SV07", "Khanh", StudentType.INTERNATIONAL, 3.9));
        students.add(new Student("SV08", "Linh", StudentType.REGULAR, 2.9));
        students.add(new Student("SV09", "Minh", StudentType.PART_TIME, 3.3));
        students.add(new Student("SV10", "Phuong", StudentType.INTERNATIONAL, 3.5));

        System.out.println("--- 1. Sinh viên INTERNATIONAL có GPA >= 3.2 ---");
        students.stream()
                .filter(st -> st.getType() == StudentType.INTERNATIONAL && st.getGpa() >= 3.2)
                .forEach(System.out::println);

        System.out.println("\n--- 2. Top 3 sinh viên có GPA cao nhất ---");
        students.stream()
                .sorted(Comparator.comparingDouble(Student::getGpa).reversed())
                .limit(3)
                .forEach(System.out::println);

        System.out.println("\n--- 3. Danh sách tên sinh viên PART_TIME ---");
        List<String> partTimeNames = students.stream()
                                             .filter(st -> st.getType() == StudentType.PART_TIME)
                                             .map(Student::getName)
                                             .collect(Collectors.toList());
        System.out.println(partTimeNames);
    }
}