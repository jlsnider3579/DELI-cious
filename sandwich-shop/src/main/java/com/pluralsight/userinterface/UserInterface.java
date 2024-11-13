package com.pluralsight.userinterface;

import com.pluralsight.sandwich.BreadType;

import java.util.Scanner;

public class UserInterface {
    Scanner s = new Scanner(System.in);



    public void homeScreen() {
        boolean uInput = true;
        while (uInput) {
            System.out.println("""
                    Welcome to DELI-cious Sandwich Shop
                    1) NEW ORDER
                    0) EXIT
                    """);
            String choice = s.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("New order");
                    orderScreen();
                    break;
                case "0":
                    uInput = false;
                    System.out.println("Exiting DELI-cious Sandwich Shop ");
                    break;
                default:
                    System.out.println("Sorry that was an invalid response");
                    break;
            }
        }
    }

    public void orderScreen() {
        boolean uInput = true;
        while (uInput) {
            System.out.println("""
                    1) Add Sandwich
                    2) Add Drink
                    3) Add Chips
                    4) Checkout
                    5) Return to home
                    0) Cancel Order
                    """);

            String choice = s.nextLine();

            switch (choice) {
                case "1":
                    addSandwich();
                    break;
                case "2":
                    addDrink();
                    break;
                case "3":
                    addChips();
                    break;
                case "4":
                    checkout();
                    break;
                case "5":
                    System.out.println();
                    uInput = false;
                    break;
                case "0":
                    cancelOrder();
                    break;
                default:

                    System.out.println("Sorry that was an invalid response");
                    break;

            }
        }
    }

    public void addSandwich() {
        boolean uInput = true;
        //System.out.println("Please select a bread type:");

        //for (BreadType bread: BreadType.values()){
        //  System.out.println(bread.getName());
        //System.out.println("""
              //  White
              //  Wheat
              //  Rye
               // Wrap


               // """);

        BreadType selectedBread = null;
        boolean exitCondition = true;
        do {
            System.out.println("Please select a bread type:");
            System.out.println("""
                White
                Wheat
                Rye
                Wrap
                
                
                """);
            String userInput = s.nextLine().toUpperCase();
            try {
                selectedBread = BreadType.valueOf(userInput);
                System.out.printf("You selected: %s%n", selectedBread.getName());
                exitCondition = false;
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid choice please chose again");
            }

        } while (exitCondition);

        ToppingType selectedTopping = null;
        boolean exitCondition2 = true;

        do {
            System.out.println("""
                Please select your toppings
                White
                Wheat
                Rye
                Wrap
                
                
                """);

        }


    }

    public void addDrink() {

    }

    public void addChips() {

    }

    public void checkout() {

    }

    public void cancelOrder() {

    }

}
