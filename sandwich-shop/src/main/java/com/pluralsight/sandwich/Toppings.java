package com.pluralsight.sandwich;

// Abstract class representing a topping for a sandwich.
public class Toppings {
    private String name;
    private ToppingType type;
    private double price;

    // Constructor
    public Toppings(String name, ToppingType type) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ToppingType getType() {
        return type;
    }

    public void setType(ToppingType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Provides a string representation of the topping object
    @Override
    public String toString() {
        return "Topping{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", price=" + price +
                '}';
    }
}
