package com.company;

import javax.swing.*;
import java.awt.*;

public class InputField extends JPanel {

    private JLabel label;
    private JTextField textField;
    private GridBagConstraints labelConstraints;
    private GridBagConstraints textFieldConstraints;

    public InputField(String lebelText, boolean isPassField){
        GridBagLayout gblContentPane = new GridBagLayout();
        gblContentPane.columnWidths = new int[]{100};
        //gblContentPane.rowHeights = new int[]{};
        gblContentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        //gblContentPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        setLayout(gblContentPane);

        label = new JLabel(lebelText);
        if(isPassField) {
            textField = new JPasswordField();

        }else{
            textField = new JTextField();
        }
        //customgrid
        labelConstraints = new CustomGridbag(0,0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.HORIZONTAL );
        textFieldConstraints = new CustomGridbag(0,1, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.HORIZONTAL);

        add(label, labelConstraints);
        add(textField, textFieldConstraints);
    }

/*
    public InputField(String label, int xPosition, int yPosition,
                      int insetTop, int insetLeft, int insetBottom, int insetRight){
        this.label = new JLabel(label);
        labelConstraints = new GridBagConstraints();
        labelConstraints.anchor = GridBagConstraints.WEST;
        labelConstraints.insets = new Insets(insetTop,insetLeft, insetBottom,insetRight);
        labelConstraints.gridx = xPosition;
        labelConstraints.gridy = yPosition;

        textField = new JTextField();
        inputFieldContraints = new GridBagConstraints();
        inputFieldContraints.anchor = GridBagConstraints.WEST;
        inputFieldContraints.fill = GridBagConstraints.HORIZONTAL;
        inputFieldContraints.insets = new Insets(insetTop,insetLeft, insetBottom,insetRight);
        inputFieldContraints.gridx = xPosition;
        inputFieldContraints.ipady = 5;
        inputFieldContraints.gridy = yPosition + 1;
    }

 */
    public JLabel getLabel() {
        return label;
    }

    public JTextField getTextField() {
        return textField;
    }

    public GridBagConstraints getLabelConstraints() {
        return labelConstraints;
    }

    public GridBagConstraints getInputFieldContraints() {
        return textFieldConstraints;
    }

    public void setTextField(String text) {
        this.textField.setText(text);
    }
}
