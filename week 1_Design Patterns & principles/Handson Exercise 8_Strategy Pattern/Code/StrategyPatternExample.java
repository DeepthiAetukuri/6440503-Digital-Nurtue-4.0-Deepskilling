interface PaymentStrategy {
    void pay(double amount);
}
class PaymentContext {
    private PaymentStrategy paymentStrategy;
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    public void payAmount(double amount) {
        if (paymentStrategy == null) {
            System.out.println("Payment strategy not set!");
        } else {
            paymentStrategy.pay(amount);
        }
    }
}
public class StrategyPatternExample
 {
     public static void main(String[] args) {
        PaymentContext context = new PaymentContext();
        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432"));
        context.payAmount(250.00);
        System.out.println();
        context.setPaymentStrategy(new PayPalPayment("deepthi@gmail.com"));
        context.payAmount(125.50);
    }
}
