import java.util.ArrayList;
import java.util.List;
public class ObserverPatternExample {
    interface Stock {
        void registerObserver(Observer o);
        void deregisterObserver(Observer o);
        void notifyObservers();
    }
    interface Observer {
        void update(String stockName, double price);
    }
    static class StockMarket implements Stock {
        private List<Observer> observers = new ArrayList<>();
        private String stockName;
        private double price;
        public void setStock(String stockName, double price) {
            this.stockName = stockName;
            this.price = price;
            System.out.println("\nStock Update: " + stockName + " is now $" + price);
            notifyObservers();
        }
        public void registerObserver(Observer o) {
            observers.add(o);
        }
        public void deregisterObserver(Observer o) {
            observers.remove(o);
        }
        public void notifyObservers() {
            for (Observer o : observers) {
                o.update(stockName, price);
            }
        }
    }
    static class MobileApp implements Observer {
        private String user;
        public MobileApp(String user) {
            this.user = user;
        }
        public void update(String stockName, double price) {
            System.out.println("MobileApp (" + user + ") received update: " + stockName + " = $" + price);
        }
    }
    static class WebApp implements Observer {
        private String user;
        public WebApp(String user) {
            this.user = user;
        }
        public void update(String stockName, double price) {
            System.out.println("WebApp (" + user + ") received update: " + stockName + " = $" + price);
        }
    }
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        Observer mobileUser1 = new MobileApp("Deepthi");
        Observer webUser1 = new WebApp("Trisha");
        stockMarket.registerObserver(mobileUser1);
        stockMarket.registerObserver(webUser1);
        stockMarket.setStock("AAPL", 150.75);
        stockMarket.setStock("GOOGL", 2800.50);
        stockMarket.deregisterObserver(webUser1);
        stockMarket.setStock("MSFT", 299.99);
    }
}
