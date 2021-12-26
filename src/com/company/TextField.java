package com.company;

import javax.swing.*;
import java.awt.*;

public class TextField extends JComponent {
    private JLabel label;
    public JTextField inputField;
    private GridBagConstraints labelConstraints;
    private GridBagConstraints inputFieldContraints;

    public TextField(String label, int xPosition, int yPosition){
        this.label = new JLabel(label);
        labelConstraints = new GridBagConstraints();
        labelConstraints.anchor = GridBagConstraints.WEST;
        labelConstraints.insets = new Insets(0,0, 0,0);
        labelConstraints.gridx = xPosition;
        labelConstraints.gridy = yPosition;
        labelConstraints.fill = GridBagConstraints.HORIZONTAL;


        inputField = new JTextField();
        inputFieldContraints = new GridBagConstraints();
        inputFieldContraints.anchor = GridBagConstraints.WEST;
        inputFieldContraints.insets = new Insets(0,0, 0,0);
        inputFieldContraints.gridx = xPosition;
        inputFieldContraints.ipady = 5;
        inputFieldContraints.gridy = yPosition + 1;
        inputFieldContraints.fill = GridBagConstraints.HORIZONTAL;
    }

    public TextField(String label, int xPosition, int yPosition,
                     int insetTop, int insetLeft, int insetBottom, int insetRight){
        this.label = new JLabel(label);
        labelConstraints = new GridBagConstraints();
        labelConstraints.anchor = GridBagConstraints.WEST;
        labelConstraints.insets = new Insets(insetTop,insetLeft, insetBottom,insetRight);
        labelConstraints.gridx = xPosition;
        labelConstraints.gridy = yPosition;

        inputField = new JTextField();
        inputFieldContraints = new GridBagConstraints();
        inputFieldContraints.anchor = GridBagConstraints.WEST;
        inputFieldContraints.fill = GridBagConstraints.HORIZONTAL;
        inputFieldContraints.insets = new Insets(insetTop,insetLeft, insetBottom,insetRight);
        inputFieldContraints.gridx = xPosition;
        inputFieldContraints.ipady = 5;
        inputFieldContraints.gridy = yPosition + 1;
    }
    public JLabel getLabel() {
        return label;
    }

    public JTextField getInputField() {
        return inputField;
    }

    public GridBagConstraints getLabelConstraints() {
        return labelConstraints;
    }

    public GridBagConstraints getInputFieldContraints() {
        return inputFieldContraints;
    }
}
