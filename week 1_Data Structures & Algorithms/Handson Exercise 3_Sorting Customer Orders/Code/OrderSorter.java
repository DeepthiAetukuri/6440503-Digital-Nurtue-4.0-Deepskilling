public class OrderSorter {
    static class Order {
        int orderId;
        String customerName;
        double totalPrice;
        public Order(int orderId, String customerName, double totalPrice) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.totalPrice = totalPrice;
        }
        @Override
        public String toString() {
            return orderId + " - " + customerName + " - Rupees " + totalPrice;
        }
    }
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }
    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }
    public static void displayOrders(Order[] orders) {
        for (Order o : orders) {
            System.out.println(o);
        }
    }
    public static void main(String[] args) {
        Order[] orders = {
            new Order(101, "Deepthi", 4500.00),
            new Order(102, "Priya", 1999.99),
            new Order(103, "Varsha", 8999.50),
            new Order(104, "Anu", 1200.00),
            new Order(105, "Trisha", 5000.00)
        };
        System.out.println("Original Orders:");
        displayOrders(orders);
        System.out.println("\nSorted by Bubble Sort:");
        bubbleSort(orders);
        displayOrders(orders);
        orders = new Order[]{
            new Order(101, "Deepthi", 4500.00),
            new Order(102, "Priya", 1999.99),
            new Order(103, "Varsha", 8999.50),
            new Order(104, "Anu", 1200.00),
            new Order(105, "Trisha", 5000.00)
        };

        // Quick Sort
        System.out.println("\nSorted by Quick Sort:");
        quickSort(orders, 0, orders.length - 1);
        displayOrders(orders);
    }
}
