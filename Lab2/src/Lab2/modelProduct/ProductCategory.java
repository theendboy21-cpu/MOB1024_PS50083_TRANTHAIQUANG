package Lab2.modelProduct;

public enum ProductCategory {
    FOOD,
    ELECTRONICS,
    CLOTHING;
    
    private final String name;

    ProductCategory() {
        this.name = this.name().toLowerCase();
    }

    public String getName() {
        return name;
    }
}
