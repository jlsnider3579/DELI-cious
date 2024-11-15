package com.pluralsight.dataManager;

import com.pluralsight.orders.Order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataManager {

    //Creates a receipt for the given order and saves it to a file.
    public static void createReceipt(Order order) {
        LocalDateTime timeStamp = LocalDateTime.now();
        DateTimeFormatter dTF = DateTimeFormatter.ofPattern("yyyyMMdd");

        try {
            // Create a FileWriter for the receipt file, using the formatted date as part of the filename
            // Wrap the FileWriter in a BufferedWriter to improve writing efficiency
            FileWriter fw = new FileWriter("./src/main/resources/Receipts/" + timeStamp.format(dTF) + ".txt");
            BufferedWriter bw = new BufferedWriter(fw);

            // Write the order details to the receipt file
            bw.write(order.getStringForReceipt());

            // Write the total price of the order, formatted to 2 decimal places
            bw.write(String.format("total price: $%-1.2f ", order.getPrice()));
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
