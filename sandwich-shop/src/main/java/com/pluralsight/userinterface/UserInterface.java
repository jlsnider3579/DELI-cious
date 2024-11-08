package com.pluralsight.userinterface;

import java.util.Scanner;

public class UserInterface {
    Scanner s = new Scanner(System.in);
    boolean uInput = true;


    public void homeScreen() {
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
                case"5":
                    System.out.println();
                    homeScreen();
                    break;
                case "0":
                    cancelOrder();
                    break;
                default:
                    uInput = false;
                    System.out.println("Sorry that was an invalid response");
                    break;

            }
        }
    }

    public void addSandwich(){

    }
    public void addDrink(){

    }
    public void addChips(){

    }
    public void checkout(){

    }
    public void cancelOrder(){

    }
}

