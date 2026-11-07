package model;

public class StudentTicket extends Ticket {
    private double discountRate;

    public StudentTicket(String id, String movie, double basePrice, double discountRate) {
        super(id, movie, basePrice);
        this.discountRate = discountRate;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        if(discountRate < 0 || discountRate > 50) {
            throw new IllegalArgumentException("Discount rate must be between 0 and 50.");
        }
        this.discountRate = discountRate;
    }
    @Override
    public double finalPrice() {
        return getBasePrice() * (100 - discountRate) / 100;
    }
}
