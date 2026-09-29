package Strategy;

import Strategy.enums.PaymentType;
public class Main {
    public static void main(String[] args) {
        System.out.println("Strategy Pattern Example");
        // Payment strategy can be changed at runtime
        System.out.println("Select the payment method");
        String paymentMethod = Math.random() < 0.2 ? "CREDIT_CARD" : Math.random() < 0.4 ? "UPI" : "NA"; // Randomly selecting payment method for demonstration
        switch (PaymentType.valueOf(paymentMethod)) {
            case CREDIT_CARD:
                PaymentContext creditCardPayment = new PaymentContext(new CreditCardPayment());
                creditCardPayment.pay(100.0);
                break;
            case UPI:
                PaymentContext upiPayment = new PaymentContext(new UPIPayment());
                upiPayment.pay(200.0);
                break;
            default:
                System.out.println("Invalid payment method");
                break;
        }
                
    }
}
