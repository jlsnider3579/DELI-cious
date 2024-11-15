package com.pluralsight.sandwich;


import com.pluralsight.toppings.*;

import java.util.List;

// The Sandwich class implements the Product interface and represents a sandwich with specific properties,
// including size, bread type, toppings (which include meats and cheeses), and whether it is toasted.
public class Sandwich implements Product {
    private SandwichSize size;
    private BreadType bread;
    private List<Topping> toppings;
    private List<MeatType> meatTypes;
    private List<CheeseType> cheeseTypes;
    private List<RegularToppingType> regToppings;
    private boolean isToasted;

    public Sandwich(SandwichSize size, BreadType bread) {
        this.size = size;
        this.bread = bread;
    }

    public void addTopping(Topping t) {
        toppings.add(t);
    }

    // Constructor for creating a Sandwich object with all its properties
    public Sandwich(SandwichSize size, BreadType bread, List<Topping> toppings, boolean isToasted, List<MeatType> meatTypes, List<CheeseType> cheeseTypes, List<RegularToppingType> regToppings) {
        this.size = size;
        this.bread = bread;
        this.toppings = toppings;
        this.isToasted = isToasted;
        this.meatTypes = meatTypes;
        this.cheeseTypes = cheeseTypes;
        this.regToppings = regToppings;
    }

    // Method to calculate the price of the sandwich.
    // Currently, the price is based on the size of the sandwich, bread, and toppings.
    @Override
    public double getPrice() {
        double price = 0;

        // Add the price of the bread to the total price.
        // getBreadPrice() presumably calculates the price of the bread based on size or type.
        price += getBreadPrice();  // Base price for the bread based on size


        for (Topping t : toppings) {
            price += t.getPrice();
        }


        return price;
    }


    // Private helper method to return the price of the bread based on the sandwich size

    private double getBreadPrice() {
        switch (size) {
            case SMALL:
                return 5.50;
            case MEDIUM:
                return 7.00;
            case LARGE:
                return 8.50;
            default:
                return 0.0;
        }
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "size=" + size +
                ", bread=" + bread +
                ", toppings=" + toppings +
                ", typeOfMeats=" + meatTypes +
                ", typeOfCheeses=" + cheeseTypes +
                ", regToppings=" + regToppings +
                ", isToasted=" + isToasted +
                '}';
    }

    @Override
    public String getStringForReceipt() {
        StringBuilder sb = new StringBuilder();

        // Start with "Sandwich:" at the top
        sb.append("Sandwich:\n");

        // Display bread and size
        sb.append(String.format("Bread: %-15s Size: %-10s\n", bread, size));

        // Loop through meat types
        if (!meatTypes.isEmpty()) {
            sb.append("Meats:\n");
            for (MeatType m : meatTypes) {
                sb.append(String.format("  %-15s\n", m));
            }
        }

        // Loop through cheese types
        if (!cheeseTypes.isEmpty()) {
            sb.append("Cheeses:\n");
            for (CheeseType c : cheeseTypes) {
                sb.append(String.format("  %-15s\n", c));
            }
        }

        // Loop through regular toppings
        if (!regToppings.isEmpty()) {
            sb.append("Toppings:\n");
            for (RegularToppingType r : regToppings) {
                sb.append(String.format("  %-15s\n", r));
            }
        }

        return sb.toString();
    }
}








