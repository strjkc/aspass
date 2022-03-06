package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {


    public static void main(String[] args){

        //Setup frame and parent layout
        JFrame frame = new JFrame("Password manager");
        frame.setBounds(400, 200, 600, 400);
        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(20,40,20,40));
        GridBagLayout gblContentPane = new GridBagLayout();
       // gblContentPane.columnWidths = new int[]{300, 300};
        gblContentPane.rowHeights = new int[]{300,50};
        gblContentPane.columnWeights = new double[]{0.7, 0.3, Double.MIN_VALUE};
        gblContentPane.rowWeights = new double[]{0.9, 0.1, Double.MIN_VALUE};
        contentPanel.setLayout(gblContentPane);
        State state = State.getState();
        state.loadState();

        //setup constraints for child elements in parent
        CustomGridbag checkboxPaneConstraints = new CustomGridbag(0,0, GridBagConstraints.WEST);
        CustomGridbag inputPaneConstraints = new CustomGridbag(1, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.HORIZONTAL);
        CustomGridbag logPanelConstraints = new CustomGridbag(0,1, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH);

        //Get panels from child objects
        HostPane checkBoxPanePanel = new HostPane("Available Hosts: ", "Edit Hosts");
        InputPane inputPanel = new InputPane();
        Dialog dialog = new Dialog(frame, checkBoxPanePanel);
        checkBoxPanePanel.setDial(dialog);
        LogPanel logPanel = new LogPanel();
        //JTextArea logPanel = new JTextArea(10,1000);
        //JScrollPane pane = new JScrollPane(logPanel);

        contentPanel.add(checkBoxPanePanel, checkboxPaneConstraints);
        contentPanel.add(inputPanel, inputPaneConstraints);
        contentPanel.add(logPanel, logPanelConstraints);
        frame.setContentPane(contentPanel);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                state.writeToFile();
                frame.dispose();
            }
        });

    }

}
