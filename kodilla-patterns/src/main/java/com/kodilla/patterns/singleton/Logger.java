package com.kodilla.patterns.singleton;

public class Logger {

    private String lastLog = "";

    public String getLastLog() {
        return lastLog;
    }

    public void log(String log) {
        lastLog = log;
        System.out.println("Log: [" + log + "]");
    }

    private static Logger instance;

    public static Logger instanceReturn() {
        if (instance == null) {
            instance = new Logger();

        }
        return instance;
}

}
