public class AdapterPatternExample {
    interface PaymentProcessor {
        void processPayment(double amount);
    }
    static class PayPalGateway {
        public void sendPayment(double amount) {
            System.out.println("Payment of $" + amount + " processed via PayPal.");
        }
    }
    static class StripeGateway {
        public void makePayment(double amount) {
            System.out.println("Payment of $" + amount + " processed via Stripe.");
        }
    }
    static class PayPalAdapter implements PaymentProcessor {
        private PayPalGateway paypal;

        public PayPalAdapter(PayPalGateway paypal) {
            this.paypal = paypal;
        }

        public void processPayment(double amount) {
            paypal.sendPayment(amount);
        }
    }
    static class StripeAdapter implements PaymentProcessor {
        private StripeGateway stripe;
        public StripeAdapter(StripeGateway stripe) {
            this.stripe = stripe;
        }
        public void processPayment(double amount) {
            stripe.makePayment(amount);
        }
    }
    public static void main(String[] args) {
        PaymentProcessor paypal = new PayPalAdapter(new PayPalGateway());
        paypal.processPayment(150.00);
        PaymentProcessor stripe = new StripeAdapter(new StripeGateway());
        stripe.processPayment(300.00);
    }
}
