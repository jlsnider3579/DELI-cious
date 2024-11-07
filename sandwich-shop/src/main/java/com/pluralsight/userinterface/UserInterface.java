package com.pluralsight.userinterface;

import java.util.Scanner;

public class UserInterface {
    Scanner s = new Scanner(System.in);
    boolean uInput = true;
    String choice = s.nextLine();

    public void userInterface() {
        while (uInput) {
            System.out.println("""
                    Welcome to DELI-cious Sandwich Shop
                    1) NEW ORDER
                    0) EXIT
                    """);

            switch (choice) {
                case "1":
                    System.out.println();
                    orderScreen();
                    break;
                case "0":
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
                    0) Cancel Order
                    """);

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
                case "0":
                    cancelOrder();
                    break;
                default:
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

