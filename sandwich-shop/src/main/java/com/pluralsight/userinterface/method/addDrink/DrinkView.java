package com.pluralsight.userinterface.method.addDrink;

import com.pluralsight.drinks.Drink;
import com.pluralsight.drinks.DrinkSize;
import com.pluralsight.drinks.DrinkType;
import com.pluralsight.orders.Order;

import java.util.Scanner;

public class DrinkView {

    private Scanner s = new Scanner(System.in);

    // This method handles adding a drink to an order
    public void addDrink(Order order) {
        // Collect drink size and type
        DrinkSize size = getDrinkSizeFromUser();
        DrinkType type = drinkType();

        // Create the Drink object with size and type
        Drink drink = new Drink(size, type);

        // Optionally, print drink details or handle the order
        System.out.println("You added a " + type + " of size " + size + " to your order.");
    }

    // This method calculates and returns the price of the selected drink size
    private double getDrinkPrice(DrinkSize drinkSize) {
        double drinkPrice = 0;

        switch (drinkSize) {
            case SMALL -> drinkPrice = 2.00;
            case MEDIUM -> drinkPrice = 2.50;
            case LARGE -> drinkPrice = 3.00;
        }

        return drinkPrice;
    }

    // This method handles the selection of drink size using a do-while loop
    public DrinkSize getDrinkSizeFromUser() {
        DrinkSize selectedDrinkSize = null;
        boolean validInput;
        double drinkPrice;

        do {
            System.out.println("""
                    Please select your drink size:
                    1. Small
                    2. Medium
                    3. Large
                    """);

            if (s.hasNextInt()) {
                int drinkSizeChoice = s.nextInt();
                s.nextLine(); // Consume the newline character

                validInput = true; // Assume input is valid unless proven otherwise

                switch (drinkSizeChoice) {
                    case 1 -> {
                        selectedDrinkSize = DrinkSize.SMALL;
                        drinkPrice = getDrinkPrice(selectedDrinkSize);
                        System.out.println("You selected Small for $" + drinkPrice);
                    }
                    case 2 -> {
                        selectedDrinkSize = DrinkSize.MEDIUM;
                        drinkPrice = getDrinkPrice(selectedDrinkSize);
                        System.out.println("You selected Medium for $" + drinkPrice);
                    }
                    case 3 -> {
                        selectedDrinkSize = DrinkSize.LARGE;
                        drinkPrice = getDrinkPrice(selectedDrinkSize);
                        System.out.println("You selected Large for $" + drinkPrice);
                    }
                    default -> {
                        System.out.println("Invalid input, please choose a number between 1 and 3.");
                        validInput = false; // Set validInput to false if input is invalid
                    }
                }
            } else {
                System.out.println("Invalid input, please enter a number.");
                s.nextLine(); // Clear invalid input
                validInput = false;
            }
        } while (!validInput); // Repeat until input is valid

        return selectedDrinkSize;
    }

    // This method handles the selection of drink type using a do-while loop
    public DrinkType drinkType() {
        DrinkType selectedDrinkType = null;
        boolean validInput;

        do {
            System.out.println("""
                    Select your desired drink:
                    1. Lemonade
                    2. Coke
                    3. Pepsi
                    4. Sprite
                    5. Fruit Punch
                    """);

            if (s.hasNextInt()) {
                int drinkChoice = s.nextInt();
                s.nextLine();  // Consume the newline character

                validInput = true; // Assume input is valid unless proven otherwise

                switch (drinkChoice) {

                    case 1 -> {
                        selectedDrinkType = DrinkType.LEMONADE;
                    }

                    case 2 -> {
                        selectedDrinkType = DrinkType.COKE;
                    }

                    case 3 -> {
                        selectedDrinkType = DrinkType.PEPSI;
                    }

                    case 4 -> {
                        selectedDrinkType = DrinkType.SPRITE;
                    }

                    case 5 -> {
                        selectedDrinkType = DrinkType.FRUIT_PUNCH;
                    }

                    default -> {
                        System.out.println("Invalid input, please choose a number between 1 and 5.");
                        validInput = false; // Set validInput to false if input is invalid
                    }
                }

            } else {
                System.out.println("Invalid input, please enter a number.");
                s.nextLine();  // Clear invalid input
                validInput = false;
            }
        } while (!validInput); // Repeat until input is valid

        return selectedDrinkType;
    }
}
