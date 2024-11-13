package com.pluralsight.sandwich;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// The Sandwich class represents a sandwich with a specific bread type, size, and a list of toppings.
public class Sandwich {
    private BreadType breadType;
    private List<String> ingredients;
    private SandwichSize size;
    private boolean isToasted;

    // Constructor
    public Sandwich(BreadType breadType, List<String> ingredients, SandwichSize size, boolean isToasted) {
        this.breadType = breadType;
        this.ingredients = ingredients;
        this.size = size;
        this.isToasted = isToasted;
    }

    // Getters and setters
    public BreadType getBreadType() {
        return breadType;
    }

    public void setBreadType(BreadType breadType) {
        this.breadType = breadType;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public SandwichSize getSize() {
        return size;
    }

    public void setSize(SandwichSize size) {
        this.size = size;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    private Map<SandwichSize, Double> pricesBySize = Map.of(SandwichSize.SMALL, 2.,
            SandwichSize.MEDIUM, 4., SandwichSize.LARGE, 6.);

    public double getPrice() {
        double costOfSandwich = 0;


                costOfSandwich += pricesBySize.get(size);
                // Add cost of premium toppings



        return costOfSandwich;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "breadType=" + breadType +
                ", ingredients=" + ingredients +
                ", size=" + size +
                ", isToasted=" + isToasted +
                '}';
    }
}






