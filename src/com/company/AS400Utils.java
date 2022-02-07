package com.company;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.CommandCall;

public class AS400Utils {
    public static String responseMessage = "";
    public static String changeAsPass(String host, String uname, String loginPass, String newPass){
        try {
            AS400 newCon = new AS400(host, uname, loginPass);
            newCon.changePassword(loginPass, newPass);
            responseMessage = host + "changed successfully \n";
        }catch (Exception e) {
            responseMessage = "ERROR on " + host + " " + e.getLocalizedMessage() + "\n";
            e.printStackTrace();
        }
        return responseMessage;
    }
}
