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
        titleGrid.insets = new Insets(0, 0, 10, 0);
        initHosts();
    }

    public void initHosts(){
        removeAll();
        add(title, titleGrid);
        if (checkBoxList.size() == 0){
            JLabel host = new JLabel("No hosts available");
            host.setForeground(Color.gray);
            CustomGridbag labelGrid = new CustomGridbag(0, 1, GridBagConstraints.WEST);
            add(host, labelGrid);
        }else {
            for (int i = getComponents().length / 2; i < checkBoxList.size(); i++) {
                JLabel host = new JLabel(checkBoxList.get(i).getText());
                JButton button = new JButton("Delete");
                CustomGridbag labelGrid = new CustomGridbag(1, i + 1, GridBagConstraints.WEST);
                CustomGridbag buttonGrid = new CustomGridbag(0, i + 1, GridBagConstraints.WEST);
                add(host, buttonGrid);
                add(button, labelGrid);

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Removig host: " + host.getText());
                        remove(host);
                        remove(button);
                        checkBoxList.removeIf(item -> item.getText().equals(host.getText()));
                        initHosts();
                        revalidate();
                        repaint();
                    }
                });
            }
        }
    }
}
