package com.bibinet.intelibuild.mvp.model;

import com.bibinet.intelibuild.project.application.Constants;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by bibinet on 2018-1-10.
 */

public class FixOcrResultActivityModel {
    public void postFixResultData(String userId,String fixData, String checkProjectData, String doStandard, String checkResult, String LastCheckResult, String FixReason, Callback callback){
        OkHttpClient okHttpClient=new OkHttpClient();
        RequestBody requestBody= new FormBody.Builder().add("account",fixData).add("password",checkProjectData).add("password",doStandard).
                add("password",checkResult).add("password",LastCheckResult).add("password",FixReason).build();
        Request request=new Request.Builder().post(requestBody).url(Constants.BaseUrl).addHeader("Content-Type","application/json").build();
        okHttpClient.newCall(request).enqueue(callback);
    }
}