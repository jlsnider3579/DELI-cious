package com.pluralsight.userinterface.method.addSandwich;

import com.pluralsight.orders.Order;
import com.pluralsight.sandwich.BreadType;
import com.pluralsight.sandwich.Sandwich;
import com.pluralsight.sandwich.SandwichSize;
import com.pluralsight.toppings.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SandwichView {
    private final List<Topping> toppings = new ArrayList<>();
    private final ArrayList<MeatType> meatTypes = new ArrayList<>();
    private final ArrayList<CheeseType> cheeseTypes = new ArrayList<>();
    private final ArrayList<RegularToppingType> regularToppingTypes = new ArrayList<>();
    private final Scanner s = new Scanner(System.in);
    private final Order currentOrder = new Order();  // Current order object

    // Method to add a sandwich to the order
    public void addSandwichToOrder(Order currentOrder) {
        BreadType bread = chooseBreadType();
        SandwichSize sandwichSize = chooseSandwichSize();
        boolean isToasted = askIfToasted();

        // Allow the user to choose meats, cheese, and toppings
        chooseOneOrMoreMeatTypes(sandwichSize);
        chooseOneOrMoreCheeseTypes(sandwichSize);
        chooseOneOrMoreToppings();

        // Create a new sandwich object with all selected options
        Sandwich sandwich = new Sandwich(sandwichSize, bread, toppings, isToasted, meatTypes, cheeseTypes, regularToppingTypes);
        System.out.println(sandwich);
        currentOrder.addItem(sandwich);  // Add the sandwich to the current order
    }

    // Method to check out
    public void checkout(Order currentOrder) {
        if (currentOrder.getPrice() == 0) {
            System.out.println("Your order is empty. Please add items before checking out.");
        } else {
            // Show the order details and total price
            System.out.println("Order Details:\n" + currentOrder.getStringForReceipt());
            System.out.println("Total Price: $" + currentOrder.getPrice());

            // Here you could add more logic for finalizing payment, confirmation, etc.
            System.out.println("Thank you for your purchase!");
        }
    }

    // Menu for the user to choose bread type
    private BreadType chooseBreadType() {
        BreadType selectedBreadType = null;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("""
                    \nSelect your desired bread type:
                    1) WHITE
                    2) WHEAT
                    3) RYE
                    4) WRAP
                    """);

            if (s.hasNextInt()) {
                int breadChoice = s.nextInt();
                s.nextLine();  // Clear the newline character

                switch (breadChoice) {
                    case 1 -> {
                        selectedBreadType = BreadType.WHITE;
                        validInput = true;
                    }
                    case 2 -> {
                        selectedBreadType = BreadType.WHEAT;
                        validInput = true;
                    }
                    case 3 -> {
                        selectedBreadType = BreadType.RYE;
                        validInput = true;
                    }
                    case 4 -> {
                        selectedBreadType = BreadType.WRAP;
                        validInput = true;
                    }
                    default -> System.out.println("Invalid choice, please choose a number between 1 and 4.");
                }
            } else {
                System.out.println("Invalid input, please enter a number.");
                s.nextLine();
            }
        }

        return selectedBreadType;
    }

    // Menu for the user to choose sandwich size
    private SandwichSize chooseSandwichSize() {
        SandwichSize selectedSandwichSize = null;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("""
                    \nSelect your desired bread size:
                    1. Small
                    2. Medium
                    3. Large
                    """);

            if (s.hasNextInt()) {
                int breadChoice = s.nextInt();
                s.nextLine();   // Clear the newline character

                switch (breadChoice) {
                    case 1 -> {
                        selectedSandwichSize = SandwichSize.SMALL;
                        validInput = true;
                    }
                    case 2 -> {
                        selectedSandwichSize = SandwichSize.MEDIUM;
                        validInput = true;
                    }
                    case 3 -> {
                        selectedSandwichSize = SandwichSize.LARGE;
                        validInput = true;
                    }
                    default -> System.out.println("Invalid choice, please choose a number between 1 and 3.");
                }
            } else {
                System.out.println("Invalid input, please enter a number.");
                s.nextLine();
            }
        }

        return selectedSandwichSize;
    }

    // Ask if the sandwich should be toasted
    private boolean askIfToasted() {
        boolean validInput = false;
        boolean isToasted = false;

        while (!validInput) {
            System.out.println("""
                    Would you like your sandwich toasted?
                    1. Yes
                    2. No
                    """);

            if (s.hasNextInt()) {
                int choice = s.nextInt();
                s.nextLine();  // Clear the newline character

                switch (choice) {
                    case 1 -> {
                        isToasted = true;
                        validInput = true;
                    }
                    case 2 -> {
                        isToasted = false;
                        validInput = true;
                    }
                    default -> System.out.println("Invalid choice, please choose either 1 or 2.");
                }
            } else {
                System.out.println("Invalid input, please enter a number.");
                s.nextLine();
            }
        }

        return isToasted;
    }

    // Handle multiple meat selections
    private void chooseOneOrMoreMeatTypes(SandwichSize sandwichSize) {
        boolean tryAgain = true;
        double meatPrice = 0;

        do {
            System.out.println("""
                    \nSelect your desired type of meat:
                    You may select one or more by adding a comma (,)
                    1) STEAK
                    2) HAM
                    3) SALAMI
                    4) ROAST BEEF
                    5) CHICKEN
                    6) BACON
                    """);

            String inputString = s.nextLine();
            String[] meatChoices = inputString.split(",");

            for (String choice : meatChoices) {
                int meatChoice = Integer.parseInt(choice);
                MeatType meatType = null;

                switch (meatChoice) {
                    case 1 -> meatType = MeatType.STEAK;
                    case 2 -> meatType = MeatType.HAM;
                    case 3 -> meatType = MeatType.SALAMI;
                    case 4 -> meatType = MeatType.ROAST_BEEF;
                    case 5 -> meatType = MeatType.CHICKEN;
                    case 6 -> meatType = MeatType.BACON;
                    default -> System.out.println("Invalid choice, please choose a number between 1 and 6.");
                }

                if (meatType == null) continue;

                Meat m = new Meat(sandwichSize, false, meatType);
                toppings.add(m);
                meatTypes.add(meatType);
                System.out.println("You selected: " + meatType);
                boolean hasExtra = askTheUserIfTheyWantExtraMeat(sandwichSize);
                m.setHasExtra(hasExtra);
                meatPrice +=  m.getPrice();
                meatPrice += m.getPrice();
            }


            tryAgain = false;

        } while (tryAgain);
    }

    private boolean askTheUserIfTheyWantExtraMeat(SandwichSize sandwichSize) {
        boolean validInput;
        double extraMeatPrice = 0;
        boolean hasExtra = false;
        System.out.println("""
                Would you like extra
                1. yes
                2.no
                """);

        if (s.hasNextInt()){
            int hasExtraChoice = s.nextInt();
            s.nextLine();

            switch (hasExtraChoice){
                case 1 -> {
                    System.out.println("You chose extra ");
                    hasExtra = true;
                    extraMeatPrice = getExtraMeatPrice(sandwichSize);
                }
                case 2 -> {
                    System.out.println("You chose no extra ");
                    hasExtra = true;
                }
                default -> {
                    System.out.println("invalid choice please chose between 1 and 2 ");
                    validInput = false;
                }
            }
        }else {
            System.out.println("Invalid input please choose a number ");
            s.nextLine();
        }

        return hasExtra;
    }
    public static double getExtraMeatPrice(SandwichSize sandwichSize) {
        double extraMeatPrice = 0;
        switch (sandwichSize) {

            case SMALL -> {
                extraMeatPrice = 0.50;
                System.out.println(" $ " + extraMeatPrice);
            }

            case MEDIUM -> {
                extraMeatPrice = 1.00;
                System.out.println(" $ " + extraMeatPrice);
            }

            case LARGE -> {
                extraMeatPrice = 1.50;
                System.out.println(" $ " + extraMeatPrice);
            }

        }

        return extraMeatPrice;
    }

    // Handle multiple cheese selections
    private void chooseOneOrMoreCheeseTypes(SandwichSize sandwichSize) {
        boolean tryAgain = true;

        do {
            System.out.println("""
                    \nSelect your desired type of cheese
                    You may select one or more by adding a comma (,)
                    1) American
                    2) Provolone
                    3) Cheddar
                    4) Swiss
                    """);

            String inputString = s.nextLine();
            String[] cheeseChoices = inputString.split(",");

            for (String choice : cheeseChoices) {
                int cheeseChoice = Integer.parseInt(choice);
                CheeseType cheeseType = null;

                switch (cheeseChoice) {
                    case 1 -> cheeseType = CheeseType.AMERICAN;
                    case 2 -> cheeseType = CheeseType.PROVOLONE;
                    case 3 -> cheeseType = CheeseType.CHEDDAR;
                    case 4 -> cheeseType = CheeseType.SWISS;
                    default -> System.out.println("Invalid choice, please choose a number between 1 and 4.");
                }

                if (cheeseType == null) continue;

                Cheese cheese = new Cheese(cheeseType);
                toppings.add(cheese);
                cheeseTypes.add(cheeseType);
                System.out.println("You selected: " + cheeseType);
            }

            tryAgain = false;

        } while (tryAgain);
    }

    // Handle multiple topping selections
    private void chooseOneOrMoreToppings() {
        boolean tryAgain = true;

        do {
            System.out.println("""
                    \nSelect your desired Toppings
                    You may select one or more by adding a comma (,)
                    1. Lettuce
                    2. Peppers
                    3. Onions
                    4. Tomatoes
                    5. Jalapenos
                    6. Cucumbers
                    7. Pickles
                    8. Guacamole
                    9. Mushroom
                    10. Mayo
                    11. Mustard
                    """);

            String inputString = s.nextLine();
            String[] toppingChoices = inputString.split(",");

            for (String choice : toppingChoices) {
                int toppingChoice = Integer.parseInt(choice);
                RegularToppingType toppingType = null;

                switch (toppingChoice) {
                    case 1 -> toppingType = RegularToppingType.LETTUCE;
                    case 2 -> toppingType = RegularToppingType.PEPPERS;
                    case 3 -> toppingType = RegularToppingType.ONIONS;
                    case 4 -> toppingType = RegularToppingType.TOMATOES;
                    case 5 -> toppingType = RegularToppingType.JALEPENOS;
                    case 6 -> toppingType = RegularToppingType.CUCUMBERS;
                    case 7 -> toppingType = RegularToppingType.PICKLES;
                    case 8 -> toppingType = RegularToppingType.GUACAMOLE;
                    case 9 -> toppingType = RegularToppingType.MUSHROOMS;
                    case 10 -> toppingType = RegularToppingType.MAYO;
                    case 11 -> toppingType = RegularToppingType.MUSTARD;
                    default -> System.out.println("Invalid choice, please choose a number between 1 and 11.");
                }

                if (toppingType == null) continue;

                RegularTopping topping = new RegularTopping(toppingType);
                toppings.add(topping);
                regularToppingTypes.add(toppingType);
                System.out.println("You selected: " + toppingType);
            }

            tryAgain = false;

        } while (tryAgain);
    }
}
