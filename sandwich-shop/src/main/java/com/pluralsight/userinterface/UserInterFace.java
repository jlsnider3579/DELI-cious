package com.pluralsight.userinterface;

// Import necessary classes for data management and UI components
import com.pluralsight.dataManager.DataManager;
import com.pluralsight.userinterface.method.addDrink.DrinkView;
import com.pluralsight.orders.Order;
import com.pluralsight.userinterface.method.addSandwich.SandwichView;
import com.pluralsight.userinterface.method.chips.ChipView;
import java.util.Scanner;

public class UserInterFace {

    // Instances of views to add sandwich, drink, and chips to the order
    Scanner s = new Scanner(System.in);
    Order order;
    SandwichView sandwichView = new SandwichView();
    DrinkView drinkView = new DrinkView();
    ChipView chipView = new ChipView();

    // Method to display the home screen where users can start a new order or exit
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
                    order = new Order();
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

    // Method to display the order screen where users can add items to the order
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
                    sandwichView.addSandwichToOrder(order);
                    break;
                case "2":
                    drinkView.addDrinkToOrder(order);
                    break;
                case "3":
                    chipView.addChipToOrder(order);
                    break;
                case "4":
                    sandwichView.checkout(order);
                    DataManager.createReceipt(order);
                    System.out.println("Thank you for you purchase come back soon!!!");
                    break;
                case "0":
                    uInput = false;
                    break;
                default:
                    System.out.println("Sorry that was an Invalid response please try again ");

            }
        }
    }
}
