package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DialogHostPane {
    public JPanel panel1;
    public DialogHostPane(){
        panel1 = new JPanel();
        panel1.setBorder(new EmptyBorder(0,40,0,40));
        GridBagLayout gblContentPane = new GridBagLayout();
        gblContentPane.columnWidths = new int[]{100, 100};
        gblContentPane.rowHeights = new int[]{30};
        gblContentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
        gblContentPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        panel1.setLayout(gblContentPane);
        JLabel title = new JLabel("Available hosts:");
        CustomGridbag titleGrid = new CustomGridbag(0, 0, GridBagConstraints.FIRST_LINE_START);
        panel1.add(title, titleGrid.getContraints());
        initHosts();
    }

    public void initHosts(){
        for(int i = 0; i < State.checks.size(); i++) {
            JButton button = new JButton("Delete");
            CustomGridbag buttonGrid = new CustomGridbag(0, i + 1, GridBagConstraints.WEST);
            JLabel host = new JLabel(State.checks.get(i).getText());
            CustomGridbag labelGrid = new CustomGridbag(1, i + 1, GridBagConstraints.WEST);
            panel1.add(host, buttonGrid.getContraints());
            panel1.add(button, labelGrid.getContraints());
        }
    }
}
