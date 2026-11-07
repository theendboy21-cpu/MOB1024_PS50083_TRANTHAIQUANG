package model;
public class Ticket {
    private String id;
    private String movie;
    private double basePrice;

    public Ticket(String id, String movie, double basePrice) {
        // this.id = id;
        // this.movie = movie;
        // this.basePrice = basePrice;
        setId(id);
        setMovie(movie);
        setBasePrice(basePrice);
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public final void setId(String id) {
        if(id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Ticket ID cannot be null or empty.");
        }
        this.id = id;
    }

    public String getMovie() {
        return movie;
    }

    public final void setMovie(String movie) {
        if(movie == null || movie.isEmpty()) {
            throw new IllegalArgumentException("Movie name cannot be null or empty.");
        }
        this.movie = movie;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public final void setBasePrice(double basePrice) {
        if(basePrice < 0) {
            throw new IllegalArgumentException("Base price cannot be negative.");
        }
        this.basePrice = basePrice;
    }
    public double finalPrice() {
        return basePrice;
    }
    public void printTicketInfo() {
        System.out.println("Ticket ID: " + id + ", Movie: " + movie + ", Base Price: $" + basePrice);
    }
}
