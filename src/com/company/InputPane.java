package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        //The first element has FIRST_LINE_START anchor only su it aligns with the cb pane while maintaining good spacing
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

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String uname = usernameTextField.getInputField().getText().trim();
                String pass = passwordTextField.getInputField().getText().trim();
                String newPass = newPasswordTextField.getInputField().getText().trim();
                String repeatedPass = repeatNewPasswordTextField.getInputField().getText().trim();

                if(uname.length() < 1 || pass.length() < 1 || newPass.length() < 1 || repeatedPass.length() < 1){
                    System.out.println("Passwords don't match");
                }else {
                    //get all checked boxes
                    for(int i = 0; i < State.checks.size(); i++){
                        if(State.checks.get(i).isSelected()){
                            //connect to AS for each host in state
                            AS400Utils.changeAsPass(State.checks.get(i).getText(), uname, pass, newPass);
                        }
                    }
                }
            }
        });
    }

}
