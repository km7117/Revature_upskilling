 /* question for product_analysis
import java.util.; 
import java.util.stream.; 
class Product {     
    private String name;     
    private String category;     
    private int quantity;     
    private double price;     
    // Constructor, getters, and setters } 
    public class ProductAnalysis {     
        public static void main(String[] args) {         
            List<Product> products = Arrays.asList(             
                new Product("Laptop", "Electronics", 5, 1000.0),        
                new Product("Smartphone", "Electronics", 0, 800.0),     
                new Product("Desk", "Furniture", 10, 200.0),             
                new Product("Chair", "Furniture", 0, 100.0),             
                new Product("Tablet", "Electronics", 3, 300.0)         
                );         
                // Implement logic here to find the most expensive product in each category with quantity > 0     
                  
        } 
        
    }   
                Problem 1: Processing Product Inventory Scenario: You work for an e-commerce company, and you need to analyze product inventory data. The inventory contains products with fields for name, category, quantity, and price. Your task is to find out the most expensive product in each category that has a quantity greater than 0.
*/

import java.util.*;
import java.util.stream.*;

class Product {
    private String name;
    private String category;
    private int quantity;
    private double price;

    // Constructor
    public Product(String name, String category, int quantity, double price) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', category='" + category + "', price=" + price + ", quantity=" + quantity + "}";
    }
}

 class Main {
    public static void main(String[] args) {
        import java.util.*;
import java.util.stream.*;

class Product {
    private String name;
    private String category;
    private int quantity;
    private double price;

    // Constructor
    public Product(String name, String category, int quantity, double price) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', category='" + category + "', price=" + price + ", quantity=" + quantity + "}";
    }
}

 class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 5, 1000.0),
            new Product("Smartphone", "Electronics", 0, 800.0),
            new Product("Desk", "Furniture", 10, 200.0),
            new Product("Chair", "Furniture", 0, 100.0),
            new Product("Tablet", "Electronics", 3, 300.0)
        );

        // Find the most expensive product in each category with quantity > 0
        Map<String, Optional<Product>> mostExpensiveProducts = products.stream()
            .filter(p -> p.getQuantity() > 0)  // Only products with quantity > 0
            .collect(Collectors.groupingBy(
                Product::getCategory, // Group by category
                Collectors.maxBy(Comparator.comparingDouble(Product::getPrice)) // Find the most expensive product
            ));

        // Print the results
        mostExpensiveProducts.forEach((category, product) -> 
            System.out.println("Category: " + category + ", Most Expensive Product: " + product.orElse(null))
        );
    }
}
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 5, 1000.0),
            new Product("Smartphone", "Electronics", 0, 800.0),
            new Product("Desk", "Furniture", 10, 200.0),
            new Product("Chair", "Furniture", 0, 100.0),
            new Product("Tablet", "Electronics", 3, 300.0)
        );

        // Find the most expensive product in each category with quantity > 0
        Map<String, Optional<Product>> mostExpensiveProducts = products.stream()
            .filter(p -> p.getQuantity() > 0)  // Only products with quantity > 0
            .collect(Collectors.groupingBy(
                Product::getCategory, // Group by category
                Collectors.maxBy(Comparator.comparingDouble(Product::getPrice)) // Find the most expensive product
            ));

        // Print the results
        mostExpensiveProducts.forEach((category, product) -> 
            System.out.println("Category: " + category + ", Most Expensive Product: " + product.orElse(null))
        );
    }
}
