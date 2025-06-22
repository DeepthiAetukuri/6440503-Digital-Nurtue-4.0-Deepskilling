import java.util.HashMap;
import java.util.Scanner;
public class InventoryManager {
    static class Product {
        int productId;
        String productName;
        int quantity;
        double price;
        public Product(int productId, String productName, int quantity, double price) {
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }
        @Override
        public String toString() {
            return productId + " - " + productName + " - Qty: " + quantity + " -Rupees " + price;
        }
    }
    static HashMap<Integer, Product> inventory = new HashMap<>();
    public static void addProduct(Product p) {
        inventory.put(p.productId, p);
    }
    public static void updateProduct(int productId, int newQty, double newPrice) {
        Product p = inventory.get(productId);
        if (p != null) {
            p.quantity = newQty;
            p.price = newPrice;
        } else {
            System.out.println("Product not found.");
        }
    }
    public static void deleteProduct(int productId) {
        if (inventory.remove(productId) == null) {
            System.out.println("Product not found.");
        }
    }
    public static void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        for (Product p : inventory.values()) {
            System.out.println(p);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        addProduct(new Product(1, "Keyboard", 100, 599.99));
        addProduct(new Product(2, "Mouse", 200, 299.50));
        addProduct(new Product(3, "Monitor", 50, 7499.00));
        System.out.println("Initial Inventory:");
        displayInventory();
        System.out.println("\nUpdating product ID 2...");
        updateProduct(2, 180, 279.00);
        displayInventory();
        System.out.println("\nDeleting product ID 1...");
        deleteProduct(1);
        displayInventory();
        sc.close();
    }
}
