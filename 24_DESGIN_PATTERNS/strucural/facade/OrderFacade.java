public class OrderFacade {
    private final Inventory inventory;
    private final Logistics logistics;
    private final PaymentProccessor paymentProccessor;

    public OrderFacade(Inventory inventory, Logistics logistics, PaymentProccessor paymentProccessor) {
        this.inventory = inventory;
        this.logistics = logistics;
        this.paymentProccessor = paymentProccessor;
    }
    public boolean makeOrder(String productName,Integer quantity,Double amount,String paymentMethod,String addressDetails) {
        boolean order = inventory.order(productName,quantity);
        boolean payment = paymentProccessor.processPayment(paymentMethod,amount);
        boolean address = logistics.setAddress(addressDetails);
        return order && payment && address;
    }
}
