package com.company;

import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class State {
    public static List<JCheckBox> checks = new ArrayList<JCheckBox>();

    public static void loadState(){
        try {
            FileReader fileReader = new FileReader("hosts.txt");
            int a;
            String hostString = "";
            do{
                a = fileReader.read();
                System.out.println((char)a);
                if(a == 44) {
                    JCheckBox newBox = new JCheckBox(hostString);
                    checks.add(newBox);
                    hostString = "";
                }
                else{
                    hostString += (char) a;
                }
            } while(a != -1);
            fileReader.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
