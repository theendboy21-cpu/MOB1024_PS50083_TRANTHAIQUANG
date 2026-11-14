package Lab1;

import Lab1.importedproduct.ImportedProduct;
import Lab1.product.Product;
import java.util.ArrayList;
import java.util.List;

public class Main_Product {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        List<ImportedProduct> importedProducts = new ArrayList<>();

        // 1. Tạo tối thiểu 5 sản phẩm (gồm 3 sản phẩm thường và 2 sản phẩm nhập khẩu)
        products.add(new Product("P01", "Chuột Logitech", 450000));
        products.add(new Product("P02", "Bàn phím Akko", 1200000));
        products.add(new Product("P03", "Tai nghe Sony", 2500000));
        importedProducts.add(new ImportedProduct("IP01", "Laptop Dell", 15000000, 0.1, 500000));  // Thuế 10%
        importedProducts.add(new ImportedProduct("IP02", "Màn hình LG", 6000000, 0.05, 300000));   // Thuế 5%
        // 2. In danh sách sản phẩm kèm giá cuối cùng
        System.out.println("=== DANH SÁCH SẢN PHẨM ===");
        for (Product p : products) {
            System.out.println(p);
        }
        for (ImportedProduct p : importedProducts) {
            System.out.println(p);
        }

        // 3. Tìm sản phẩm có finalPrice() cao nhất
        Product maxProduct = products.get(0);
        for (Product p : products) {
            if (p.finalPrice() > maxProduct.finalPrice()) {
                maxProduct = p;
            }
        }

        ImportedProduct maxImportedProduct = null;
        for (ImportedProduct p : importedProducts) {
            if (maxImportedProduct == null || p.finalPrice() > maxImportedProduct.finalPrice()) {
                maxImportedProduct = p;
            }
        }

        System.out.println("\n=== SẢN PHẨM CÓ GIÁ CUỐI CÙNG CAO NHẤT ===");
        if (maxImportedProduct != null && maxImportedProduct.finalPrice() > maxProduct.finalPrice()) {
            System.out.println(maxImportedProduct);
        } else {
            System.out.println(maxProduct);
        }
    }
}



