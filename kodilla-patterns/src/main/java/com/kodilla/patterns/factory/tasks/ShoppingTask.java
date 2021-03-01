package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task {
    private final String taskName;
    private final String whatToBuy;
    private final double quantity;
    private final boolean isDone;

    public ShoppingTask(String taskName, String whatToBuy, double quantity,boolean isDone) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
        this.isDone=isDone;
    }

    public void executeTask(){
        System.out.println(whatToBuy);
        System.out.println(quantity);
    }
    public String getTaskName(){
        return taskName;
    }
    public boolean isTaskExecuted(){
        return isDone;
    }
}
