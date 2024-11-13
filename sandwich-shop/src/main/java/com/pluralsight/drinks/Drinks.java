package com.pluralsight.drinks;

import java.util.List;

public class Drinks {
    private List<Drinks> drinksList;
    private DrinkSize size;

    public Drinks(List<Drinks> drinksList, DrinkSize size) {
        this.drinksList = drinksList;
        this.size = size;
    }

    public List<Drinks> getDrinksList() {
        return drinksList;
    }

    public void setDrinksList(List<Drinks> drinksList) {
        this.drinksList = drinksList;
    }

    public DrinkSize getSize() {
        return size;
    }

    public void setSize(DrinkSize size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Drinks{" +
                "drinksList=" + drinksList +
                ", size=" + size +
                '}';
    }
}
