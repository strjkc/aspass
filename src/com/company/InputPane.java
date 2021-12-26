package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class InputPane extends JComponent {
   private JPanel contentPannel;

    public JPanel getContentPannel() {
        return contentPannel;
    }

    public InputPane(){
        contentPannel = new JPanel();
        contentPannel.setBorder(new EmptyBorder(0,0,0,0));
        GridBagLayout gblContentPane = new GridBagLayout();
        gblContentPane.columnWidths = new int[]{100};
        gblContentPane.rowHeights = new int[]{30,30,30,30,30,30,30,30,30};
        gblContentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gblContentPane.rowWeights = new double[]{0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0, Double.MIN_VALUE};
        contentPannel.setLayout(gblContentPane);


        TextField usernameTextField = new TextField("Username:", 0, 0, GridBagConstraints.FIRST_LINE_START);
        contentPannel.add(usernameTextField.getLabel(), usernameTextField.getLabelConstraints());
        contentPannel.add(usernameTextField.getInputField(), usernameTextField.getInputFieldContraints());

        TextField passwordTextField = new TextField("Current Password:", 0, 2, GridBagConstraints.LINE_START);
        contentPannel.add(passwordTextField.getLabel(), passwordTextField.getLabelConstraints());
        contentPannel.add(passwordTextField.getInputField(), passwordTextField.getInputFieldContraints());

        TextField newPasswordTextField = new TextField("New Password:", 0, 4, GridBagConstraints.LINE_START);
        contentPannel.add(newPasswordTextField.getLabel(), newPasswordTextField.getLabelConstraints());
        contentPannel.add(newPasswordTextField.getInputField(), newPasswordTextField.getInputFieldContraints());

        TextField repeatNewPasswordTextField = new TextField("Repeat New Password:", 0, 6, GridBagConstraints.LINE_START);
        contentPannel.add(repeatNewPasswordTextField.getLabel(), repeatNewPasswordTextField.getLabelConstraints());
        contentPannel.add(repeatNewPasswordTextField.getInputField(), repeatNewPasswordTextField.getInputFieldContraints());

        JButton btn = new JButton("Change Password");
        GridBagConstraints y = new GridBagConstraints();
        y.anchor = GridBagConstraints.CENTER;
        y.insets = new Insets(0,0, 0,0);
        y.gridx = 0;
        y.gridy = 8;
        contentPannel.add(btn, y);
    }
}
