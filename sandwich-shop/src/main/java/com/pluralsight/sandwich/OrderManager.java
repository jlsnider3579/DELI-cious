package com.pluralsight.sandwich;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderManager {
    public void saveOrder(Order order){
        String name = "Jontez";
        LocalDateTime timeStamp = LocalDateTime.now();
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.printf("name: %s, orderNumber: %d, timeStamp: %s ", name, order.getOrderNumber(), timeStamp.format(formatter));
    }
}
