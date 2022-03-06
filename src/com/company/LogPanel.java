package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.ArrayList;

public class LogPanel extends JScrollPane {

    private static JTextPane logArea;
    private static Log log = Log.getLog();
    private static ArrayList<String> logMessages;

    public LogPanel() {
        logArea = new JTextPane();
        logArea.setEditable(true);
        logArea.setSize(100, 50);
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        setViewportView(logArea);
        logMessages = log.getLogMessages();
    }

    public static void printLog(){
        logArea.setText("");
        for(int i = 0; i < logMessages.size(); i++){
            Color textColor;
            String messageText = logMessages.get(i);
            if(isErrorMessage(messageText)){
                textColor = Color.RED;
            }else{
                textColor = Color.GREEN;
            }
            appendToPane(logArea, logMessages.get(i) + "\n", textColor);
        }
        log.clearLogMessages();
    }

    private static boolean isErrorMessage(String message){
        String m = message.substring(0, 5);
        System.out.println(m);
        if(m.equals("ERROR")){
            return true;
        }
        return false;
    }
    private static void appendToPane(JTextPane tp, String msg, Color c)
    {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

        int len = tp.getDocument().getLength();
        tp.setCaretPosition(len);
        tp.setCharacterAttributes(aset, false);
        tp.replaceSelection(msg);
    }

}
