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
    Order order;
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
                    uInput = false;
                    break;
                default:
                    System.out.println("Sorry that was an Invalid response please try again ");

            }
        }
    }
}
