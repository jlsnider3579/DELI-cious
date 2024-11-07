package com.pluralsight.sandwhich;

public class Order {
    private int orderNumber;
    private String oderReceipt;

    public Order(int orderNumber, String oderReceipt) {
        this.orderNumber = orderNumber;
        this.oderReceipt = oderReceipt;
    }

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

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", oderReceipt='" + oderReceipt + '\'' +
                '}';
    }
}
