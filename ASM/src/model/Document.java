package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Document implements Serializable {
    private static final long serialVersionUID = 1L;

    private String docId;
    private String title;
    private String author;
    private List<Copy> copies; 

    public Document(String docId, String title, String author) {
        this.docId = docId;
        this.title = title;
        this.author = author;
        this.copies = new ArrayList<>();
    }

    public String getDocId() { return docId; }
    public void setDocId(String docId) { this.docId = docId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public List<Copy> getCopies() { return copies; }

    @Override
    public String toString() {
        return String.format("Mã TL: %-8s | Tên: %-25s | Tác giả: %-18s | Số bản sao: %d",
                docId, title, author, copies.size());
    }
}