package model;

public enum CopyStatus {
    GOOD("Còn tốt"),
    DAMAGED("Hư hỏng"),
    LOST("Mất");

    private final String description;

    CopyStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}