package com.pluralsight.sandwich;

import java.util.List;

public class Sandwich {
    private String breadType;
    private List<String> ingredients;
    private SandwichSize size;
    private boolean isToasted;

    public Sandwich(String breadType, List<String> ingredients, SandwichSize size, boolean isToasted) {
        this.breadType = breadType;
        this.ingredients = ingredients;
        this.size = size;
        this.isToasted = isToasted;
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
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
    // Method to calculate the total price of the sandwich
    public void totalPrice() {
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "breadType='" + breadType + '\'' +
                ", ingredients=" + ingredients +
                ", size=" + size +
                ", isToasted=" + isToasted +
                '}';
    }
}
