public class StudentTicket extends ticket{
    private final double discountPercent;
    public StudentTicket(String Id, String movie, double basePrice, double discountPercent){
        super( Id,  movie,  basePrice);

        this.discountPercent = discountPercent;
    }
   @Override 
       public double finalPrice(){
           return getbasePrice() * (1 - discountPercent / 100);
       }
}
