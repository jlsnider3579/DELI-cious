package com.pluralsight.userinterface.method.chips;

import java.util.Scanner;
import com.pluralsight.chips.Chips;
import com.pluralsight.chips.ChipsType;
import com.pluralsight.orders.Order;

public class ChipView {
    Scanner s = new Scanner(System.in);

    public void addChip(Order order) {
        boolean validInput = false; // Set to false initially to enter the loop
        Chips selectedChip = null;  // This will hold the selected Chips object

        while (!validInput) {
            System.out.println("""
                    Select your desired chips:
                    1. Lays
                    2. BBQ
                    3. Salt_N_Vinegar
                    4. Doritos
                    """);

            if (s.hasNextInt()) {
                int choice = s.nextInt();
                s.nextLine();  // Consume the newline character

                switch (choice) {
                    case 1:
                        selectedChip = new Chips(ChipsType.LAYS); // Create Chips object with LAYS type
                        validInput = true; // Set valid input to true to exit loop
                        break;
                    case 2:
                        selectedChip = new Chips(ChipsType.BBQ); // Create Chips object with BBQ type
                        validInput = true;
                        break;
                    case 3:
                        selectedChip = new Chips(ChipsType.SALT_N_VINEGAR); // Create Chips object with Salt_N_Vinegar type
                        validInput = true;
                        break;
                    case 4:
                        selectedChip = new Chips(ChipsType.DORITOS); // Create Chips object with DORITOS type
                        validInput = true;
                        break;
                    default:
                        System.out.println("Invalid choice, please choose a number between 1 and 4.");
                }

            } else {
                System.out.println("Invalid input, please enter a number.");
                s.nextLine();  // Clear the invalid input
            }
        }

        // After valid input, you can now use the `selectedChip` object
        if (selectedChip != null) {
            System.out.println("You selected: " + selectedChip.getStringForReceipt());
        }
    }
}


