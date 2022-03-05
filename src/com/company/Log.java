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

    public void setLogMessages(String newMessage) {
        this.logMessages.add(newMessage);
    }

}
