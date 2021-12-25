package com.company;

import com.ibm.as400.access.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<JCheckBox> checks = new ArrayList<JCheckBox>();
    public static JPanel contentPannel;
    public static JFrame frame;

public static void addElement(){
    JCheckBox box = new JCheckBox("asdfasdfasdf");
    System.out.println("Drawing");
    GridBagConstraints k = new GridBagConstraints();
    k.anchor = GridBagConstraints.WEST;
    k.gridx = 0;
    k.gridy = checks.size() + 1;
    checks.add(box);
    contentPannel.add(checks.get(0), k);
}

    private static JDialog createDialog(final JFrame frame1) {
        final JDialog modelDialog = new JDialog(frame1, "Swing Tester",
                Dialog.ModalityType.DOCUMENT_MODAL);
        modelDialog.setBounds(132, 132, 300, 200);
        JPanel panel1 = new JPanel();
        panel1.setBorder(new EmptyBorder(0,40,0,40));
        Container dialogContainer = modelDialog.getContentPane();
        GridBagLayout gblContentPane = new GridBagLayout();
        gblContentPane.columnWidths = new int[]{100};
        gblContentPane.rowHeights = new int[]{30, 30, 30};
        gblContentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gblContentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel1.setLayout(gblContentPane);
        TextField t = new TextField("FFF", 0, 0);
        panel1.add(t.getLabel(), t.getLabelConstraints());
        panel1.add(t.getInputField(), t.getInputFieldContraints());

        JButton addHost = new JButton("Add");
        GridBagConstraints x = new GridBagConstraints();
        x.anchor = GridBagConstraints.CENTER;
        x.insets = new Insets(0,0, 0,0);
        x.gridx = 0;
        x.gridy = 2;
        panel1.add(addHost, x);

        addHost.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ubacuj u array hostnameove
                addElement();
                frame.revalidate();
            }
        });

        modelDialog.setContentPane(panel1);

        return modelDialog;
    }
    public static void main(String[] args) throws AS400SecurityException, IOException, InterruptedException, ErrorCompletingRequestException {
	// write your code here
        final String[] user = new String[1];
        final String[] passwordLogin = new String[1];
        String passToSet;
        String hosts[] = new String[1];
        final boolean[] isAddHostVisible = {false};
        List<JCheckBox> checkBoxList = new ArrayList<>();


        frame = new JFrame();
        frame.setTitle("Password manager");
        frame.setBounds(0, 0, 600, 400);
        contentPannel = new JPanel();
        contentPannel.setBorder(new EmptyBorder(0,40,0,40));
        GridBagLayout gblContentPane = new GridBagLayout();
        gblContentPane.columnWidths = new int[]{300, 300};
        gblContentPane.rowHeights = new int[]{400};
        gblContentPane.columnWeights = new double[]{0.4, 1.0, Double.MIN_VALUE};
        gblContentPane.rowWeights = new double[]{0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0, Double.MIN_VALUE};
        contentPannel.setLayout(gblContentPane);

        System.out.println(checks.size());

        CheckBoxPane paney = new CheckBoxPane("Available Hosts: ", "Add Host");
        GridBagConstraints x = new GridBagConstraints();
        x.anchor = GridBagConstraints.WEST;
        //x.fill = GridBagConstraints.HORIZONTAL;
        x.insets = new Insets(0,0, 0,0);
        x.gridx = 0;
        x.gridy = 0;

        JPanel inputPanel = new InputPane().contentPannel;
        GridBagConstraints y = new GridBagConstraints();
        y.anchor = GridBagConstraints.WEST;
        y.fill = GridBagConstraints.HORIZONTAL;
        y.insets = new Insets(0,0, 0,0);
        y.gridx = 1;
        y.gridy = 0;
        //inputPanel.setBackground(new Color(50,50,50));
        JPanel paneyPanel = paney.getContentPannel();
        //paneyPanel.setBackground(new Color(50,50,50));


        contentPannel.add(paneyPanel, x);
        contentPannel.add(inputPanel, y);
        frame.setContentPane(contentPannel);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);


       /* AS400ConnectionPool server = new AS400ConnectionPool();
        AS400 newCon = null;
        try {
            newCon = new AS400("PUB400.COM", "SJOKIC", "strahi9293");
        }catch (Exception e) {
            e.printStackTrace();
        }
        CommandCall cmd = new CommandCall(newCon, "dsplibl");
        cmd.run();
        //newCon.changePassword("Sljakomv1", "strahi9293");

        */

    }
}
