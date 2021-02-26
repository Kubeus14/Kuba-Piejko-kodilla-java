package com.kodilla.patterns.strategy.social;

public class SnapchatPublisher implements SocialPublisher {
    @Override
    public String selectPortal(){
        return "Choose Snapchat";
    }
}
