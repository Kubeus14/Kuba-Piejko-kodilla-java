package com.kodilla.patterns.strategy.social;

public class User {
    private final String userName;
    protected SocialPublisher userChoice;

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
    public String choose(){
        return userChoice.selectPortal();
    }
    public void userStrategy(SocialPublisher userChoice){
        this.userChoice=userChoice;
    }
}
