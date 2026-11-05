import java.util.Scanner;
public class ticket {
    private String Id;
    private String movie;
    private double basePrice;

    public ticket(){

    }
    public ticket(String Id, String movie, double basePrice){
        this.Id = Id;
        this.movie = movie;
        this.basePrice = basePrice;        
    }
    public String getId(){
    return Id;
}
public String getmovie(){
    return movie;
}
public double getbasePrice(){
    return basePrice;
}
public void setId(String Id){
    this.Id = Id;
}
public void setmovie(String movie){
    this.movie = movie;
}
public void setbasePrice(double basePrice){
    this.basePrice = basePrice;
}
public void nhap(){
    Scanner sc = new Scanner(System.in);

}
public double finalPrice(){
    return basePrice;
}

public void xuat(){
    System.out.printf("id: %s\nmovie: %s\npay: %.2f%n", Id, movie, finalPrice());
}
}
