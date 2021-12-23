package com.company;

import com.ibm.as400.access.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws AS400SecurityException, IOException, InterruptedException, ErrorCompletingRequestException {
	// write your code here
        final String[] user = new String[1];
        final String[] passwordLogin = new String[1];
        String passToSet;
        String hosts[] = new String[1];
        final boolean[] isAddHostVisible = {false};


        JFrame frame = new JFrame();
        frame.setTitle("Password manager");
        frame.setBounds(100, 100, 600, 400);
        JPanel contentPannel = new JPanel();
        contentPannel.setBorder(new EmptyBorder(20,40,10,40));
        GridBagLayout gblContentPane = new GridBagLayout();
        gblContentPane.columnWidths = new int[]{100,50, 100};
        gblContentPane.rowHeights = new int[]{30, 30, 30, 30, 30, 30, 30, 30, 30, 30};
        gblContentPane.columnWeights = new double[]{0.4, 0.5, 1.0, Double.MIN_VALUE};
        gblContentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPannel.setLayout(gblContentPane);


        JLabel hostList = new JLabel("Available hosts:");
        GridBagConstraints i = new GridBagConstraints();
        i.anchor = GridBagConstraints.WEST;
        i.insets = new Insets(0,0, 0,0);
        i.gridx = 0;
        i.gridy = 0;
        contentPannel.add(hostList, i);
        // Array Hostova(labela i checkboxova
        //Ispod dugme za dodavanje hostova

        JButton addHost = new JButton("Add new host");
        GridBagConstraints x = new GridBagConstraints();
        x.fill = GridBagConstraints.HORIZONTAL;
        x.insets = new Insets(0,0, 0,0);
        x.gridx = 0;
        x.gridy = 2;
        contentPannel.add(addHost, x);

        //submit action
        addHost.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Adding host");
                    //ubacuj u array hostnameove

            }
        });

        JCheckBox b1 = new JCheckBox("PUB400.COM");
        b1.setHorizontalTextPosition(SwingConstants.LEFT);
        GridBagConstraints k = new GridBagConstraints();
        k.anchor = GridBagConstraints.WEST;
        k.gridx = 0;
        k.gridy = 1;
        contentPannel.add(b1, k);

        // col 2

        TextField usernameTextField = new TextField("Username:", 2, 0);
        contentPannel.add(usernameTextField.getLabel(), usernameTextField.getLabelConstraints());
        contentPannel.add(usernameTextField.getInputField(), usernameTextField.getInputFieldContraints());

        TextField passwordTextField = new TextField("Current Password:", 2, 2);
        contentPannel.add(passwordTextField.getLabel(), passwordTextField.getLabelConstraints());
        contentPannel.add(passwordTextField.getInputField(), passwordTextField.getInputFieldContraints());

        TextField newPasswordTextField = new TextField("New Password:", 2, 4);
        contentPannel.add(newPasswordTextField.getLabel(), newPasswordTextField.getLabelConstraints());
        contentPannel.add(newPasswordTextField.getInputField(), newPasswordTextField.getInputFieldContraints());

        TextField repeatNewPasswordTextField = new TextField("Repeat New Password:", 2, 6);
        contentPannel.add(repeatNewPasswordTextField.getLabel(), repeatNewPasswordTextField.getLabelConstraints());
        contentPannel.add(repeatNewPasswordTextField.getInputField(), repeatNewPasswordTextField.getInputFieldContraints());

        JCheckBox checkBoxes[] = new JCheckBox[]{b1};


        JButton btn = new JButton("Button 1");
        GridBagConstraints y = new GridBagConstraints();
        y.anchor = GridBagConstraints.CENTER;
        y.insets = new Insets(0,10, 0,0);
        y.gridx = 2;
        y.gridy = 8;
        contentPannel.add(btn, y);
        final AS400[] system = new AS400[1];
        //submit action
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < checkBoxes.length; i++) {
                    if (checkBoxes[i].isSelected()) {
                        System.out.println("Checked");
                        hosts[i] = "PUB400.COM";
                        //ubacuj u array hostnameove
                    } else {
                        System.out.println("Not checked");
                    }
                }
                //user[0] = uname.getText();
                //passwordLogin[0] = unameField.getText();
                for (int j = 0; j < hosts.length; j++) {
                    system[0] = new AS400(hosts[j], user[0], passwordLogin[0]);
                    try {
                        system[0].changePassword(passwordLogin[0], "Sljakomv2");

                    } catch (Exception ex) {
                        System.out.println("Exception " + ex);
                    }
                }
            }
        });



        JLabel addhostname = new JLabel("hostname:");
        GridBagConstraints n = new GridBagConstraints();
        n.anchor = GridBagConstraints.WEST;
        n.insets = new Insets(0,10, 0,0);
        n.gridx = 0;
        n.gridy = 4;
        addhostname.setVisible(isAddHostVisible[0]);
        contentPannel.add(addhostname, n);

        JTextField addhostnameField = new JTextField();
        GridBagConstraints b = new GridBagConstraints();
        b.anchor = GridBagConstraints.WEST;
        b.fill = GridBagConstraints.VERTICAL;
        b.insets = new Insets(0,0, 0,0);
        b.gridx = 0;
        b.gridy = 5;
        addhostnameField.setVisible(isAddHostVisible[0]);
        contentPannel.add(addhostnameField, b);
        addhostnameField.setColumns(20);


        JCheckBox box1 = new JCheckBox();
        frame.setContentPane(contentPannel);

        JTextField pass = new JTextField();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);


       /* AS400ConnectionPool server = new AS400ConnectionPool();
        AS400 newCon = null;
        try {
            newCon = new AS400("PUB400.COM", "SJOKIC", "strahi9293");
        }catch (Exception e) {
            e.printStackTrace();
        }
        CommandCall cmd = new CommandCall(newCon, "dsplibl");
        cmd.run();
        //newCon.changePassword("Sljakomv1", "strahi9293");

        */

    }
}
