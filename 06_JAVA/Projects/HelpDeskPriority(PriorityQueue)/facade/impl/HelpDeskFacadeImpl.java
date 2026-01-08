package facade.impl;
import java.util.PriorityQueue;
import java.util.Queue;

import facade.HelpDeskFacade;
import model.SupportTicket;

public class HelpDeskFacadeImpl implements HelpDeskFacade {
    Queue<SupportTicket> line = new PriorityQueue<>();
    @Override
    public SupportTicket getNextSupportTicket() {
       return line.poll();
    }
    @Override
    public int getNumberOfTickets() {
        return line.size();
    }
    @Override
    public void addNewSupportTicket(SupportTicket supportTicket) {
        line.offer(supportTicket);
    }
}
