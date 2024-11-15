package com.pluralsight.userinterface.method.addSandwich;

import com.pluralsight.orders.Order;
import com.pluralsight.sandwich.BreadType;
import com.pluralsight.sandwich.Sandwich;
import com.pluralsight.sandwich.SandwichSize;
import com.pluralsight.toppings.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Method to add a sandwich to an order
public class SandwichView {
    private final List<Topping> toppings = new ArrayList<>();
    ArrayList<MeatType> meatTypes = new ArrayList<>();
    ArrayList<CheeseType> cheeseTypes = new ArrayList<>();
    ArrayList<RegularToppingType> regularToppingTypes = new ArrayList<>();
    Scanner s = new Scanner(System.in);

    public void addSandwich(Order order) {
        BreadType bread = chooseBreadType();
        SandwichSize sandwichSize = chooseSandwichSize();

        // Allow the user to choose meats, cheese, and toppings
        chooseOneOrMoreMeatTypes(sandwichSize);
        chooseOneOrMoreCheeseTypes(sandwichSize);
        chooseToppings();

        // Create a new sandwich object with all selected options
        Sandwich sandwich = new Sandwich(sandwichSize, bread, toppings, isToasted(), meatTypes, cheeseTypes, regularToppingTypes);
        System.out.println(sandwich);
        order.addItem(sandwich);
    }

    // Method to let the user choose a sandwich size
    private SandwichSize chooseSandwichSize() {
        double breadSizePrice = 0;
        SandwichSize selectedSandwichSize = null;
        boolean validInput = false;

        // Keep asking the user until a valid input is received
        while (!validInput) {
            System.out.println("""
                    \nSelect your desired bread size:
                    
                    1. Small
                    2. Medium
                    3. Large
                    """);

            if (s.hasNextInt()) {  // Check if the input is an integer
                int breadChoice = s.nextInt();
                s.nextLine();   // Clear the newline character

                // Assign the appropriate sandwich size based on user input
                switch (breadChoice) {

                    case 1 -> {
                        selectedSandwichSize = SandwichSize.SMALL;
                        validInput = true;
                        breadSizePrice = 5.50;
                        System.out.println(" $ " + breadSizePrice);

                    }
                    case 2 -> {
                        selectedSandwichSize = SandwichSize.MEDIUM;
                        validInput = true;
                        breadSizePrice = 7.00;
                        System.out.println(" $ " + breadSizePrice);

                    }
                    case 3 -> {
                        selectedSandwichSize = SandwichSize.LARGE;
                        validInput = true;
                        breadSizePrice = 8.50;
                        System.out.println(" $ " + breadSizePrice);
                    }

                    default -> System.out.println("Invalid choice, please choose a number between 1 and 3.");

                }

            } else {
                System.out.println("Invalid input, please enter a number.");
                s.nextLine();  // Clear the invalid input
            }
        }

        System.out.println("You selected " + selectedSandwichSize);
        return selectedSandwichSize;
    }

    // Method to let the user choose a bread type
    private BreadType chooseBreadType() {

        BreadType selectedBreadType = null;
        boolean validInput = false;

        // Keep asking the user until a valid input is received
        while (!validInput) {
            System.out.println("""
                    \nSelect your desired bread type:
                    
                    1) WHITE
                    2) WHEAT
                    3) RYE
                    4) WRAP
                    """);

            if (s.hasNextInt()) {  // Check if the input is an integer
                int breadChoice = s.nextInt();
                s.nextLine();  // Clear the newline character

                // Assign the appropriate bread type based on user input
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
                s.nextLine();  // Clear the invalid input
            }
        }

        System.out.println("You selected " + selectedBreadType + " BREAD ");
        return selectedBreadType;
    }

    // Method to determine the price of meat based on sandwich size
    public static double getMeatPriceBySize(SandwichSize sandwichSize) {
        double meatPrice = 0;
        switch (sandwichSize) {

            case SMALL -> {
                meatPrice = 1.00;
                System.out.println(" $ " + meatPrice);
            }

            case MEDIUM -> {
                meatPrice = 2.00;
                System.out.println(" $ " + meatPrice);
            }

            case LARGE -> {
                meatPrice = 3.00;
                System.out.println(" $ " + meatPrice);
            }
        }

        return meatPrice;
    }

