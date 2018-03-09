package com.bibinet.intelibuild.mvp.model;

import com.bibinet.intelibuild.project.application.Constants;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by bibinet on 2018-1-5.
 */

public class ResetPasswordActivityModel {
    public void resetPassword(String userId,String password, String newPasswrod, String enSurePassword, Callback callback){
        OkHttpClient okHttpClient=new OkHttpClient();
        RequestBody requestBody= new FormBody.Builder().add("account",password).add("password",newPasswrod).add("password",enSurePassword).build();
        Request request=new Request.Builder().post(requestBody).url(Constants.BaseUrl).addHeader("Content-Type","application/json").build();
        okHttpClient.newCall(request).enqueue(callback);
    }
}