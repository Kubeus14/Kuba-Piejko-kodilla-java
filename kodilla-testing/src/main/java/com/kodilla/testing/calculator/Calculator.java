package com.kodilla.testing.calculator;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int substract(int a, int b) {
        return a - b;
    }
}

class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = calculator.add(7, 5);
        System.out.println(result);
    }
}


