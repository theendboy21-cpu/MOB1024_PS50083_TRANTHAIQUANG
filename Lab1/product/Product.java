package Lab1.product;

public class Product {
    private String id;
    private String name;
    private double basePrice;

    // Constructor đầy đủ
    public Product(String id, String name, double basePrice) {
        setId(id);
        setName(name);
        setBasePrice(basePrice);
    }

    // Getter và Setter có validate
    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID không được để rỗng!");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        if (basePrice < 0) {
            throw new IllegalArgumentException("Giá gốc phải lớn hơn hoặc bằng 0!");
        }
        this.basePrice = basePrice;
    }

    // Phương thức tính giá cuối cùng (mặc định = basePrice)
    public double finalPrice() {
        return basePrice;
    }

    @Override
    public String toString() {
        return String.format("ID: %-8s | Tên: %-15s | Giá gốc: %,10.2f | Giá cuối: %,10.2f",
                id, name, basePrice, finalPrice());
    }
}
