package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Dialog extends JDialog {
   public JDialog modelDialog;
    JButton addHost;
    public Dialog(JFrame frame){
        modelDialog = new JDialog(frame, "Swing Tester",
                Dialog.ModalityType.DOCUMENT_MODAL);
        modelDialog.setBounds(132, 132, 300, 200);
        JPanel panel1 = new JPanel();
        panel1.setBorder(new EmptyBorder(0,40,0,40));
        Container dialogContainer = modelDialog.getContentPane();
        GridBagLayout gblContentPane = new GridBagLayout();
        gblContentPane.columnWidths = new int[]{100};
        gblContentPane.rowHeights = new int[]{30, 30, 30};
        gblContentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gblContentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel1.setLayout(gblContentPane);
        TextField t = new TextField("FFF", 0, 0);
        panel1.add(t.getLabel(), t.getLabelConstraints());
        panel1.add(t.getInputField(), t.getInputFieldContraints());

        addHost = new JButton("Add");
        GridBagConstraints x = new GridBagConstraints();
        x.anchor = GridBagConstraints.CENTER;
        x.insets = new Insets(0,0, 0,0);
        x.gridx = 0;
        x.gridy = 2;
        panel1.add(addHost, x);


        modelDialog.setContentPane(panel1);

        addHost.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("XXXXX");
                addElement();
                modelDialog.setVisible(false);
                modelDialog.dispose();
            }
        });

    }

    public void addElement(){
        JCheckBox box = new JCheckBox("asdfasdfasdf");
        System.out.println("Drawing");

        State.checks.add(box);
    }


}
