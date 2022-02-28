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
    private JLabel title;
    CustomGridbag titleGrid;
    public DialogHostPane(){

        setBorder(new EmptyBorder(0,0,0,0));

        GridBagLayout gblContentPane = new GridBagLayout();
        gblContentPane.columnWidths = new int[]{100, 100};
        gblContentPane.columnWeights = new double[]{0.5, 0.5, Double.MIN_VALUE};
        setLayout(gblContentPane);

        title = new JLabel("Available hosts:");
        titleGrid = new CustomGridbag(0, 0, GridBagConstraints.FIRST_LINE_START);
        initHosts();
    }

    public void initHosts(){
        removeAll();
        add(title, titleGrid);

        for(int i = getComponents().length/2; i < checkBoxList.size(); i++) {
            JLabel host = new JLabel(checkBoxList.get(i).getText());
            JButton button = new JButton("Delete");
            CustomGridbag buttonGrid = new CustomGridbag(0, i + 1, GridBagConstraints.WEST);
            CustomGridbag labelGrid = new CustomGridbag(1, i + 1, GridBagConstraints.WEST);
            add(button, labelGrid);
            add(host, buttonGrid);

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
