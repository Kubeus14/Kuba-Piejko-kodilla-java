package com.kodilla.testing.training;

public class Square implements Shape{

    private final String name = "Square";
    private double edgeLength;

    public Square(double edgeLength) {
        this.edgeLength = edgeLength;
    }
    public String getName(){
        return name;
    }
    public double getField(){
        return edgeLength*edgeLength;
    }
}

