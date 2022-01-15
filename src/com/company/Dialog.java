package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

public class Dialog extends JDialog {
    private JDialog modalDialog;
    private TextField dialogField;
    private DialogHostPane dial;

    public Dialog(JFrame frame){
        super(frame, "Edit hosts",
                Dialog.ModalityType.DOCUMENT_MODAL);
        this.setBounds(132, 132, 300, 300);
        JPanel panel1 = new JPanel();
        panel1.setBorder(new EmptyBorder(0,40,0,40));
        GridBagLayout gblContentPane = new GridBagLayout();
        gblContentPane.columnWidths = new int[]{100};
        gblContentPane.rowHeights = new int[]{30, 30, 30, 30};
        gblContentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
        gblContentPane.rowWeights = new double[]{0.0, 0.0, 0.0,0.0, Double.MIN_VALUE};
        panel1.setLayout(gblContentPane);

        dialogField = new TextField("Enter host name:", 0, 1, GridBagConstraints.LINE_START, false);
        JButton addHost = new JButton("Add");
        GridBagConstraints buttonConstraints = new CustomGridbag(0, 3, GridBagConstraints.CENTER).getContraints();

        dial = new DialogHostPane();
        CustomGridbag grid = new CustomGridbag(0,0, GridBagConstraints.WEST);
        panel1.add(dial.panel1, grid.getContraints());

        panel1.add(addHost, buttonConstraints);
        panel1.add(dialogField.getLabel(), dialogField.getLabelConstraints());
        panel1.add(dialogField.getInputField(), dialogField.getInputFieldContraints());
        setContentPane(panel1);

        addHost.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addElement();
                setVisible(false);
                dispose();
                dialogField.setInputField("");
            }
        });
    }

    public void refreshDialogPane(){
        dial.initHosts();
        revalidate();
        repaint();
    }

    public void addElement(){
        JCheckBox box = new JCheckBox(dialogField.getInputField().getText());
        State.checks.add(box);
        //State.writeToFile(box.getText());
    }

    public JDialog getModalDialog() {
        return modalDialog;
    }


}
