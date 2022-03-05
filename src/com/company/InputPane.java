package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import com.company.AS400Utils;

public class InputPane extends JPanel {

   private State state = State.getState();
   private List<JCheckBox> checkBoxList = state.getChecks();
   private AS400Utils utils = AS400Utils.getUtils();


    public InputPane(){

        setBorder(new EmptyBorder(0,0,0,0));
        GridBagLayout gblContentPane = new GridBagLayout();
        gblContentPane.columnWidths = new int[]{100};
        gblContentPane.rowHeights = new int[]{50,50,50,50, 50, 50};
        gblContentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gblContentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        setLayout(gblContentPane);

        InputField usernameInputField = new InputField("Username", false);
        InputField currentPasswordField = new InputField("Current password", true);
        InputField newPasswordField = new InputField("New password", true);
        InputField newPasswordFieldRepeat = new InputField("Repeat new password", true);

        CustomGridbag usernameConstraints = new CustomGridbag(0,0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.HORIZONTAL);
        CustomGridbag currentPasswordConstraints = new CustomGridbag(0,1, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.HORIZONTAL);
        CustomGridbag newPasswordConstraints = new CustomGridbag(0,2, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.HORIZONTAL);
        CustomGridbag newPasswordRepeatConstraints = new CustomGridbag(0,3, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.HORIZONTAL);

        add(usernameInputField, usernameConstraints);
        add(currentPasswordField, currentPasswordConstraints);
        add(newPasswordField, newPasswordConstraints);
        add(newPasswordFieldRepeat, newPasswordRepeatConstraints);

        JButton btn = new JButton("Change Password");

        CustomGridbag buttonConstraints = new CustomGridbag(0, 4, GridBagConstraints.CENTER);
        CustomGridbag labelConstraints = new CustomGridbag(0, 5, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.HORIZONTAL);

        add(btn, buttonConstraints);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String uname = usernameInputField.getTextField().getText().trim();

                String pass = currentPasswordField.getTextField().getText().trim();
                String newPass = newPasswordField.getTextField().getText().trim();
                String repeatedPass = newPasswordFieldRepeat.getTextField().getText().trim();

                int isInputValid = checkInput(uname, pass, newPass, repeatedPass);
                if(isInputValid == -1){
                    System.out.println("Input fields can not be empty");
                }else if (isInputValid == -2){
                    System.out.println("Passwords don't match");
                }else {
                    //get all checked boxes
                    for(int i = 0; i < checkBoxList.size(); i++){
                        if(checkBoxList.get(i).isSelected()){
                            //connect to AS for each host in state
                            utils.changeAsPass(checkBoxList.get(i).getText(), uname, pass, newPass);
                        }
                    }
                    LogPanel.printLog();
                    revalidate();
                    repaint();
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
