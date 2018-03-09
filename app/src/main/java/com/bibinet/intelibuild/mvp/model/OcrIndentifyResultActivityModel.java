package com.bibinet.intelibuild.mvp.model;

import com.bibinet.intelibuild.project.application.Constants;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by bibinet on 2018-1-13.
 */

public class OcrIndentifyResultActivityModel {
    public void postOcrResult(String userId,String productName, String productNumb, String checkProductName,
                              String doStandard, String checkData,Callback callback){
        OkHttpClient okHttpClient=new OkHttpClient();
        RequestBody requestBody= new FormBody.Builder().add("password",productName).add("password",productNumb).
                add("password",checkProductName).add("password",doStandard).add("password",checkData).build();
        Request request=new Request.Builder().post(requestBody).url(Constants.BaseUrl).addHeader("Content-Type","application/json").build();
        okHttpClient.newCall(request).enqueue(callback);

    }
}