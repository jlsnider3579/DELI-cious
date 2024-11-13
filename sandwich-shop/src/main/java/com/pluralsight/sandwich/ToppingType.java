package com.pluralsight.sandwich;

import java.util.List;

public enum ToppingType {
    REGULAR(List.of("peppers ", "onions ", "tomatoes ", "jalepenos ", "cucumbers ", " pickles", " guacamole ", "mushrooms")),0),
    PREMIUM(List.of("Ham", "Salami", "Roast Beef", "Chicken","Steak", "Bacon")),0),
    ;

    private final List<String> toppings;
    private final double price;

    ToppingType(List<String> toppings, double price) {
        this.toppings = toppings;
        this.price = price;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public double getPrice() {
        return price;
    }
}
