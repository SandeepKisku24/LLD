package Strategy;

public class UPIPayment implements PaymentProcess {
    
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing UPI payment of amount: " + amount);
    }
    
}
