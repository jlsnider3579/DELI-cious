package com.pluralsight.toppings;

import com.pluralsight.sandwich.Product;
import com.pluralsight.sandwich.SandwichSize;

// The Topping class is an abstract class that implements the Product interface.
// It represents a topping that can be added to a sandwich (e.g., cheese, lettuce, bacon, etc.).
// This class provides a structure for defining different types of toppings with specific pricing rules.
public abstract class Topping implements Product {
    protected boolean hasExtra;
    protected SandwichSize size;

    // Constructor for initializing a topping with the sandwich size and whether it is an extra topping.
    public Topping(SandwichSize size, boolean hasExtra) {
        this.size = size;
        this.hasExtra = hasExtra;
    }

    public Topping() {

    }

    // Abstract method to calculate the price of the topping.
    // Subclasses must implement this method with specific pricing logic for each topping.
    @Override
    public abstract double getPrice();


}
