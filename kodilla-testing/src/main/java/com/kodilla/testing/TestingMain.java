package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        System.out.println("Moduł 6. Wprowadzenie to testowania oprogramowania");

        Calculator calculator = new Calculator();
        int result = calculator.add(7, 5);
        if (result == 12) {
            System.out.println("add is ok");
        } else {
            System.out.println("add is wrong");
        }
        int result2 = calculator.substract(7, 5);
        if (result2 == 2) {
            System.out.println("substract is ok");
        } else {
            System.out.println("substract is wrong");
        }


    }
}
