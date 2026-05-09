public class PaymentProccessor {
    public boolean processPayment(String payment,Double amount) {
        if ((payment.equals("visa") || payment.equals("mastercard")) && amount > 0) {
            return true;
        }
        return false;
    }
}
