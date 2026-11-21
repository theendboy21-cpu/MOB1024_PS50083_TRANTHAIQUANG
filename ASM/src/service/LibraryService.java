package service;

import exception.DuplicateIdException;
import model.Copy;
import model.CopyStatus;
import model.Document;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class LibraryService {
   
    private Map<String, Document> documentMap = new LinkedHashMap<>();
    private final String FILE_PATH = "library_data.dat";

    // --- QUẢN LÝ TÀI LIỆU ---
    public void addDocument(Document doc) throws DuplicateIdException {
        if (documentMap.containsKey(doc.getDocId())) {
            throw new DuplicateIdException("Lỗi: Mã tài liệu '" + doc.getDocId() + "' đã tồn tại!");
        }
        documentMap.put(doc.getDocId(), doc);
    }

    public boolean updateDocument(String docId, String newTitle, String newAuthor) {
        Document doc = documentMap.get(docId);
        if (doc == null) return false;
        doc.setTitle(newTitle);
        doc.setAuthor(newAuthor);
        return true;
    }

    public boolean deleteDocument(String docId) {
        return documentMap.remove(docId) != null;
    }

    public void displayAllDocuments() {
        if (documentMap.isEmpty()) {
            System.out.println("Danh sách tài liệu trống.");
            return;
        }
        for (Document doc : documentMap.values()) {
            System.out.println(doc);
            for (Copy copy : doc.getCopies()) {
                System.out.println(copy);
            }
        }
    }

    // --- QUẢN LÝ BẢN SAO THEO TÀI LIỆU ---
    public void addCopyToDocument(String docId, Copy newCopy) throws DuplicateIdException {
        Document doc = documentMap.get(docId);
        if (doc == null) {
            System.out.println("Không tìm thấy tài liệu có mã: " + docId);
            return;
        }
       
        for (Copy c : doc.getCopies()) {
            if (c.getCopyId().equalsIgnoreCase(newCopy.getCopyId())) {
                throw new DuplicateIdException("Lỗi: Mã bản sao '" + newCopy.getCopyId() + "' đã tồn tại trong tài liệu này!");
            }
        }
        doc.getCopies().add(newCopy);
    }

    public boolean updateCopyStatus(String docId, String copyId, CopyStatus newStatus) {
        Document doc = documentMap.get(docId);
        if (doc != null) {
            for (Copy c : doc.getCopies()) {
                if (c.getCopyId().equalsIgnoreCase(copyId)) {
                    c.setStatus(newStatus);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean deleteCopy(String docId, String copyId) {
        Document doc = documentMap.get(docId);
        if (doc != null) {
            return doc.getCopies().removeIf(c -> c.getCopyId().equalsIgnoreCase(copyId));
        }
        return false;
    }


    @SuppressWarnings("unchecked")
    public void loadFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("Chưa có file dữ liệu cũ. Khởi tạo danh sách mới.");
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            documentMap = (Map<String, Document>) ois.readObject();
            System.out.println("Đọc dữ liệu thành công từ file " + FILE_PATH);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}