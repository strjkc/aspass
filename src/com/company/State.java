package com.company;

import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class State {
    private List<JCheckBox> checks = new ArrayList<JCheckBox>();
    private static State state = new State();

    public static State getState() {
        return state;
    }

    public List<JCheckBox> getChecks() {
        return checks;
    }


    public void setChecks(List<JCheckBox> checks) {
        this.checks = checks;
    }
//TODO write to state metod

    private State(){};

    public void loadState(){
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

    public void writeToFile(){
        try {
            File file = new File("hosts.txt");
            file.delete();
            if (file.exists()){
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter("hosts.txt", true);
            for(int i = 0; i < checks.size(); i++){
                fileWriter.append(checks.get(i).getText() + ",");
            }
            fileWriter.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
