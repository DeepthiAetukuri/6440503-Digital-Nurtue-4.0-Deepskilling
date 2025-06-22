import java.util.Arrays;
import java.util.Comparator;
public class EcommerceSearch {
    static class Product {
        int productId;
        String productName;
        String category;
        public Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }
        @Override
        public String toString() {
            return productId + " - " + productName + " - " + category;
        }
    }
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }
    public static Product binarySearch(Product[] products, String targetName) {
        int left = 0, right = products.length - 1;
        targetName = targetName.toLowerCase();
        while (left <= right) {
            int mid = (left + right) / 2;
            String midName = products[mid].productName.toLowerCase();

            int cmp = midName.compareTo(targetName);
            if (cmp == 0) return products[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }
    public static void displayProducts(Product[] products) {
        for (Product product : products) {
            System.out.println(product);
        }
    }
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shoes", "Footwear"),
            new Product(103, "Watch", "Accessories"),
            new Product(104, "Smartphone", "Electronics"),
            new Product(105, "Bag", "Travel")
        };
        System.out.println("All Products:");
        displayProducts(products);
        System.out.println("\nLinear Search for 'Watch':");
        Product foundLinear = linearSearch(products, "Watch");
        System.out.println(foundLinear != null ? "Found: " + foundLinear : "Product not found.");
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));
        System.out.println("\nBinary Search for 'Watch':");
        Product foundBinary = binarySearch(products, "Watch");
        System.out.println(foundBinary != null ? "Found: " + foundBinary : "Product not found.");
    }
}
