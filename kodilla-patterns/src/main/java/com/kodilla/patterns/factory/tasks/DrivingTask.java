package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Tasks {
    private final String taskName;
    private final String where;
    private final String using;
    private final boolean isDone;

    public DrivingTask(String taskName, String where, String using,boolean isDone) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
        this.isDone = isDone;
    }
    public void executeTask(){
        System.out.println(where);
    }
    public String getTaskName(){
        return taskName;
    }
    public boolean isTaskExecuted(){
        return isDone;
    }
}
