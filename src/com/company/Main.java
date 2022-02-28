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
        frame.setBounds(400, 200, 700, 400);
        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(20,40,20,40));
        GridBagLayout gblContentPane = new GridBagLayout();
        gblContentPane.columnWidths = new int[]{300, 300};
        gblContentPane.rowHeights = new int[]{400};
        gblContentPane.columnWeights = new double[]{0.4, 1.0, Double.MIN_VALUE};
        gblContentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        contentPanel.setLayout(gblContentPane);
        State state = State.getState();
        state.loadState();

        //setup constraints for child elements in parent
        CustomGridbag checkboxPaneConstraints = new CustomGridbag(0,0, GridBagConstraints.FIRST_LINE_START);
        CustomGridbag inputPaneConstraints = new CustomGridbag(1, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.HORIZONTAL);

        //Get panels from child objects
        HostPane checkBoxPanePanel = new HostPane("Available Hosts: ", "Edit Hosts");
        InputPane inputPanel = new InputPane();
        Dialog dialog = new Dialog(frame, checkBoxPanePanel);
        checkBoxPanePanel.setDial(dialog);

        contentPanel.add(checkBoxPanePanel, checkboxPaneConstraints);
        contentPanel.add(inputPanel, inputPaneConstraints);
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
