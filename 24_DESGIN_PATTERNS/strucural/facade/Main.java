public class Main {
    public  static  void main(String[] args) {
        Inventory inventory = new Inventory();
        PaymentProccessor paymentProccessor = new PaymentProccessor();
        Logistics logistics = new Logistics();
        OrderFacade orderFacade = new OrderFacade(inventory,logistics,paymentProccessor);
        boolean isValid = orderFacade.makeOrder("Laptop",2,5.0,"visa","heliopolis");
        System.out.println(isValid);
    }
}
