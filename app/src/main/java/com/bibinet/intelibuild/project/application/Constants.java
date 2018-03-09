package com.bibinet.intelibuild.project.application;

/**
 * Created by bibinet on 2017-12-18.
 */

public class Constants {
    //用户登录以后的信息
    public static String LoginUerinfo=null;
    //    public static LoginResultBean loginResultInfo=null;
    public static String BaseUrl="http://192.168.1.76:8080/api/authenticate";



    /*--------------------以下是请求权限所用------------------------------*/
    public static final int CameralPermissson=0x0001;
    public static final int StoragePermisson=0x0002;
    /* ----------------------------------------------------------------------------------*/
    //串口检测项目的顺序
    public static int SerialCheckNumber=1;
    public static String firstSerialPortCheckNumber="";
    public static String secondSerialPortCheckNumber="";
    public static String thridSerialPortCheckNumber="";
    //串口的相关数据
    public static String  serialProductFileNumb="";
    public static String  serialProductFileName="";
    public static String  serialProductName="";
    public static String  serialProductNumber="";
    public static String  serialCheckProject="";
    public static String  serialDoStand="";

    //OCR检测项目顺序
    public static int OcrCheckNumber=1;
    public static String firstOcrCheckNumber="";
    public static String secondOcrCheckNumber="";
    public static String thridOcrCheckNumber="";
    //OCR相关数据
    public static String  ocrProductName="";
    public static String  ocrProductNumber="";
    public static String  ocrCheckProject="";
    public static String  ocrDoStand="";
    /*-------------------------------------------------------------------------*/
    public static boolean isCollect=false;//是否是采样
    public static boolean isProductInfoShow=false;//是否是单纯的信息展示
    public static boolean isSampleProductInfo=false;//是否是样品
}
