package com.pluralsight.sandwich;


import java.util.List;

// The Sandwich class implements the Product interface and represents a sandwich with specific properties,
// including size, bread type, toppings (which include meats and cheeses), and whether it is toasted.
public class Sandwich implements Product {
    private SandwichSize size;
    private BreadType bread;
    private List<Topping> toppings;
    private List<RegularTop> regToppings;
    private boolean isToasted;

    // Constructor for creating a Sandwich object with all its properties
    public Sandwich(SandwichSize size, BreadType bread,List<Topping> toppings, boolean isToasted, List<RegularTop> regToppings) {
        this.size = size;
        this.bread = bread;
        this.toppings = toppings;
        this.isToasted = isToasted;
        this.regToppings = regToppings;
    }

    // Method to calculate the price of the sandwich.
    // Currently, the price is based on the size of the sandwich, bread, and toppings.
    @Override
    public double getPrice() {
        double price = getBreadPrice();  // Base price for the bread based on size
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
                ", isToasted=" + isToasted +
                '}';
    }
}








