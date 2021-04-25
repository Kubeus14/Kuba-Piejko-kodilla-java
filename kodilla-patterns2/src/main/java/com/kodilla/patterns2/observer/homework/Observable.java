package com.kodilla.patterns2.observer.homework;

public interface Observable {

    void checkTask(Observer observer);
    void notifyAboutTask();
    void sendTask(Observer observer);
}
