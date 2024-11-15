package com.pluralsight.orders;

import com.pluralsight.sandwich.Product;

import java.util.ArrayList;

// The Order class represents a customer's order, which consists of multiple items (products).
// It calculates the total price of all items added to the order and provides a string representation of the order.
public class Order {
    private final ArrayList<Product> items;

    // Constructor to create an empty order.
    public Order() {
        this.items = new ArrayList<>();
    }

    // Method to add an item (product) to the order.
    public void addItem(Product item) {
        items.add(item);
    }

    // Method to calculate the total price of the order by summing the prices of all items.
    // Loop through each item in the order and add its price to the total price.
    public double getPrice() {
        double totalPrice = 0;
        for (Product item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    // Generates a formatted receipt
    public String getStringForReceipt(){
        StringBuilder sB = new StringBuilder();
        for (Product p: items) {
            sB.append(p.getStringForReceipt()).append("\n");

            // Append the total price at the bottom of the receipt
            sB.append("\nTotal Price: $").append(String.format("%.2f", getPrice()));
        }

        return sB.toString();
    }

    @Override
    public String toString() {
        return "Order with total price: " + getPrice();
    }
}
