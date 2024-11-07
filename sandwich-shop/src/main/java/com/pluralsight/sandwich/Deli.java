package com.pluralsight.sandwich;

import java.awt.*;
import java.util.List;

public class Deli {
    // List of orders currently being processed
    private List<Order> currentOrders;

    // List of sandwiches offered at the deli
    private List<Menu> menu;

    // List of ingredients in the inventory (simplified as List<String>)
    private List<String> inventory;

    // Constructor
    public Deli(List<Order> currentOrders, List<Menu> menu, List<String> inventory) {
        this.currentOrders = currentOrders;
        this.menu = menu;
        this.inventory = inventory;
    }

    // Getters and setters
    public List<Order> getCurrentOrders() {
        return currentOrders;
    }

    public void setCurrentOrders(List<Order> currentOrders) {
        this.currentOrders = currentOrders;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

    public List<String> getInventory() {
        return inventory;
    }

    public void setInventory(List<String> inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "Deli{" +
                "currentOrders=" + currentOrders +
                ", menu=" + menu +
                ", inventory=" + inventory +
                '}';
    }
}

