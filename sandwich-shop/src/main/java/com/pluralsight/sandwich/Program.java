package com.pluralsight.sandwich;

public class Program {
        public static void main(String[] args) {
        OrderManager manager = new OrderManager();
        Order order = new Order();
        manager.saveOrder(order);
        }
    }


