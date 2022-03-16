package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class Dialog extends JDialog {
    private InputField dialogField;
    private DialogHostPane dialogHostPane;
    private HostPane checkboxPanePanel;
    private State state = State.getState();
    private List<JCheckBox> checkBoxList = state.getChecks();

    public Dialog(JFrame frame, HostPane mainHostsPane){
        super(frame, "Edit hosts",
                Dialog.ModalityType.DOCUMENT_MODAL);

        this.checkboxPanePanel = mainHostsPane;
        this.setBounds(132, 132, 300, 300);
        JPanel dialogPanel = new JPanel();
        dialogPanel.setBorder(new EmptyBorder(0,10,0,10));
        GridBagLayout gblContentPane = new GridBagLayout();
        dialogPanel.setLayout(gblContentPane);
        JPanel buttonPannel = new JPanel();

        dialogHostPane = new DialogHostPane();
        dialogField = new InputField("Enter host name:", false);
        JButton addHost = new JButton("Add");
        JButton saveHost = new JButton("Save");
        CustomGridbag dialogHostPaneConstraint = new CustomGridbag(0,0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.VERTICAL );
        dialogHostPaneConstraint.insets = new Insets(0,0,0,0);
        CustomGridbag dialogFieldConstraints = new CustomGridbag(0,1, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.HORIZONTAL);
        CustomGridbag addButtonConstraints = new CustomGridbag(0, 2, GridBagConstraints.EAST);
        CustomGridbag saveButtonConstraints = new CustomGridbag(1, 2, GridBagConstraints.WEST);
        CustomGridbag buttonPannelConstraints = new CustomGridbag(0, 2, GridBagConstraints.CENTER);

        dialogPanel.add(dialogHostPane, dialogHostPaneConstraint);
        buttonPannel.add(addHost, addButtonConstraints);
        buttonPannel.add(saveHost, saveButtonConstraints);
        dialogPanel.add(buttonPannel, buttonPannelConstraints);
        dialogPanel.add(dialogField, dialogFieldConstraints);
        setContentPane(dialogPanel);

        addHost.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addElement();
                dialogField.setTextField("");
                refreshDialogPane();
            }
        });

        saveHost.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowDeactivated(WindowEvent e) {
                mainHostsPane.displayCheckboxItems();
            }
        });
    }

    public void refreshDialogPane(){
        dialogHostPane.initHosts();
        revalidate();
        repaint();
    }

    public void addElement(){
        JCheckBox box = new JCheckBox(dialogField.getTextField().getText());
        checkBoxList.add(box);
    }
}
