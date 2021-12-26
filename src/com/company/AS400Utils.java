package com.company;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.CommandCall;

public class AS400Utils {

    public static void changeAsPass(String host, String uname, String loginPass, String newPass){
        try {
            AS400 newCon = new AS400(host, uname, loginPass);
            newCon.changePassword(loginPass, newPass);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
