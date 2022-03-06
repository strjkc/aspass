package com.company;

import java.util.ArrayList;

public class Log {
    private static Log log = new Log();

    private ArrayList<String> logMessages = new ArrayList<>();
    private Log(){};

    public static Log getLog() {
        return log;
    }

    public ArrayList<String> getLogMessages() {
        return logMessages;
    }

    public void addLogMessage(String newMessage) {
        this.logMessages.add(newMessage);
    }

    public void clearLogMessages(){
        this.logMessages.clear();
    }

}
