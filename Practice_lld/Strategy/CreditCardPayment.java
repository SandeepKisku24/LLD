package Strategy;
public class CreditCardPayment implements PaymentProcess {
    
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing card payment of amount: " + amount);
    }
}
