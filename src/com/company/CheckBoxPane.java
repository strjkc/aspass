package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CheckBoxPane extends JComponent {
    JButton paneButtonMain;
    JLabel paneTitle;
    GridBagConstraints titleContraint;
    JPanel contentPannel;

    public JPanel getContentPannel() {
        return contentPannel;
    }

    GridBagConstraints buttonContraints;
    public CheckBoxPane(String paneTitle, String mainButtonTitle, JDialog dial){
        contentPannel = new JPanel();

        //top 20 je hak da bude u ravni sa prvim input poljem, popraviti.
        contentPannel.setBorder(new EmptyBorder(0,0,0,0));
        GridBagLayout gblContentPane = new GridBagLayout();
        gblContentPane.columnWidths = new int[]{100};
        gblContentPane.rowHeights = new int[]{30, 30, 30, 30, 30, 30, 30, 30, 30};
        gblContentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
        gblContentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPannel.setLayout(gblContentPane);

        this.paneTitle = new JLabel(paneTitle);
        titleContraint = new CustomGridbag(0,0, GridBagConstraints.FIRST_LINE_START)
                .getContraints();
        contentPannel.add(this.paneTitle, titleContraint);
        paneButtonMain = new JButton("Add new host");
        buttonContraints = new CustomGridbag(0, State.checks.size() + 1, GridBagConstraints.CENTER)
                .getContraints();
        contentPannel.add(paneButtonMain,buttonContraints);
        displayCheckboxItems();

        //submit action
        paneButtonMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dial.setVisible(true);
                displayCheckboxItems();
                // set the "Add new host" button position to be hosts count + 1
                buttonContraints.gridy = State.checks.size() + 1;
                contentPannel.add(paneButtonMain,buttonContraints);
                contentPannel.revalidate();
                contentPannel.repaint();

            }
        });
    }

    private void displayCheckboxItems(){
        for(int i = 0; i < State.checks.size(); i++){
            GridBagConstraints k = new GridBagConstraints();
            k.anchor = GridBagConstraints.WEST;
            k.gridx = 0;
            k.gridy = i + 1;
            contentPannel.add(State.checks.get(i), k);
        }
    }


    public JButton getPaneButtonMain() {
        return paneButtonMain;
    }

    public JLabel getPaneTitle() {
        return paneTitle;
    }

    public GridBagConstraints getTitleContraint() {
        return titleContraint;
    }

    public GridBagConstraints getButtonContraints() {
        return buttonContraints;
    }
}
