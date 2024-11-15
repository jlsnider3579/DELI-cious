package com.pluralsight.drinks;

import com.pluralsight.sandwich.Product;

// The Drink class implements the Product interface and represents a drink with a specific size and type.
// It allows for calculating the price based on the drink size and provides details about the drink.
public class Drink implements Product {
    private DrinkSize drinkSize;
    private DrinkType drinkType;

    // Constructor for creating a Drink object with its size and type
    public Drink(DrinkSize drinkSize, DrinkType drinkType) {
        this.drinkSize = drinkSize;
        this.drinkType = drinkType;
    }




    @Override
    public String getCsvString() {
        return drinkType + "\n " + drinkSize + "\n$ " + getPrice();
    }

    // Method to calculate the price of the drink.
    // This price is based on the size of the drink (e.g., SMALL, MEDIUM, LARGE).
    @Override
    public double getPrice(){
        switch (drinkSize) {
            case SMALL -> { return 2.00; }
            case MEDIUM -> {
                return 2.50;
            }
            case LARGE -> {
                return 3.00;
            }
            default -> {
                return 0.0;
            }
        }
    }

    @Override
    public String toString() {
        return "Drink [size=" + drinkSize + ", type=" + drinkType + "]";
    }


}
