package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Task{
    private final String taskName;
    private final String color;
    private final String whatToPaint;
    private final boolean isDone;

    public PaintingTask(String taskName, String color, String whatToPaint,boolean isDone) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
        this.isDone=isDone;
    }
    public void executeTask(){
        System.out.println(whatToPaint);
        System.out.println(color);
    }
    public String getTaskName(){
        return taskName;
    }
    public boolean isTaskExecuted(){
        return isDone;
    }

}
