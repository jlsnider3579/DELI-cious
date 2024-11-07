package com.pluralsight.sandwich;

import java.util.List;

// The Sandwich class represents a sandwich with a specific bread type, size, and a list of toppings.
public class Sandwich {
    private String breadType;
    private String size;
    private List<Topping> toppings;

    // Constructor
    public Sandwich(String breadType, String size, List<Topping> toppings) {
        this.breadType = breadType;
        this.size = size;
        this.toppings = toppings;
    }

    // Getters and setters
    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    // Method to calculate the total price of the sandwich
    public void totalPrice() {
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "breadType='" + breadType + '\'' +
                ", size='" + size + '\'' +
                ", toppings=" + toppings +
                '}';
    }
}
