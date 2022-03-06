package com.company;

import com.ibm.as400.access.AS400;

public class AS400Utils {

    private static AS400Utils utils = new AS400Utils();
    private Log log = Log.getLog();
    public static AS400Utils getUtils() {
        return utils;
    }

    private AS400Utils(){}
    public void changeAsPass(String host, String uname, String loginPass, String newPass){
        try {
            AS400 newCon = new AS400(host, uname, loginPass);
            newCon.changePassword(loginPass, newPass);
            log.addLogMessage(host + " password changed successfully");
        }catch (Exception e) {
            log.addLogMessage("ERROR: " + host + " " + e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
