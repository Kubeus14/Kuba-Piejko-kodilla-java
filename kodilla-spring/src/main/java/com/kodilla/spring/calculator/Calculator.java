package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Calculator{
    @Autowired
    private Display display;

    public double add(double a,double b){
        double operation = a+b;
        display.displayValue(operation);
        return operation;
    }
    public double sub(double a,double b){
        double operation = a-b;
        display.displayValue(operation);
        return operation;
    }
    public double mul(double a,double b){
        double operation = a*b;
        display.displayValue(operation);
        return operation;
    }
    public double div(double a,double b){
        double operation = a/b;
        display.displayValue(operation);
        return operation;
    }
}
