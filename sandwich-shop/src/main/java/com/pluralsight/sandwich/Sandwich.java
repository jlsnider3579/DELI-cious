package com.pluralsight.sandwich;

import com.pluralsight.toppings.CheeseType;
import com.pluralsight.toppings.MeatType;
import com.pluralsight.toppings.RegularToppingType;
import com.pluralsight.toppings.Topping;

import java.util.List;

public class Sandwich implements Product {
    private final SandwichSize size;
    private final BreadType breadType;
    private final List<Topping> toppings;
    private final boolean isToasted;
    private final List<MeatType> meats;
    private final List<CheeseType> cheeses;
    private final List<RegularToppingType> regularToppings;

    public Sandwich(SandwichSize size, BreadType breadType, List<Topping> toppings, boolean isToasted,
                    List<MeatType> meats, List<CheeseType> cheeses, List<RegularToppingType> regularToppings) {
        this.size = size;
        this.breadType = breadType;
        this.toppings = toppings;
        this.isToasted = isToasted;
        this.meats = meats;
        this.cheeses = cheeses;
        this.regularToppings = regularToppings;
    }

    // Calculate the total price for this sandwich based on size and ingredients
    public double getPrice() {
        double price = 0.0;
        price += getBasePriceForBread();
        price += getPriceForMeats();
        price += getPriceForCheeses();
        price += getPriceForToppings();
        price += isToasted ? 0.00 : 0;  // Extra cost for toasted sandwiches

        return price;
    }

    // Calculate the base price for bread depending on size
    private double getBasePriceForBread() {
        switch (size) {
            case SMALL: return 5.50;
            case MEDIUM: return 7.00;
            case LARGE: return 8.50;
            default: return 0.0;
        }
    }

    // Calculate the price for meats
    private double getPriceForMeats() {
        double meatPrice = 0.0;
        for (MeatType meat : meats) {
            meatPrice += switch (size) {
                case SMALL -> 1.00;
                case MEDIUM -> 2.00;
                case LARGE -> 3.00;
            };
        }
        return meatPrice;
    }

    // Calculate the price for cheeses
    private double getPriceForCheeses() {
        double cheesePrice = 0.0;
        for (CheeseType cheese : cheeses) {
            cheesePrice += switch (size) {
                case SMALL -> 0.75;
                case MEDIUM -> 1.50;
                case LARGE -> 2.25;
            };
        }
        return cheesePrice;
    }

    // Calculate the price for regular toppings
    private double getPriceForToppings() {
        double toppingPrice = 0.0;
        for (Topping topping : toppings) {
            toppingPrice += 0.00;  // Example flat price for each topping
        }
        return toppingPrice;
    }

    // This method should print the details for the sandwich that can be written to a receipt or CSV
    @Override
    public String getStringForReceipt() {
        return "Sandwich: " + size + " | Bread: " + breadType + " | Meats: " + meats + " | Cheeses: " + cheeses
                + " | Toppings: " + regularToppings + " | Toasted: " + (isToasted ? "Yes" : "No") + " | Price: $" + getPrice();
    }

    @Override
    public String toString() {
        return "Sandwich: " + size + " | Bread: " + breadType + " | Price: $" + getPrice();
    }
}
