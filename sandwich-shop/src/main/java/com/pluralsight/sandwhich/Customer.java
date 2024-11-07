package com.pluralsight.sandwhich;

import java.util.List;

public class Customer {

    // The name of the customer
    private String customerName;

    // The customer's current order
    private Order customerOrder;

    // Constructor
    public Customer(String customerName, Order customerOrder) {
        this.customerName = customerName;
        this.customerOrder = customerOrder;
    }

    // Getters and setters
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Order getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(Order customerOrder) {
        this.customerOrder = customerOrder;
    }

    // Method for adding an item to the customer's order
    public void addItemToOrder() {
    }

    // Method to view the current order details
    public void viewOrder() {
    }

    // Method to remove a specific item
    //public boolean removeItem(){
    // }

    // Method to clear the customer's current order
    public void clearOrder() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                ", customerOrder=" + customerOrder +
                '}';
    }
}
