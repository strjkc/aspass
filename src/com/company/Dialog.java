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
        dialogPanel.setBorder(new EmptyBorder(0,40,0,40));
        GridBagLayout gblContentPane = new GridBagLayout();
        dialogPanel.setLayout(gblContentPane);

        dialogHostPane = new DialogHostPane();
        dialogField = new InputField("Enter host name:", false);
        JButton addHost = new JButton("Add");

        CustomGridbag dialogHostPaneConstraint = new CustomGridbag(0,0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.VERTICAL );
        dialogHostPaneConstraint.insets = new Insets(0,0,0,0);
        CustomGridbag dialogFieldConstraints = new CustomGridbag(0,1, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.HORIZONTAL);
        CustomGridbag buttonConstraints = new CustomGridbag(0, 2, GridBagConstraints.CENTER);

        dialogPanel.add(dialogHostPane, dialogHostPaneConstraint);
        dialogPanel.add(addHost, buttonConstraints);
        dialogPanel.add(dialogField, dialogFieldConstraints);
        setContentPane(dialogPanel);

        addHost.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addElement();
                setVisible(false);
                dispose();
                dialogField.setTextField("");
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
