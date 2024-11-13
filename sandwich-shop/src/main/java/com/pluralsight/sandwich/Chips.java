package com.pluralsight.sandwich;

// The Chips class implements the Product interface and represents a chips item (e.g., bag of chips) that can accompany a sandwich order.
// It allows for the calculation of a fixed price and provides a description of the chips type.
public class Chips implements Product {
    private ChipsType type;

    // Constructor for creating a Chips object with a specific type
    public Chips(ChipsType type) {
        this.type = type;
    }

    // Method to calculate the price of the chips.
    // The price is fixed at $1.50 for any type of chips.
    @Override
    public double getPrice() {
        // Price is fixed at 1.50, regardless of the chip type
        return 1.50;
    }

    @Override
    public String toString() {
        return "Chips [type=" + type + "]";
    }
}
