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
    private JButton removeHostButton;
    private final String paneTitle = "Available hosts:";
    private final String placeholderHostText = "No hosts available";
    CustomGridbag titleGrid;
    public DialogHostPane(){

        setBorder(new EmptyBorder(0,0,0,0));

        GridBagLayout gblContentPane = new GridBagLayout();
        gblContentPane.columnWidths = new int[]{100, 100};
        gblContentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
        setLayout(gblContentPane);

        title = new JLabel(paneTitle);
        titleGrid = new CustomGridbag(0, 0, GridBagConstraints.FIRST_LINE_START);
        titleGrid.insets = new Insets(0, 0, 10, 0);
        initHosts();
    }

    public void initHosts(){
        removeAll();
        add(title, titleGrid);
        if (checkBoxList.size() == 0){
            JLabel placeholderHost = new JLabel(placeholderHostText);
            placeholderHost.setForeground(Color.gray);
            CustomGridbag labelGrid = new CustomGridbag(0, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
            labelGrid.insets = new Insets(0, 0, 10, 0);
            add(placeholderHost, labelGrid);
        }else {
            for (int i = getComponents().length / 2; i < checkBoxList.size(); i++) {
                JLabel host = new JLabel(checkBoxList.get(i).getText());
                removeHostButton = new JButton("Delete");
                CustomGridbag labelGrid = new CustomGridbag(1, i + 1, GridBagConstraints.FIRST_LINE_START);
                CustomGridbag buttonGrid = new CustomGridbag(0, i + 1, GridBagConstraints.FIRST_LINE_START);
                add(host, buttonGrid);
                add(removeHostButton, labelGrid);
                removeHostButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Removig host: " + host.getText());
                        remove(host);
                        remove(removeHostButton);
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
