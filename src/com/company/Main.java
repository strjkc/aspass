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
        gblContentPane.columnWidths = new int[]{300, 300};
        gblContentPane.rowHeights = new int[]{400};
        gblContentPane.columnWeights = new double[]{0.4, 1.0, Double.MIN_VALUE};
        gblContentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        contentPanel.setLayout(gblContentPane);
State.loadState();
        //setup constraints for child elements in parent
        GridBagConstraints checkboxPaneConstraints = new CustomGridbag(0,0, GridBagConstraints.FIRST_LINE_START)
                .getContraints();

        GridBagConstraints inputPaneConstraints = new CustomGridbag(1, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.HORIZONTAL)
                .getContraints();

        //Get panels from child objects
        Dialog hostModal = new Dialog(frame);
        JPanel checkBoxPanePanel = new CheckBoxPane("Available Hosts: ", "Edit Hosts", hostModal)
                .getContentPannel();
        JPanel inputPanel = new InputPane()
                .getContentPannel();


        contentPanel.add(checkBoxPanePanel, checkboxPaneConstraints);
        contentPanel.add(inputPanel, inputPaneConstraints);
        frame.setContentPane(contentPanel);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                State.writeToFile();
                frame.dispose();
            }
        });

    }

}
