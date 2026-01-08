package model.impl;
import model.Priority;
import model.RequestType;
import model.SupportTicket;

public class SupportTicketImpl implements SupportTicket {
    private RequestType type;
    private static int counter;
    private int sequentialNumber;
    {
        sequentialNumber = ++counter;
    }
    public SupportTicketImpl(RequestType type) {
        this.type = type;

    }
    @Override
    public Priority getPriority() {
        if(type == null)
            return null;
        return this.type.getPriority();
    }
    @Override
    public RequestType getRequestType() {
        return this.type;
    }
    @Override
    public Integer getSequentialNumber() {
        return this.sequentialNumber;
    }
    @Override
    public int compareTo(SupportTicket st) {
        int priorityCompare = this.getPriority().compareTo(st.getPriority());
        if(priorityCompare != 0) {
            return priorityCompare;
        }
        return this.getSequentialNumber().compareTo(st.getSequentialNumber());
    }
}
