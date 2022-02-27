package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CheckBoxPane extends JPanel {

    private JButton paneButtonMain;
    private JLabel paneTitle;
    private CustomGridbag titleContraint;
    private Dialog dial;
    private CustomGridbag buttonContraints;

    public void setDial(Dialog dial) {
        this.dial = dial;
    }

    private List<JCheckBox> arrayState = State.getState().getChecks();

    public CheckBoxPane(String paneTitle, String mainButtonTitle){

        setBorder(new EmptyBorder(0,0,0,0));
        GridBagLayout gblContentPane = new GridBagLayout();
        gblContentPane.columnWidths = new int[]{100};
        gblContentPane.rowHeights = new int[]{30, 30, 30, 30, 30, 30, 30, 30, 30};
        gblContentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
        gblContentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gblContentPane);

        this.paneTitle = new JLabel(paneTitle);
        paneButtonMain = new JButton(mainButtonTitle);

        titleContraint = new CustomGridbag(0,0, GridBagConstraints.FIRST_LINE_START);
        buttonContraints = new CustomGridbag(0, arrayState.size() + 1, GridBagConstraints.CENTER);

        displayCheckboxItems();

        paneButtonMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dial.refreshDialogPane();
                dial.setVisible(true);
            }
        });
    }

    public void displayCheckboxItems(){
        removeAll();
        for(int i = 0; i < arrayState.size(); i++){
            GridBagConstraints k = new GridBagConstraints();
            k.anchor = GridBagConstraints.WEST;
            k.gridx = 0;
            k.gridy = i + 1;
            add(arrayState.get(i), k);
        }
        buttonContraints.gridy = State.getState().getChecks().size() + 1;
        add(paneTitle, titleContraint);
        add(paneButtonMain,buttonContraints);
        revalidate();
        repaint();
    }
}
