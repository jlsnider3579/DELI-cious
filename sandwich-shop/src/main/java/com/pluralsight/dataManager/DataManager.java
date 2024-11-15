package com.pluralsight.dataManager;

import com.pluralsight.orders.Order;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataManager {
    public  static void createReceipt(Order order){
        LocalDateTime timeStamp = LocalDateTime.now();
        DateTimeFormatter dTF = DateTimeFormatter.ofPattern("yyyyMMdd");

        try {
            FileWriter fw = new FileWriter("./src/main/resources/Receipts/" + timeStamp.format(dTF)+ ".txt");
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(order.toCsvString());
            bw.write(String.format("total price: $%-1.2f " , order.getTotalPrice()));
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //create file class variables for a receipt
    // arrayList of orders

    // method name receipt generator
    // receipt file path set to local time now in the format off yyyyMMdd HH: mm: ss:
    // try to write order number and customer name to the file and format like a receipt
    // for each product in order write item details

    //created order number
    //return a number 1 more than the size of the order list
}
