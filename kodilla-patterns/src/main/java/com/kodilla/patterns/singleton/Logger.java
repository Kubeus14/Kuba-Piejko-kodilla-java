package com.kodilla.patterns.singleton;

public enum Logger {

    INSTANCE;
    private String lastLog = "";

    public String getLastLog() {
        return this.lastLog;
    }

    public void log(String log) {
        this.lastLog = log;
        System.out.println("Log: [" + log + "]");
    }



}
