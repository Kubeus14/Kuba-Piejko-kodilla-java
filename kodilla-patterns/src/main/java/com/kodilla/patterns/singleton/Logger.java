package com.kodilla.patterns.singleton;

public enum Logger {
    INSTANCE;
    private String lastLog = "";
    public String getLastLog() {
        return lastLog;
    }
    public void log(String log) {
        lastLog = log;
        System.out.println("Log: [" + log + "]");
    }


}
