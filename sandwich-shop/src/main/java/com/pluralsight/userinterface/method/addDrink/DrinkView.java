package com.pluralsight.userinterface.method.addDrink;

import com.pluralsight.orders.Order;
import com.pluralsight.drinks.Drink;
import com.pluralsight.drinks.DrinkSize;
import com.pluralsight.drinks.DrinkType;
import java.util.Scanner;

public class DrinkView {

    private final Scanner s = new Scanner(System.in);

    // Method to add a drink to the order
    public void addDrinkToOrder(Order currentOrder) {
        // Get the drink size and type from the user
        DrinkSize sizeOfDrink = getDrinkSizeFromUser();
        DrinkType typeOfDrink = getDrinkTypeFromUser();

        // Create the Drink object with selected size and type
        Drink selectedDrink = new Drink(sizeOfDrink, typeOfDrink);

        // Add the selected drink to the current order
        currentOrder.addItem(selectedDrink);

        // Print confirmation message
        System.out.println("You added a " + typeOfDrink + " of size " + sizeOfDrink + " to your order.");
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
                    case 1 -> selectedDrinkSize = DrinkSize.SMALL;
                    case 2 -> selectedDrinkSize = DrinkSize.MEDIUM;
                    case 3 -> selectedDrinkSize = DrinkSize.LARGE;
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
    public DrinkType getDrinkTypeFromUser() {
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
                    case 1 -> selectedDrinkType = DrinkType.LEMONADE;
                    case 2 -> selectedDrinkType = DrinkType.COKE;
                    case 3 -> selectedDrinkType = DrinkType.PEPSI;
                    case 4 -> selectedDrinkType = DrinkType.SPRITE;
                    case 5 -> selectedDrinkType = DrinkType.FRUIT_PUNCH;
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
