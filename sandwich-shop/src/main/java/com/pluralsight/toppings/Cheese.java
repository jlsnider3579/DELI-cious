package com.pluralsight.toppings;

import com.pluralsight.sandwich.SandwichSize;

// The Cheese class represents a cheese topping, which is a type of PremiumTopping.
// It extends the PremiumTopping class and adds logic for calculating the price of the cheese
// based on the sandwich size and whether it is considered an "extra" topping.
// Additionally, it includes the type of cheese used in the sandwich.
public class Cheese extends PremiumTopping {
    private CheeseType cheeseType;

    // Constructor for creating a Cheese object with a specific sandwich size, extra flag, and cheese type.
    public Cheese(SandwichSize size, boolean hasExtra, CheeseType cheeseType) {
        super(size, hasExtra);
        this.cheeseType = cheeseType;
    }

    // Override the getPrice() method to calculate the price of the cheese topping based on the sandwich size.
    @Override
    public double getPrice() {
        switch (size) {
            case SMALL -> {
                return 0.75;
            }
            case MEDIUM -> {
                return 1.50;
            }
            case LARGE -> {
                return 2.25;
            }
            default -> {
                return 0.0;
            }
        }
    }

    @Override
    public String getStringForReceipt() {

        return "";
    }

    public CheeseType getCheeseType() {
        return cheeseType;
    }
}

