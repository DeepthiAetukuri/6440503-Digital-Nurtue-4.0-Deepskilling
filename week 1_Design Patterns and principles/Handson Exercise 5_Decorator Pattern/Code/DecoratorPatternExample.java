public class DecoratorPatternExample {
    interface Notifier {
        void send(String message);
    }
    static class EmailNotifier implements Notifier {
        public void send(String message) {
            System.out.println("Sending Email: " + message);
        }
    }
    static abstract class NotifierDecorator implements Notifier {
        protected Notifier notifier;
        public NotifierDecorator(Notifier notifier) {
            this.notifier = notifier;
        }
        public void send(String message) {
            notifier.send(message);  
        }
    }
    static class SMSNotifierDecorator extends NotifierDecorator {
        public SMSNotifierDecorator(Notifier notifier) {
            super(notifier);
        }
        public void send(String message) {
            super.send(message);
            sendSMS(message);
        }
        private void sendSMS(String message) {
            System.out.println("Sending SMS: " + message);
        }
    }
    static class SlackNotifierDecorator extends NotifierDecorator {
        public SlackNotifierDecorator(Notifier notifier) {
            super(notifier);
        }
        public void send(String message) {
            super.send(message);
            sendSlack(message);
        }
        private void sendSlack(String message) {
            System.out.println("Sending Slack Message: " + message);
        }
    }
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();
        Notifier emailAndSMS = new SMSNotifierDecorator(emailNotifier);
        Notifier fullNotifier = new SlackNotifierDecorator(emailAndSMS);
        fullNotifier.send("System maintenance scheduled at 10 PM tonight.");
    }
}
