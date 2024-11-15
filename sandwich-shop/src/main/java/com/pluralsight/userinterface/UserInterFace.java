package com.pluralsight.userinterface;

import com.pluralsight.dataManager.DataManager;
import com.pluralsight.drinks.DrinkSize;
import com.pluralsight.userinterface.method.addDrink.DrinkView;
import com.pluralsight.orders.Order;
import com.pluralsight.toppings.*;
import com.pluralsight.userinterface.method.addSandwich.SandwichView;
import com.pluralsight.userinterface.method.chips.ChipView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterFace {
    Scanner s = new Scanner(System.in);
    Order order = new Order();
    private List<Topping> toppings = new ArrayList<>();
    ArrayList<MeatType> meatTypes = new ArrayList<>();
    ArrayList<CheeseType> cheeseTypes;
    ArrayList<RegularToppingType> regToppings = new ArrayList<>();
    SandwichView sandwichView = new SandwichView();
    DrinkView drinkView = new DrinkView();
    ChipView chipView = new ChipView();


    public void homeScreen() {
        boolean uInput = true;
        while (uInput) {
            System.out.println("""
                    \nWelcome to DELI-cious Sandwich Shop
                    
                    1) New Order
                    0) exit
                    """);
            String choice = s.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Create order ");
                    orderScreen();
                    break;
                case "0":
                    System.out.println("Exiting...");
                    uInput = false;
                    break;
                default:
                    System.out.println("Sorry that was an Invalid response please try again");
            }
        }
    }

    public void orderScreen() {

        boolean uInput = true;
        while (uInput) {
            System.out.println("""
                    
                    \n1) Add sandwich
                    2) Add Drink
                    3) Add Chips
                    4) Checkout
                    0) Cancel order
                    """);
            String choice = s.nextLine();
            switch (choice) {
                case "1":
                    sandwichView.addSandwich(order);
                    break;
                case "2":
                    drinkView.addDrink(order);
                    break;
                case "3":
                    chipView.addChip(order);
                    break;
                case "4":
                    DataManager.createReceipt(order);
                    System.out.println("Thank you for you purchase come back soon!!!");
                    break;
                case "0":
                    cancelOrder(order);
                    uInput = false;
                    break;
                default:
                    System.out.println("Sorry that was an Invalid response please try again ");

            }
        }
    }
    public void cancelOrder(Order order) {

    }



