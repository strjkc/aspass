package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DialogHostPane extends JPanel {

    private State state = State.getState();
    private List<JCheckBox> checkBoxList = state.getChecks();

    public DialogHostPane(){

        setBorder(new EmptyBorder(0,40,0,40));
        GridBagLayout gblContentPane = new GridBagLayout();
        gblContentPane.columnWidths = new int[]{100, 100};
        gblContentPane.rowHeights = new int[]{};
        gblContentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
        gblContentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        setLayout(gblContentPane);
        JLabel title = new JLabel("Available hosts:");
        CustomGridbag titleGrid = new CustomGridbag(0, 0, GridBagConstraints.FIRST_LINE_START);
        add(title, titleGrid);
    }

    public void initHosts(){
        removeAll();
        JLabel title = new JLabel("Available hosts:");
        CustomGridbag titleGrid = new CustomGridbag(0, 0, GridBagConstraints.FIRST_LINE_START);
        add(title, titleGrid);
        for(int i = getComponents().length/2; i < checkBoxList.size(); i++) {
                JButton button = new JButton("Delete");
                CustomGridbag buttonGrid = new CustomGridbag(0, i + 1, GridBagConstraints.WEST);
                JLabel host = new JLabel(checkBoxList.get(i).getText());
                CustomGridbag labelGrid = new CustomGridbag(1, i + 1, GridBagConstraints.WEST);
                add(host, buttonGrid);
                add(button, labelGrid);

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Removig host: " + host.getText());
                        remove(host);
                        remove(button);
                        checkBoxList.removeIf(item -> item.getText().equals(host.getText()));
                        revalidate();
                        repaint();
                    }
                });
        }
    }
}
