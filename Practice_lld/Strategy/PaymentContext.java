package Strategy;

public class PaymentContext{
    private PaymentProcess payProcess;
    public PaymentContext(PaymentProcess payProcess) {
        this.payProcess = payProcess;
    }
    public void pay(double amount) {
        payProcess.processPayment(amount);
    }
    
}