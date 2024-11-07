package com.pluralsight.sandwich;
import com.pluralsight.orders.*;
import com.pluralsight.orders.Order;
import com.pluralsight.orders.OrderManager;

public class Program {
        public static void main(String[] args) {
        OrderManager manager = new OrderManager();
        Order order = new Order();
        manager.saveOrder(order);
        }
    }


