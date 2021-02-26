package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {
    public static final String ShoppingAsg = "ShoppingTask";
    public static final String PaintingAsg = "PaintingTask";
    public static final String DrivingAsg = "DrivingTask";
    public final Tasks processTask(final String nameTask){
        switch (nameTask){
            case ShoppingAsg:
                return (Tasks) new ShoppingTask("Shopping","Bread",5,true);
            case PaintingAsg:
                return (Tasks) new PaintingTask("Painting","Blue","Picture",false);
            case DrivingAsg:
                return (Tasks) new DrivingTask("Driving","SanFransisco","Car",true);
            default:
                return null;
        }
    }
}
