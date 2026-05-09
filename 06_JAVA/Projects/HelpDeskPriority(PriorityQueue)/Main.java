import facade.HelpDeskFacade;
import facade.impl.HelpDeskFacadeImpl;
import model.RequestType;
import model.SupportTicket;
import model.impl.SupportTicketImpl;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== HelpDesk Priority Queue Test ===\n");
        
        HelpDeskFacade helpDesk = new HelpDeskFacadeImpl();
        
        System.out.println("Adding tickets in this order:");
        
        SupportTicket ticket1 = new SupportTicketImpl(RequestType.OTHER);
        System.out.println("1. OTHER (LOW priority)");
        helpDesk.addNewSupportTicket(ticket1);
        
        SupportTicket ticket2 = new SupportTicketImpl(RequestType.ACCOUNT_IS_HACKED);
        System.out.println("2. ACCOUNT_IS_HACKED (HIGH priority)");
        helpDesk.addNewSupportTicket(ticket2);
        
        SupportTicket ticket3 = new SupportTicketImpl(RequestType.CAN_NOT_LOGIN);
        System.out.println("3. CAN_NOT_LOGIN (MEDIUM priority)");
        helpDesk.addNewSupportTicket(ticket3);
        
        SupportTicket ticket4 = new SupportTicketImpl(RequestType.CAN_NOT_COMPLETE_PURCHASE);
        System.out.println("4. CAN_NOT_COMPLETE_PURCHASE (HIGH priority)");
        helpDesk.addNewSupportTicket(ticket4);
        
        SupportTicket ticket5 = new SupportTicketImpl(RequestType.CHANGE_ACCOUNT_DETAILS);
        System.out.println("5. CHANGE_ACCOUNT_DETAILS (LOW priority)");
        helpDesk.addNewSupportTicket(ticket5);
        
        SupportTicket ticket6 = new SupportTicketImpl(RequestType.ACCOUNT_IS_BLOCKED);
        System.out.println("6. ACCOUNT_IS_BLOCKED (MEDIUM priority)");
        helpDesk.addNewSupportTicket(ticket6);
        
        System.out.println("\nTotal tickets in queue: " + helpDesk.getNumberOfTickets());
        
        System.out.println("\n=== Processing Tickets (Expected: HIGH -> MEDIUM -> LOW) ===\n");
        
        while (helpDesk.getNumberOfTickets() > 0) {
            SupportTicket ticket = helpDesk.getNextSupportTicket();
            System.out.printf("Processing Ticket #%d: %s (Priority: %s)%n",
                    ticket.getSequentialNumber(),
                    ticket.getRequestType(),
                    ticket.getPriority());
        }
        
        System.out.println("\nAll tickets processed! Queue size: " + helpDesk.getNumberOfTickets());
    }
}
