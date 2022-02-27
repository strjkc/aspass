package com.company;

import com.ibm.as400.access.AS400;

public class AS400Utils {

    private static AS400Utils utils = new AS400Utils();
    public String responseMessage = "";

    public static AS400Utils getUtils() {
        return utils;
    }

    private AS400Utils(){}
    public String changeAsPass(String host, String uname, String loginPass, String newPass){
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
