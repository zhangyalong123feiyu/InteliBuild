package com.bibinet.intelibuild.project.utils;


/**
 * Created by bibinet on 2018-1-17.
 */

public class CompareUtils{
    public static int getconVersionValue(String ocrData,String checkData){
        int values1=getValue(ocrData);
        int vluess2=getValue(checkData);
        return  values1/vluess2;
    }

    private static int getValue(String value){
        if (value.equals("Ω")) {
            return (int)Math.pow(10,0);
        }else if (value.equals("KΩ")) {
            return (int)Math.pow(10,3);
        }else {
            return (int)Math.pow(10,6);
        }
    }
}