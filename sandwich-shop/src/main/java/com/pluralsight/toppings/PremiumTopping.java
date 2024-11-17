package com.pluralsight.toppings;

import com.pluralsight.sandwich.SandwichSize;

// The PremiumTopping class is an abstract subclass of the Topping class.
// It represents a premium topping that can be added to a sandwich.
public abstract class PremiumTopping extends Topping {
    protected double price;

    // Constructor for creating a PremiumTopping object with a specific size and whether it's extra.
    // The price of the topping will be set according to the topping type
    public PremiumTopping(SandwichSize size, boolean hasExtra) {
        super(size, hasExtra);
        this.price = price;
    }

    public PremiumTopping() {

    }


    @Override
    public double getPrice() {
        return price;
    }
}
