package com.pluralsight.orders;

import com.pluralsight.sandwich.Product;

import java.util.ArrayList;

// The Order class represents a customer's order, which consists of multiple items (products).
// It calculates the total price of all items added to the order and provides a string representation of the order.
public class Order {
    private ArrayList<Product> items;
    private double totalPrice;

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
    public double getTotalPrice() {
        totalPrice = 0;
        for (Product item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Order with total price: " + getTotalPrice();
    }
}
