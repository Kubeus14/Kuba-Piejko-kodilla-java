package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HomeWorkQueue implements Observable{
    private final String studentName;
    private final List<String> tasks;
    private final List<Observer> observers;

    public HomeWorkQueue(String studentName) {
        this.studentName = studentName;
        tasks = new ArrayList<>();
        observers = new LinkedList<>();
    }
    public void addTask(String task){
        tasks.add(task);
        notifyAboutTask();
    }
    @Override
    public void checkTask(Observer observer){
        observers.add(observer);
    }
    @Override
    public void notifyAboutTask(){
        for(Observer observer : observers){
            observer.update(this);
        }
    }
    @Override
    public void sendTask(Observer observer){
        observers.remove(observer);
    }

    public String getStudentName() {
        return studentName;
    }

    public List<String> getTasks() {
        return tasks;
    }
}
