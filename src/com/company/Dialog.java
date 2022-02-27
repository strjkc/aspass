package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class Dialog extends JDialog {
    private TextField dialogField;
    private DialogHostPane dial;
    private CheckBoxPane checkboxPanePanel;
    private State state = State.getState();
    private List<JCheckBox> checkBoxList = state.getChecks();

    public Dialog(JFrame frame, CheckBoxPane checkboxPanePanel){
        super(frame, "Edit hosts",
                Dialog.ModalityType.DOCUMENT_MODAL);
        this.checkboxPanePanel = checkboxPanePanel;
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
        CustomGridbag buttonConstraints = new CustomGridbag(0, 3, GridBagConstraints.CENTER);

        dial = new DialogHostPane();
        CustomGridbag grid = new CustomGridbag(0,0, GridBagConstraints.WEST);
        panel1.add(dial.panel1, grid);

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
        addWindowListener(new WindowAdapter() {
            public void windowDeactivated(WindowEvent e) {
                checkboxPanePanel.displayCheckboxItems();

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
        checkBoxList.add(box);
        //State.writeToFile(box.getText());
    }
}
