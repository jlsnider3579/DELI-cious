package com.pluralsight.orders;

import com.pluralsight.sandwich.Sandwich;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Order class represents an order in a Sandwich shop with order number and receipt details
public class Order {
    private int orderNumber;
    private LocalDateTime timeStamp;
    private List<Sandwich> sandwiches;
    private String name;
    private static int nextOrderNum = 1;

    // Constructor
    public Order() {
        this.timeStamp = LocalDateTime.now();
        this.name = "valuedCustomer";
        this.orderNumber = nextOrderNum ++;
        this.sandwiches = new ArrayList<>();
    }
    public int getOrderNumber() {
        return orderNumber;
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", timeStamp=" + timeStamp +
                ", name='" + name + '\'' +
                '}';
    }
}







