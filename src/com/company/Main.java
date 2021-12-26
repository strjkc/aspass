package com.company;

import com.ibm.as400.access.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Main {

    public static void main(String[] args){

        //Setup frame and parent layout
        JFrame frame = new JFrame();
        frame.setTitle("Password manager");
        frame.setBounds(0, 0, 600, 400);
        JPanel contentPannel = new JPanel();
        contentPannel.setBorder(new EmptyBorder(0,40,0,40));
        GridBagLayout gblContentPane = new GridBagLayout();
        gblContentPane.columnWidths = new int[]{300, 300};
        gblContentPane.rowHeights = new int[]{400};
        gblContentPane.columnWeights = new double[]{0.4, 1.0, Double.MIN_VALUE};
        gblContentPane.rowWeights = new double[]{0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0, Double.MIN_VALUE};
        contentPannel.setLayout(gblContentPane);

        //setup constraints for child elements in parent
        GridBagConstraints checkboxPaneConstraints = new CustomGridbag(0,0, GridBagConstraints.WEST)
                .getContraints();

        GridBagConstraints inputPaneConstraints = new CustomGridbag(1, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL)
                .getContraints();

        //Get panels from child objects
        JDialog hostModal = new Dialog(frame)
                .getModelDialog();
        JPanel checkBoxPanePanel = new CheckBoxPane("Available Hosts: ", "Add Host", hostModal)
                .getContentPannel();
        JPanel inputPanel = new InputPane()
                .getContentPannel();


        contentPannel.add(checkBoxPanePanel, checkboxPaneConstraints);
        contentPannel.add(inputPanel, inputPaneConstraints);
        frame.setContentPane(contentPannel);
        frame.setVisible(true);
    }
}
