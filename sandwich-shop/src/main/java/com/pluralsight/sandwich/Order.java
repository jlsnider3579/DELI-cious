package com.pluralsight.sandwich;

// Order class represents an order in a Sandwich shop with order number and receipt details
public class Order {
    private int orderNumber;
    private String oderReceipt;

    // Constructor
    public Order(int orderNumber, String oderReceipt) {
        this.orderNumber = orderNumber;
        this.oderReceipt = oderReceipt;
    }

    // Getters and setters
    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOderReceipt() {
        return oderReceipt;
    }

    public void setOderReceipt(String oderReceipt) {
        this.oderReceipt = oderReceipt;
    }

    // Override toString method to return a string representation of the Order object
    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", oderReceipt='" + oderReceipt + '\'' +
                '}';
    }
}
