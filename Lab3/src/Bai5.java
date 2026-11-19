import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Bai5 {
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

        Map<StudentType, Long> countByType = students.stream()
                .collect(Collectors.groupingBy(Student::getType, Collectors.counting()));

        System.out.println("--- 1. Số lượng sinh viên theo từng loại ---");
        countByType.forEach((type, count) -> System.out.println(type + ": " + count + " sinh viên"));

        Map<StudentType, Double> avgGpaByType = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getType,
                        Collectors.averagingDouble(Student::getGpa)
                ));

        System.out.println("\n--- 2. GPA trung bình theo từng loại ---");
        avgGpaByType.forEach((type, avgGpa) -> System.out.printf("%s: %.2f%n", type, avgGpa));

        var highestAvgType = avgGpaByType.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        System.out.println("\n--- 3. Loại sinh viên có GPA trung bình cao nhất ---");
        highestAvgType.ifPresent(entry ->
                System.out.printf("%s (GPA trung bình: %.2f)%n", entry.getKey(), entry.getValue())
        );

        System.out.println("\n--- Thống kê tổng hợp theo từng loại ---");
        Map<StudentType, DoubleSummaryStatistics> statsByType = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getType,
                        Collectors.summarizingDouble(Student::getGpa)
                ));
        statsByType.forEach((type, stats) ->
                System.out.printf("%s -> Số lượng: %d | TB: %.2f | Max: %.2f | Min: %.2f%n",
                        type, stats.getCount(), stats.getAverage(), stats.getMax(), stats.getMin())
        );
    }
}