package Lab1.importedproduct;

import Lab1.product.Product;

public class ImportedProduct extends Product {
    private double importTaxRate; 
    private double shippingFee;   

    public ImportedProduct(String id, String name, double basePrice, double importTaxRate, double shippingFee) {
        super(id, name, basePrice);
        setImportTaxRate(importTaxRate);
        setShippingFee(shippingFee);
    }

    // Getter và Setter có validate
    public double getImportTaxRate() {
        return importTaxRate;
    }

    public void setImportTaxRate(double importTaxRate) {
        if (importTaxRate < 0 || importTaxRate > 1) {
            throw new IllegalArgumentException("Thuế nhập khẩu phải nằm trong khoảng từ 0 đến 1!");
        }
        this.importTaxRate = importTaxRate;
    }

    public double getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(double shippingFee) {
        if (shippingFee < 0) {
            throw new IllegalArgumentException("Phí vận chuyển phải lớn hơn hoặc bằng 0!");
        }
        this.shippingFee = shippingFee;
    }

    // Override phương thức finalPrice()
    @Override
    public double finalPrice() {
        return getBasePrice() + (getBasePrice() * importTaxRate) + shippingFee;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Thuế: %2.0f%% | Phí VC: %,8.2f (Nhập khẩu)",
                importTaxRate * 100, shippingFee);
    }
}
