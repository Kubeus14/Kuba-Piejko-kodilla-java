package com.kodilla.testing.user;

public class Calculator {

    public int add(int a,int b){
        return a+b;
    }
    public int substract(int a,int b){
        return a-b;
    }
}
class App{
    public static void main(String[] args){

        Calculator calculator = new Calculator();
        int result1 = calculator.add(7,5);
        int result2 = calculator.add(7,5);
    }
}