    // Allows for user to choose on or more
    private void chooseOneOrMoreMeatTypes(SandwichSize sandwichSize) {
        MeatType selectedMeatType = null;
        boolean tryAgain = true;
        double meatPrice = 0;

        do {
            System.out.println("""
                    \nSelect your desired type of meat:
                    
                    \nYou may select multiple by adding a comma (,)
                    
                    1) STEAK
                    2) HAM
                    3) SALAMI
                    4) ROAST BEEF
                    5) CHICKEN
                    6) BACON
                    """);


            // Read the next line of input
            String inputString = s.nextLine();
            // Try to split it
            String[] meatChoices = inputString.split(",");


            for (int i = 0; i < meatChoices.length; i++) {

                int meatChoice = Integer.parseInt(meatChoices[i]);
                MeatType meatType = null;

                switch (meatChoice) {
                    case 1 -> {
                        meatType = MeatType.STEAK;
                    }
                    case 2 -> {
                        meatType = MeatType.HAM;
                    }
                    case 3 -> {
                        meatType = MeatType.SALAMI;
                    }
                    case 4 -> {
                        meatType = MeatType.ROAST_BEEF;
                    }
                    case 5 -> {
                        meatType = MeatType.CHICKEN;
                    }
                    case 6 -> {
                        meatType = MeatType.BACON;
                    }
                    default -> {
                        System.out.println("Invalid choice, please choose a number between 1 and 6.");
                        tryAgain = true;
                        break;
                    }
                }

                if (meatType == null) continue;

                Meat m = new Meat(sandwichSize, false, meatType);
                toppings.add(m);
                meatTypes.add(meatType);
                System.out.println("You selected: " + meatType);
                boolean hasExtra = askUserIfTheyWantExtra(sandwichSize);
                m.setHasExtra(hasExtra);
                meatPrice += m.getPrice();
            }

            System.out.println(" $ " + meatPrice);
            tryAgain = false;


        } while (tryAgain);

    }

    // Ask if they would like extra
    private boolean askUserIfTheyWantExtra(SandwichSize sandwichSize) {
        boolean validInput;
        double extraMeatPrice = 0;
        boolean hasExtra = false;
        System.out.println("""
                    Would you like extra?
                    1. Yes
                    2. No
                """);
        if (s.hasNextInt()) {
            int hasExtraChoice = s.nextInt();
            s.nextLine();

            switch (hasExtraChoice) {
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
        } else {
            System.out.println("Invalid input please choose a number ");
            s.nextLine();
        }
        return hasExtra;
    }

    // Get the extra price
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

    // Allow the user to chose one or more
    private void chooseOneOrMoreCheeseTypes(SandwichSize sandwichSize) {

        CheeseType selectedCheeseType = null;
        boolean validInput = false;
        double cheesePrice = 0;

        while (!validInput) {
            System.out.println("""
                    \nSelect your desired type of cheese
                    
                    \nYou can select multiple by adding a comma (,)
                    
                    1. American
                    2. Provolone
                    3. Cheddar
                    4. Swiss
                    """);
            try {
                if (s.hasNextLine()) {
                    String[] cheeseChoices = s.nextLine().split(",");

                    for (int i = 0; i < cheeseChoices.length; i++) {


                        int cheeseChoice = Integer.parseInt(cheeseChoices[i]);

                        switch (cheeseChoice) {
                            case 1 -> {
                                cheeseTypes.add(CheeseType.AMERICAN);
                                validInput = true;
                                cheesePrice += getCheesePriceBySandwichSize(sandwichSize);
                            }
                            case 2 -> {
                                cheeseTypes.add(CheeseType.CHEDDAR);
                                validInput = true;
                                cheesePrice += getCheesePriceBySandwichSize(sandwichSize);
                            }

                            case 3 -> {
                                cheeseTypes.add(CheeseType.PROVOLONE);
                                validInput = true;
                                cheesePrice += getCheesePriceBySandwichSize(sandwichSize);
                            }

                            case 4 -> {
                                cheeseTypes.add(CheeseType.SWISS);
                                validInput = true;
                                cheesePrice += getCheesePriceBySandwichSize(sandwichSize);
                            }
                            default -> System.out.println("Invalid choice, please choose a number between 1 and 4.");
                        }
                    }

                } else {
                    System.out.println("Invalid input, please enter a number.");
                    s.nextLine();  // Clear the invalid input
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input try again");
            }
        }
        double extraCheesePrice = 0;
        boolean hasExtraCheese = true;

        while (hasExtraCheese) {
            System.out.println("""
                    Would you like extra cheese
                    1.Yes
                    2.No
                    """);
            if (s.hasNextInt()) {
                int choice = s.nextInt();
                s.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.println("You chose extra");
                        hasExtraCheese = false;
                        switch (sandwichSize) {
                            case SMALL -> {
                                extraCheesePrice = 0.30;
                                System.out.println(" $ " + extraCheesePrice);
                            }
                            case MEDIUM -> {
                                extraCheesePrice = 0.60;
                                System.out.println(" $ " + extraCheesePrice);
                            }
                            case LARGE -> {
                                extraCheesePrice = 0.90;
                                System.out.println(" $ " + extraCheesePrice);
                            }

                        }
                        System.out.println("You selected" + selectedCheeseType + "CHEESE ");
                    }
                    case 2 -> {
                        System.out.println("you chose no extra cheese ");
                        hasExtraCheese = false;
                    }
                    default -> {
                        System.out.println("invalid choice please chose between 1 and 2 ");
                        hasExtraCheese = false;
                    }
                }
            } else {
                System.out.println("Invalid input please choose a number ");
                s.nextLine();
            }

            //System.out.println("You selected" + selectedCheeseType + "CHEESE ");
            toppings.add(new Cheese(sandwichSize, hasExtraCheese, selectedCheeseType));
        }
    }

