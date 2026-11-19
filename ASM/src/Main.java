
import exception.DuplicateIdException;
import model.Copy;
import model.CopyStatus;
import model.Document;
import service.LibraryService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryService service = new LibraryService();
        Scanner sc = new Scanner(System.in);
        service.loadFromFile(); // Tự động nạp dữ liệu khi mở chương trình

        while (true) {
            System.out.println("\n===== QUẢN LÝ THƯ VIỆN - GIAI ĐOẠN 1 =====");
            System.out.println("1. Thêm tài liệu");
            System.out.println("2. Sửa tài liệu");
            System.out.println("3. Xóa tài liệu");
            System.out.println("4. Xem danh sách tài liệu & bản sao");
            System.out.println("5. Thêm bản sao cho tài liệu");
            System.out.println("6. Cập nhật trạng thái bản sao");
            System.out.println("7. Xóa bản sao");
            System.out.println("8. Lưu dữ liệu ra file");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Nhập mã tài liệu: ");
                    String id = sc.nextLine();
                    System.out.print("Nhập tên tài liệu: ");
                    String title = sc.nextLine();
                    System.out.print("Nhập tác giả: ");
                    String author = sc.nextLine();
                    try {
                        service.addDocument(new Document(id, title, author));
                        System.out.println("Thêm tài liệu thành công!");
                    } catch (DuplicateIdException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Nhập mã tài liệu cần sửa: ");
                    String editId = sc.nextLine();
                    System.out.print("Tên mới: ");
                    String newTitle = sc.nextLine();
                    System.out.print("Tác giả mới: ");
                    String newAuthor = sc.nextLine();
                    System.out.println(service.updateDocument(editId, newTitle, newAuthor) 
                            ? "Cập nhật thành công!" : "Không tìm thấy mã tài liệu!");
                    break;
                case 3:
                    System.out.print("Nhập mã tài liệu cần xóa: ");
                    String delId = sc.nextLine();
                    System.out.println(service.deleteDocument(delId) 
                            ? "Xóa thành công!" : "Không tìm thấy mã tài liệu!");
                    break;
                case 4:
                    service.displayAllDocuments();
                    break;
                case 5:
                    System.out.print("Nhập mã tài liệu cần thêm bản sao: ");
                    String targetDocId = sc.nextLine();
                    System.out.print("Nhập mã bản sao: ");
                    String copyId = sc.nextLine();
                    CopyStatus status = chooseStatus(sc);
                    try {
                        service.addCopyToDocument(targetDocId, new Copy(copyId, status));
                        System.out.println("Thêm bản sao thành công!");
                    } catch (DuplicateIdException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.print("Nhập mã tài liệu: ");
                    String dId = sc.nextLine();
                    System.out.print("Nhập mã bản sao: ");
                    String cId = sc.nextLine();
                    CopyStatus newStatus = chooseStatus(sc);
                    System.out.println(service.updateCopyStatus(dId, cId, newStatus) 
                            ? "Cập nhật trạng thái thành công!" : "Không tìm thấy tài liệu hoặc bản sao!");
                    break;
                case 7:
                    System.out.print("Nhập mã tài liệu: ");
                    String docDelCopy = sc.nextLine();
                    System.out.print("Nhập mã bản sao cần xóa: ");
                    String copyDel = sc.nextLine();
                    System.out.println(service.deleteCopy(docDelCopy, copyDel) 
                            ? "Xóa bản sao thành công!" : "Không tìm thấy dữ liệu!");
                    break;
                case 8:
                    service.saveToFile();
                    break;
                case 0:
                    service.saveToFile();
                    System.out.println("Đã thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static CopyStatus chooseStatus(Scanner sc) {
        System.out.println("Chọn trạng thái (1: Còn tốt | 2: Hư hỏng | 3: Mất): ");
        String opt = sc.nextLine();
        switch (opt) {
            case "2": return CopyStatus.DAMAGED;
            case "3": return CopyStatus.LOST;
            default: return CopyStatus.GOOD;
        }
    }
}