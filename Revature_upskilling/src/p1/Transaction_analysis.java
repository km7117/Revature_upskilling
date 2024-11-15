package p1;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

class Transaction {
    private String customerId;
    private String productName;
    private LocalDate transactionDate;
    private double amount;

    // Constructor
    public Transaction(String customerId, String productName, LocalDate transactionDate, double amount) {
        this.customerId = customerId;
        this.productName = productName;
        this.transactionDate = transactionDate;
        this.amount = amount;
    }

    // Getters
    public String getCustomerId() {
        return customerId;
    }

    public String getProductName() {
        return productName;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "customerId='" + customerId + '\'' +
                ", productName='" + productName + '\'' +
                ", transactionDate=" + transactionDate +
                ", amount=" + amount +
                '}';
    }
}

 class Main {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
            new Transaction("C1", "ProductA", LocalDate.now().minusDays(10), 100.0),
            new Transaction("C2", "ProductA", LocalDate.now().minusDays(5), 200.0),
            new Transaction("C1", "ProductB", LocalDate.now().minusDays(15), 300.0),
            new Transaction("C3", "ProductA", LocalDate.now().minusDays(2), 150.0),
            new Transaction("C2", "ProductB", LocalDate.now().minusDays(1), 400.0)
        );

        // Filter transactions within the last 30 days
        LocalDate thirtyDaysAgo = LocalDate.now().minusDays(30);
        Map<String, List<Transaction>> topCustomersByProduct = transactions.stream()
            .filter(t -> t.getTransactionDate().isAfter(thirtyDaysAgo))
            .collect(Collectors.groupingBy(Transaction::getProductName)) // Group by product
            .entrySet()
            .stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> entry.getValue().stream() // Process each product's transactions
                    .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed()) // Sort by amount descending
                    .limit(3) // Take top 3
                    .collect(Collectors.toList())
            ));

        // Display the results
        topCustomersByProduct.forEach((product, topTransactions) -> {
            System.out.println("Product: " + product);
            topTransactions.forEach(System.out::println);
        });
    }
}
