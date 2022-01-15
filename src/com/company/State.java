package com.company;

import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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

    public static void writeToFile(){
        try {
            File file = new File("hosts.txt");
            file.delete();
            FileWriter fileWriter = new FileWriter("hosts.txt", true);
            file.createNewFile();
            for(int i = 0; i < checks.size(); i++){
                fileWriter.append(checks.get(i).getText() + ",");
            }
            fileWriter.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
