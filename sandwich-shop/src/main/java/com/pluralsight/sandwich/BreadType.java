package com.pluralsight.sandwich;

public enum BreadType {
    WHITE("white bread "),
    WHEAT("Wheat bread "),
    RYE("Rye "),
    WRAP("Wrap "),
    ;

    private final String name;

    BreadType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

