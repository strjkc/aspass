package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LogPanel extends JPanel {

    private static JTextArea logArea;
    private Log log = Log.getLog();
    private static ArrayList<String> logMessages;
    private CustomGridbag logPanelConstraints;

    public LogPanel() {
        logArea = new JTextArea();
        logMessages = log.getLogMessages();
        logPanelConstraints = new CustomGridbag(0, 1, GridBagConstraints.FIRST_LINE_START);
        add(logArea, logPanelConstraints);
    }

    public static void printLog(){
        for(int i = 0; i < logMessages.size(); i++){
            logArea.append(logMessages.get(i) + "\n");
        }
    }

}
