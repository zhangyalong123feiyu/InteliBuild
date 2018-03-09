package com.bibinet.intelibuild.mvp.model;

import com.bibinet.intelibuild.project.application.Constants;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.internal.connection.RouteException;

/**
 * Created by bibinet on 2018-1-13.
 */

public class SerialPortActivityModel {
    public void postSerialPostInfo(String userId,String serialNumb,String productFileNumber, String productFileName, String productName,
                                   String productNumber, String checkProductName, String doStandard,String serialCheckData,String isCorrect, Callback callback){
        OkHttpClient okHttpClient=new OkHttpClient();
        RequestBody requestBody= new FormBody.Builder().add("password",serialNumb).add("account",productFileNumber).add("password",productFileName).add("password",productFileName).
                add("password",productName).add("password",productNumber).add("password",checkProductName).
                add("password",doStandard).add("password",serialCheckData).add("iscorrect",isCorrect).build();
        Request request=new Request.Builder().post(requestBody).url(Constants.BaseUrl).addHeader("Content-Type","application/json").build();
        okHttpClient.newCall(request).enqueue(callback);
    }
}