package Lab2;

import Lab2.serviceProduct.ServiceProduct;

public class ProductMain {
    public static void main(String[] args) {
        
        ServiceProduct productService = new ServiceProduct();

        productService.initData();
        productService.printProducts();
        productService.printProductCountByCategory();
        productService.printTotalPriceByCategory();

    }
}
