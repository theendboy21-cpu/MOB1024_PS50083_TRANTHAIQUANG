import model.Ticket;
import service.TicketService;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Ticket> tickets = TicketService.createSampleTickets();

        System.out.println("===== DANH SÁCH VÉ =====");
        TicketService.printAll(tickets);    

        Ticket max = TicketService.findMostExpensive(tickets);
        if (max != null) {
            System.out.println("Vé đắt nhất: " + max); 
        }
    }
}