package com.bibinet.intelibuild.project.utils;

import com.bibinet.intelibuild.project.application.Constants;

/**
 * Created by bibinet on 2018-1-8.
 */

public class ClearDataUtils {
    public static void clearSerialData(){
        Constants.SerialCheckNumber=1;
        Constants.firstSerialPortCheckNumber="";
        Constants.secondSerialPortCheckNumber="";
        Constants.thridSerialPortCheckNumber="";
        Constants.serialProductFileName="";
        Constants.serialProductFileNumb="";
        Constants.serialProductName="";
        Constants.serialProductNumber="";
        Constants.serialCheckProject="";
        Constants.serialDoStand="";
    }
    public static void clearOcrData(){
        Constants.OcrCheckNumber=1;
        Constants.firstOcrCheckNumber="";
        Constants.secondOcrCheckNumber="";
        Constants.thridOcrCheckNumber="";
        Constants.ocrProductName="";
        Constants.ocrProductNumber="";
        Constants.ocrCheckProject="";
        Constants.ocrDoStand="";
    }
}
