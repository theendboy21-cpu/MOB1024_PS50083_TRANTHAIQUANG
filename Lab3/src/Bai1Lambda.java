import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Bai1Lambda {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList(
                "An", "Binh", "Cuong", "Dung", "Hoang",
                "Khanh", "Linh", "Minh", "Nguyen", "Phuong", "Quang"));

        System.out.println("--- 1. Toàn bộ danh sách ---");
        names.forEach(name -> System.out.println(name));

        System.out.println("\n--- 2. Các tên có độ dài > 5 ---");
        Predicate<String> lengthGreaterThan5 = name -> name.length() > 5;
        names.forEach(name -> {
            if (lengthGreaterThan5.test(name)) {
                System.out.println(name);
            }
        });

        System.out.println("\n--- 3. Sắp xếp từ A-Z ---");
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));

        names.forEach(name -> System.out.println(name));

        System.out.println("\n--- 4. Sắp xếp theo độ dài tăng dần ---");
        Comparator<String> byLength = (s1, s2) -> Integer.compare(s1.length(), s2.length());
        names.sort(byLength);
        names.forEach(name -> System.out.println(name + " (" + name.length() + " ký tự)"));
    }
}