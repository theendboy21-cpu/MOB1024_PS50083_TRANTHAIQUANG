package model;

import java.io.Serializable;

public class Copy implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String copyId;
    private CopyStatus status;

    public Copy(String copyId, CopyStatus status) {
        this.copyId = copyId;
        this.status = status;
    }

    public String getCopyId() { return copyId; }
    public void setCopyId(String copyId) { this.copyId = copyId; }

    public CopyStatus getStatus() { return status; }
    public void setStatus(CopyStatus status) { this.status = status; }

    @Override
    public String toString() {
        return String.format("   -> Mã bản sao: %-8s | Trạng thái: %s", copyId, status.getDescription());
    }
}