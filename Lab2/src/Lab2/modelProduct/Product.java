package Lab2.modelProduct;

public class Product {
    private String id;
    private String name;
    private double price;
    private ProductCategory category;

    public Product(String id, String name, double price, ProductCategory category) {
        setId(id);
        setName(name);
        setPrice(price);
        setCategory(category);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Product ID cannot be null or empty.");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty.");
        }
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Product price cannot be negative.");
        }
        this.price = price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        if (category == null) {
            throw new IllegalArgumentException("Product category cannot be null.");
        }
        this.category = category;
    }

    @Override
    public String toString() {
        return String.format("Product{id='%10s', name='%20s', price=%10.2f, category=%10s}",
                id, name, price, category);
    }
}