//    public void addSandwich(Order order) {
//        BreadType bread = chooseBreadType();
//        SandwichSize sandwichSize = chooseSandwichSize();
//        chooseMeatType(sandwichSize);
//        chooseCheeseType(sandwichSize);
//        chooseToppings();
//        Sandwich sandwich = new Sandwich(sandwichSize, bread, toppings, isToasted(), typeOfMeats, typeOfCheeses, regToppings);
//        order.addItem(sandwich);
//    }
//    public static double getSandwichSizePrice(SandwichSize sandwichSize){
//        double breadSizePrice = 0;
//        switch (sandwichSize){
//
//            case SMALL ->{breadSizePrice = 5.50; System.out.println(" $ " + breadSizePrice);}
//
//            case MEDIUM -> {breadSizePrice = 7.00; System.out.println(" $ " + breadSizePrice) ;}
//
//            case LARGE -> {breadSizePrice = 8.50; System.out.println(" $ " + breadSizePrice);}
//        }
//
//
//        return breadSizePrice;
//    }
//
//    private SandwichSize chooseSandwichSize() {
//        double breadSizePrice = 0;
//        SandwichSize selectedSandwichSize = null;
//        boolean validInput = false;
//
//
//        while (!validInput) {
//            System.out.println("""
//                    \nSelect your desired bread type:
//
//                    1. Small
//                    2. Medium
//                    3. Large
//                    """);
//
//            if (s.hasNextInt()) {  // Check if the input is an integer
//                int breadChoice = s.nextInt();
//                s.nextLine();   // Clear the newline character
//
//
//                switch (breadChoice) {
//
//                    case 1 -> {selectedSandwichSize = SandwichSize.SMALL;validInput = true; breadSizePrice = getSandwichSizePrice(selectedSandwichSize);
//                    }
//                    case 2 -> {selectedSandwichSize = SandwichSize.MEDIUM; validInput = true;  breadSizePrice = getSandwichSizePrice(selectedSandwichSize);
//                    }
//                    case 3 -> {selectedSandwichSize = SandwichSize.LARGE; validInput = true;    breadSizePrice = getSandwichSizePrice(selectedSandwichSize);
//                    }
//                    default -> System.out.println("Invalid choice, please choose a number between 1 and 3.");
//                }
//            } else {
//                System.out.println("Invalid input, please enter a number.");
//                s.nextLine();  // Clear the invalid input
//            }
//        }
//
//        System.out.println("You selected " + selectedSandwichSize);
//        return selectedSandwichSize;
//    }
//
//
//    private BreadType chooseBreadType() {
//
//        BreadType selectedBreadType = null;
//        boolean validInput = false;
//
//
//        while (!validInput) {
//            System.out.println("""
//                    \nSelect your desired bread type:
//
//                    1) WHITE
//                    2) WHEAT
//                    3) RYE
//                    4) WRAP
//                    """);
//
//            if (s.hasNextInt()) {  // Check if the input is an integer
//                int breadChoice = s.nextInt();
//                s.nextLine();  // Clear the newline character
//
//                switch (breadChoice) {
//
//                    case 1 -> { selectedBreadType = BreadType.WHITE; validInput = true;
//                    }
//                    case 2 -> { selectedBreadType = BreadType.WHEAT; validInput = true;
//                    }
//                    case 3 -> { selectedBreadType = BreadType.RYE; validInput = true;
//                    }
//                    case 4 -> { selectedBreadType = BreadType.WRAP; validInput = true;
//                    }
//                    default -> System.out.println("Invalid choice, please choose a number between 1 and 4.");
//                }
//            } else {
//                System.out.println("Invalid input, please enter a number.");
//                s.nextLine();  // Clear the invalid input
//            }
//        }
//
//        System.out.println("You selected " + selectedBreadType + " BREAD ");
//        return selectedBreadType;
//    }
//    public static double getMeatPriceBySize(SandwichSize sandwichSize){
//        double meatPrice = 0;
//        switch (sandwichSize){
//
//            case SMALL -> {meatPrice = 1.00; System.out.println(" $ " + meatPrice);}
//
//            case MEDIUM -> {meatPrice = 2.00; System.out.println(" $ " + meatPrice);}
//
//            case LARGE -> {meatPrice = 3.00; System.out.println(" $ " + meatPrice);}
//        }
//
//        return meatPrice;
//    }
//
//    private void chooseMeatType(SandwichSize sandwichSize) {
//        TypeOfMeat selectedMeatType = null;
//        boolean validInput = false;
//        double meatPrice = 0;
//
//        while (!validInput) {
//            System.out.println("""
//                    \nSelect your desired type of meat:
//
//                    1) STEAK
//                    2) HAM
//                    3) SALAMI
//                    4) ROAST BEEF
//                    5) CHICKEN
//                    6) BACON
//                    """);
//
//            if (s.hasNextLine()) {
//                String[] meatChoices = s.nextLine().split(",");
//                for (int i = 0; i < meatChoices.length; i++) {
//                    int meatChoice;
//
//                    try {
//                        meatChoice = Integer.parseInt(meatChoices[i]);
//
//
//                        switch (meatChoice) {
//
//                            case 1 -> {
//                                typeOfMeats.add(TypeOfMeat.STEAK);
//                                validInput = true;
//                                meatPrice = getMeatPriceBySize(sandwichSize);
//                            }
//
//                            case 2 -> {
//                                typeOfMeats.add(TypeOfMeat.HAM);
//                                validInput = true;
//                            }
//
//                            case 3 -> {
//                                typeOfMeats.add(TypeOfMeat.SALAMI);
//                                validInput = true;
//                            }
//
//                            case 4 -> {
//                                typeOfMeats.add(TypeOfMeat.ROAST_BEEF);
//                                validInput = true;
//                            }
//
//                            case 5 -> {
//                                typeOfMeats.add(TypeOfMeat.CHICKEN);
//                                validInput = true;
//                            }
//
//                            case 6 -> {
//                                typeOfMeats.add(TypeOfMeat.BACON);
//                                validInput = true;
//                            }
//
//                            default -> System.out.println("Invalid choice, please choose a number between 1 and 6.");
//                        }
//                    } catch (NumberFormatException nFE) {
//                        System.out.println("Invalid input try again");
//
//                    }
//                }
//            } else {
//                System.out.println("Invalid input, please enter a number.");
//                s.nextLine();  // Clear the invalid input
//            }
//            System.out.println("You selected" + typeOfMeats);
//        }
//
//        double extraMeatPrice = 0;
//        boolean hasExtra = false;
//        System.out.println("""
//                    Would you like extra?
//                    1. Yes
//                    2. No
//                """);
//        if (s.hasNextInt()) {
//            int hasExtraChoice = s.nextInt();
//            s.nextLine();
//
//            switch (hasExtraChoice) {
//                case 1 -> {System.out.println("You chose extra "); hasExtra = true; extraMeatPrice = getExtraMeatPrice(sandwichSize);}
//
//                case 2 -> {System.out.println("You chose no extra "); hasExtra = true;}
//
//                default -> {System.out.println("invalid choice please chose between 1 and 2 ");validInput = false;}
//            }
//        } else {
//            System.out.println("Invalid input please choose a number ");
//            s.nextLine();
//        }
//
//        toppings.add(new Meat(sandwichSize, hasExtra, selectedMeatType));
//
//    }
//    public static double getExtraMeatPrice(SandwichSize sandwichSize){
//        double extraMeatPrice = 0;
//       switch (sandwichSize){
//
//           case SMALL -> {extraMeatPrice = 0.50; System.out.println(" $ " + extraMeatPrice);}
//
//           case MEDIUM -> {extraMeatPrice = 1.00; System.out.println(" $ " + extraMeatPrice);}
//
//           case LARGE -> {extraMeatPrice = 1.50; System.out.println(" $ " + extraMeatPrice);}
//
//       }
//
//        return extraMeatPrice;
//    }
//
//    private void chooseCheeseType(SandwichSize sandwichSize) {
//
//        TypeOfCheese selectedCheeseType = null;
//        boolean validInput = false;
//        double cheesePrice = 0;
//
//        while (!validInput) {
//            System.out.println("""
//                    \nSelect your desired type of cheese
//
//                    1. American
//                    2. Provolone
//                    3. Cheddar
//                    4. Swiss
//                    """);
//
//            if (s.hasNextLine()) {
//                String[] cheeseChoices = s.nextLine().split(",");
//
//                for (int i = 0; i < cheeseChoices.length; i++){
//                    int cheeseChoice = Integer.parseInt(cheeseChoices[i]);
//
//                    switch (cheeseChoice) {
//                        case 1 -> {
//                            typeOfCheeses.add(TypeOfCheese.AMERICAN);
//                            validInput = true;
//                        }
//                        case 2 -> {
//                            typeOfCheeses.add(TypeOfCheese.CHEDDAR);
//                            validInput = true;
//                        }
//
//                        case 3 -> {
//                            typeOfCheeses.add(TypeOfCheese.PROVOLONE);
//                            validInput = true;
//                        }
//
//                        case 4 -> {
//                            typeOfCheeses.add(TypeOfCheese.SWISS);
//                            validInput = true;
//                        }
//                        default -> System.out.println("Invalid choice, please choose a number between 1 and 4.");
//                    }
//                }
//            } else {
//                System.out.println("Invalid input, please enter a number.");
//                s.nextLine();  // Clear the invalid input
//            }
//        }
//        double extraCheesePrice = 0;
//        boolean hasExtraCheese = true;
//
//        while (hasExtraCheese) {
//            System.out.println("""
//                    Would you like extra cheese
//                    1.Yes
//                    2.No
//                    """);
//            if (s.hasNextInt()) {
//                int choice = s.nextInt();
//                s.nextLine();
//
//                switch (choice) {
//                    case 1 -> {
//                        System.out.println("You chose extra");
//                        hasExtraCheese = false;
//                        switch (sandwichSize) {
//                            case SMALL -> {
//                                extraCheesePrice = 0.30;
//                                System.out.println(" $ " + extraCheesePrice);
//                            }
//                            case MEDIUM -> {
//                                extraCheesePrice = 0.60;
//                                System.out.println(" $ " + extraCheesePrice);
//                            }
//                            case LARGE -> {
//                                extraCheesePrice = 0.90;
//                                System.out.println(" $ " + extraCheesePrice);
//                            }
//
//                        }
//                        System.out.println("You selected" + selectedCheeseType + "CHEESE ");
//                    }
//                    case 2 -> {
//                        System.out.println("you chose no extra cheese ");
//                        hasExtraCheese = false;
//                    }
//                    default -> {
//                        System.out.println("invalid choice please chose between 1 and 2 ");
//                        hasExtraCheese = false;
//                    }
//                }
//            } else {
//                System.out.println("Invalid input please choose a number ");
//                s.nextLine();
//            }
//
//            //System.out.println("You selected" + selectedCheeseType + "CHEESE ");
//            toppings.add(new Cheese(sandwichSize, hasExtraCheese, selectedCheeseType));
//        }
//    }
//
//    private static double getCheesePriceBySandwichSize(SandwichSize sandwichSize) {
//        double cheesePrice = 0;
//        switch (sandwichSize) {
//            case SMALL -> {
//                cheesePrice = 0.75;
//                System.out.println(" $ " + cheesePrice);
//            }
//            case MEDIUM -> {
//                cheesePrice = 1.50;
//                System.out.println(" $ " + cheesePrice);
//            }
//            case LARGE -> {
//                cheesePrice = 2.25;
//                System.out.println(" $ " + cheesePrice);
//            }
//        }
//        return cheesePrice;
//    }
//
//    private void chooseToppings() {
//
//        RegularTop selectedToppingType = null;
//
//        boolean validInput = false;
//
//        while (!validInput) {
//            System.out.println("""
//                    \nSelect your desired Toppings
//                    If you want multiple toppings please separate by comma
//
//                    1. Lettuce
//                    2. Peppers
//                    3. Onions
//                    4. Tomatoes
//                    5. Jalepenos
//                    6. Cucumbers
//                    7. Pickles
//                    8. Guacamole
//                    9. Mushroom
//                    10.Mayo
//                    11.Mustard
//                    """);
//
//            if (s.hasNextLine()) {
//                String[] toppingChoices = s.nextLine().split(",");
//
//                for (int i = 0; i < toppingChoices.length; i++) {
//
//                    int toppingChoice = Integer.parseInt(toppingChoices[i]);
//
//                    switch (toppingChoice) {
//                        case 1 -> {regToppings.add(RegularTop.LETTUCE);validInput = true;}
//
//                        case 2 -> {regToppings.add(RegularTop.PEPPERS);validInput = true;}
//
//                        case 3 -> {regToppings.add(RegularTop.ONIONS);validInput = true;}
//
//                        case 4 -> {regToppings.add(RegularTop.TOMATOES);validInput = true;}
//
//                        case 5 -> {regToppings.add(RegularTop.JALEPENOS);validInput = true;}
//
//                        case 6 -> {regToppings.add(RegularTop.CUCUMBERS);validInput = true;}
//
//                        case 7 -> {regToppings.add(RegularTop.PICKLES);validInput = true;}
//
//                        case 8 -> {regToppings.add(RegularTop.GUACAMOLE);validInput = true;}
//
//                        case 9 -> {regToppings.add(RegularTop.MUSHROOMS);validInput = true;}
//
//                        case 10 -> {regToppings.add(RegularTop.MAYO);validInput = true;}
//
//                        case 11 -> {regToppings.add(RegularTop.MUSTARD);validInput = true;}
//
//                        default -> System.out.println("Invalid choice, please choose a number between 1 and 4.");
//                    }
//                }
//            } else {
//                System.out.println("Invalid input, please enter a number.");
//                s.nextLine();  // Clear the invalid input
//            }
//            System.out.println("You selected" + selectedToppingType);
//            System.out.println(regToppings);
//        }
//    }
//
//    // Method to determine if sandwich is toasted or not.
//    public boolean isToasted() {
//        boolean validInput = false;
//        boolean toasted = false;
//        while (!validInput) {
//            System.out.println("""
//                    Would you Like your sandwich toasted?
//                    1. Yes
//                    2. No
//                    """);
//            if (s.hasNextInt()) ;
//            int isToastedChoice = s.nextInt();
//            s.nextLine();
//
//            // Switch statement based on user input toasted sandwich will be true or false.
//            switch (isToastedChoice) {
//                case 1 -> {System.out.println("You chose sandwich is toasted."); validInput = true; toasted = true;}
//
//                case 2 -> {System.out.println("You chose sandwich is not toasted. "); validInput = true; toasted = false;}
//
//                default ->
//                    System.out.println("Invalid input choose a number between 1 and 2 ");
//            }
//        }
//        return toasted;
//    }


    private DrinkSize drinkSize() {
        DrinkSize selectedDrinkSize = null;
        double drinkPrice = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("""
                    Please select your drink size
                    1. Small
                    2. Medium
                    3. Large
                    """);
            if (s.hasNextInt()) ;
            int drinkChoice = s.nextInt();
            s.nextLine();

            switch (drinkChoice) {
                case 1 -> {
                    drinkPrice = 2.00;
                    selectedDrinkSize = DrinkSize.SMALL;
                    validInput = true;
                }
                case 2 -> {
                    drinkPrice = 2.50;
                    selectedDrinkSize = DrinkSize.MEDIUM;
                    validInput = true;
                }
                case 3 -> {
                    drinkPrice = 3.00;
                    selectedDrinkSize = DrinkSize.MEDIUM;
                    validInput = true;
                }
                default -> System.out.println("Invalid input please chose a number between 1 and 3 ");
            }
        }

        return null;
    }

    public void getTotalPrice() {

    }
}