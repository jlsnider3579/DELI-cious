package com.pluralsight.toppings;

public class RegularTopping extends Topping {
    private final RegularToppingType toppingType;

    // Constructor to initialize the topping type
    public RegularTopping(RegularToppingType toppingType) {
        super();
        this.toppingType = toppingType;
    }

    // Getter for the topping type
    public RegularToppingType getToppingType() {
        return toppingType;
    }

    @Override
    public String toString() {
        return toppingType.name();
    }

    @Override
    public double getPrice() {
        return 0.0;
    }

    @Override
    public String getStringForReceipt() {
        return "";
    }

    // You can add additional methods to calculate the price or provide details of the topping if needed
}

