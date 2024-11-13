package com.pluralsight.sandwich;

// The Meat class represents a meat topping, which is a type of PremiumTopping.
// It extends the PremiumTopping class and adds logic for calculating the price of the meat
// based on the sandwich size and whether it is considered an "extra" topping.
// Additionally, it keeps track of the type of meat used in the sandwich.
public class Meat extends PremiumTopping {
    private TypeOfMeat meatType;

    // Constructor for creating a Meat object with a specific sandwich size, extra flag, and meat type.
    public Meat(SandwichSize size, boolean hasExtra, TypeOfMeat meatType) {
        super(size, hasExtra);
        this.meatType = meatType;
    }

    // Set the base price for meat based on the sandwich size
    public double getPrice() {
        switch (size) {
            case SMALL:
                return 1.00;
            case MEDIUM:
                return 2.00;
            case LARGE:
                return 3.00;
            default:
                return 0.0;
        }
    }

    public TypeOfMeat getMeatType() {
        return meatType;
    }
}
