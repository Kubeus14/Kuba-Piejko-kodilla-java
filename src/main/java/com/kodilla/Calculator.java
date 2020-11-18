package com.kodilla;

public class Calculator {
    public int addAtoB(int a,int b){
        return a+b;}
    public int substractAfromB(int a,int b){
        return a-b;}
}
class App{

    public static void main(String[] args){

        Calculator calculator = new Calculator();
        int result = calculator.substractAfromB(15,7);
        System.out.println(result);
    }
}
