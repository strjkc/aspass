package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputPane extends JPanel {

   public String response;


    public InputPane(){

        setBorder(new EmptyBorder(0,0,0,0));
        GridBagLayout gblContentPane = new GridBagLayout();
        gblContentPane.columnWidths = new int[]{100};
        gblContentPane.rowHeights = new int[]{30,30,30,30,30,30,30,30,30};
        gblContentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gblContentPane.rowWeights = new double[]{0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0, Double.MIN_VALUE};
        setLayout(gblContentPane);
        response = "";


        //The first element has FIRST_LINE_START anchor only su it aligns with the cb pane while maintaining good spacing
        TextField usernameTextField = new TextField("Username:", 0, 0, GridBagConstraints.FIRST_LINE_START, false);
        add(usernameTextField.getLabel(), usernameTextField.getLabelConstraints());
        add(usernameTextField.getInputField(), usernameTextField.getInputFieldContraints());

        TextField passwordTextField = new TextField("Current Password:", 0, 2, GridBagConstraints.LINE_START, true);
        add(passwordTextField.getLabel(), passwordTextField.getLabelConstraints());
        add(passwordTextField.getInputField(), passwordTextField.getInputFieldContraints());

        TextField newPasswordTextField = new TextField("New Password:", 0, 4, GridBagConstraints.LINE_START, true);
        add(newPasswordTextField.getLabel(), newPasswordTextField.getLabelConstraints());
        add(newPasswordTextField.getInputField(), newPasswordTextField.getInputFieldContraints());

        TextField repeatNewPasswordTextField = new TextField("Repeat New Password:", 0, 6, GridBagConstraints.LINE_START, true);
        add(repeatNewPasswordTextField.getLabel(), repeatNewPasswordTextField.getLabelConstraints());
        add(repeatNewPasswordTextField.getInputField(), repeatNewPasswordTextField.getInputFieldContraints());

        JButton btn = new JButton("Change Password");
        JTextArea messageLabel = new JTextArea(response);

        CustomGridbag buttonConstraints = new CustomGridbag(0, 8, GridBagConstraints.CENTER);
        CustomGridbag labelConstraints = new CustomGridbag(0, 9, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.HORIZONTAL);

        add(btn, buttonConstraints);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String uname = usernameTextField.getInputField().getText().trim();
                String pass = passwordTextField.getInputField().getText().trim();
                String newPass = newPasswordTextField.getInputField().getText().trim();
                String repeatedPass = repeatNewPasswordTextField.getInputField().getText().trim();

                int isInputValid = checkInput(uname, pass, newPass, repeatedPass);
                if(isInputValid == -1){
                    System.out.println("Input fields can not be empty");
                }else if (isInputValid == -2){
                    System.out.println("Passwords don't match");
                }else {
                    //get all checked boxes
                    for(int i = 0; i < State.checks.size(); i++){
                        if(State.checks.get(i).isSelected()){
                            //connect to AS for each host in state
                            response = AS400Utils.changeAsPass(State.checks.get(i).getText(), uname, pass, newPass);
                            messageLabel.append(response);
                        }
                    }
                    add(messageLabel, labelConstraints);
                    revalidate();
                    repaint();
                    System.out.println(response);
                    response = "";
                }
            }
        });
    }

    private int checkInput(String uname, String pass, String newPass, String repeatedPass){
        if(uname.length() < 1 || pass.length() < 1 || newPass.length() < 1 || repeatedPass.length() < 1) {
            return -1;
        }else if(!newPass.equals(repeatedPass)){
            return -2;
        }
        return 1;
    }

}
