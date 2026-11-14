package Lab2.serviceProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import Lab2.modelProduct.Product;
import Lab2.modelProduct.ProductCategory;

public class ServiceProduct {
    private List<Product> products;

    public ServiceProduct() {
        this.products = new ArrayList<>();
    }

    // Phương thức khởi tạo danh sách gồm 8 sản phẩm ban đầu
    public void initData() {
        products.add(new Product("P01", "Bánh mì", 15000, ProductCategory.FOOD));
        products.add(new Product("P02", "Sữa tươi", 25000, ProductCategory.FOOD));
        products.add(new Product("P03", "Mì gói", 8000, ProductCategory.FOOD));
        products.add(new Product("P04", "Điện thoại", 15000000, ProductCategory.ELECTRONICS));
        products.add(new Product("P05", "Tai nghe", 1200000, ProductCategory.ELECTRONICS));
        products.add(new Product("P06", "Laptop", 22000000, ProductCategory.ELECTRONICS));
        products.add(new Product("P07", "Áo sơ mi", 350000, ProductCategory.CLOTHING));
        products.add(new Product("P08", "Quần jean", 500000, ProductCategory.CLOTHING));
    }

    public void printProducts() {
        System.out.println("--- DANH SÁCH SẢN PHẨM ---");
        for (Product p : products) {
            System.out.println(p);
        }
    }
    //đếm số lượng sản phẩm theo từng loại
    public Map<ProductCategory, Integer> countProductsByCategory() {
        Map<ProductCategory, Integer> countMap = new HashMap<>();
        for (Product p : products) {
            ProductCategory category = p.getCategory();
            countMap.put(category, countMap.getOrDefault(category, 0) + 1);
        }
        return countMap;
    }
    public void printProductCountByCategory() {
        Map<ProductCategory, Integer> countMap = countProductsByCategory();
        System.out.println("--- SỐ LƯỢNG SẢN PHẨM THEO LOẠI ---");
        for (Map.Entry<ProductCategory, Integer> entry : countMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    public Map<ProductCategory, Double> calculateTotalPriceByCategory() {
        Map<ProductCategory, Double> totalPriceMap = new HashMap<>();
        for (Product p : products) {
            ProductCategory category = p.getCategory();
            double currentTotal = totalPriceMap.getOrDefault(category, 0.0);
            totalPriceMap.put(category, currentTotal + p.getPrice());
        }
        return totalPriceMap;
    }
    public void printTotalPriceByCategory() {
        Map<ProductCategory, Double> totalPriceMap = calculateTotalPriceByCategory();
        System.out.println("--- TỔNG GIÁ TRỊ SẢN PHẨM THEO LOẠI ---");
        for (Map.Entry<ProductCategory, Double> entry : totalPriceMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