    private static double getCheesePriceBySandwichSize(SandwichSize sandwichSize) {
        double cheesePrice = 0;
        switch (sandwichSize) {
            case SMALL -> {
                cheesePrice = 0.75;
                System.out.println(" $ " + cheesePrice);
            }
            case MEDIUM -> {
                cheesePrice = 1.50;
                System.out.println(" $ " + cheesePrice);
            }
            case LARGE -> {
                cheesePrice = 2.25;
                System.out.println(" $ " + cheesePrice);
            }

        }
        return cheesePrice;
    }

    private void chooseToppings() {

        RegularToppingType selectedToppingType = null;

        boolean validInput = false;

        while (!validInput) {
            System.out.println("""
                    \nSelect your desired Toppings
                    
                    \nYou may select multiple by adding a comma (,)
                    
                    1. Lettuce
                    2. Peppers
                    3. Onions
                    4. Tomatoes
                    5. Jalepenos
                    6. Cucumbers
                    7. Pickles
                    8. Guacamole
                    9. Mushroom
                    10.Mayo
                    11.Mustard
                    """);

            if (s.hasNextLine()) {
                String[] toppingChoices = s.nextLine().split(",");

                for (int i = 0; i < toppingChoices.length; i++) {

                    try {
                        int toppingChoice = Integer.parseInt(toppingChoices[i]);

                        switch (toppingChoice) {
                            case 1 -> {
                                regularToppingTypes.add(RegularToppingType.LETTUCE);
                                validInput = true;
                            }

                            case 2 -> {
                                regularToppingTypes.add(RegularToppingType.PEPPERS);
                                validInput = true;
                            }

                            case 3 -> {
                                regularToppingTypes.add(RegularToppingType.ONIONS);
                                validInput = true;
                            }

                            case 4 -> {
                                regularToppingTypes.add(RegularToppingType.TOMATOES);
                                validInput = true;
                            }

                            case 5 -> {
                                regularToppingTypes.add(RegularToppingType.JALEPENOS);
                                validInput = true;
                            }

                            case 6 -> {
                                regularToppingTypes.add(RegularToppingType.CUCUMBERS);
                                validInput = true;
                            }

                            case 7 -> {
                                regularToppingTypes.add(RegularToppingType.PICKLES);
                                validInput = true;
                            }

                            case 8 -> {
                                regularToppingTypes.add(RegularToppingType.GUACAMOLE);
                                validInput = true;
                            }

                            case 9 -> {
                                regularToppingTypes.add(RegularToppingType.MUSHROOMS);
                                validInput = true;
                            }

                            case 10 -> {
                                regularToppingTypes.add(RegularToppingType.MAYO);
                                validInput = true;
                            }

                            case 11 -> {
                                regularToppingTypes.add(RegularToppingType.MUSTARD);
                                validInput = true;
                            }

                            default -> System.out.println("Invalid choice, please choose a number between 1 and 4.");
                        }
                    } catch (NumberFormatException e) {
                    }
                }
            } else {
                System.out.println("Invalid input, please enter a number.");
                s.nextLine();  // Clear the invalid input
            }
            System.out.println(regularToppingTypes);

        }
    }

    // Method to determine if sandwich is toasted or not.
    public boolean isToasted() {
        boolean validInput = false;
        boolean toasted = false;
        while (!validInput) {
            System.out.println("""
                    \nWould you Like your sandwich toasted?
                    1. Yes
                    2. No
                    """);
            if (s.hasNextInt()) ;
            int isToastedChoice = s.nextInt();
            s.nextLine();

            // Switch statement based on user input toasted sandwich will be true or false.
            switch (isToastedChoice) {
                case 1 -> {
                    System.out.println("You chose sandwich is toasted.");
                    validInput = true;
                    toasted = true;
                }

                case 2 -> {
                    System.out.println("You chose sandwich is not toasted. ");
                    validInput = true;
                }

                default -> System.out.println("Invalid input choose a number between 1 and 2 ");
            }
            System.out.println(toasted);
        }
        return toasted;
    }

}