package com.kodilla.good.patterns.food2Door;

public class Food2Door {
    public static void main(String[] args) {
        OrderStreamProcess orderStreamProcess = new OrderStreamProcess();
        orderStreamProcess.allOrders(new OrderProcess().retrieve());
    }
}
