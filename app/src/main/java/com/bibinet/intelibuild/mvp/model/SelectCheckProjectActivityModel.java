package com.bibinet.intelibuild.mvp.model;

import com.bibinet.intelibuild.project.application.Constants;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by bibinet on 2018-1-29.
 */

public class SelectCheckProjectActivityModel {
    public void printSelectCheckProject(String item1,String item1Number,String item2,String item2Number,String item3,String item3Number,String item4,
                                        String item4Number, String item5, String item5Number,String item6, String item6Number,String item7, String item7Number,
                                        String item8, String item8Number,String item9,String item9Number,Callback callback){
        OkHttpClient okHttpClient=new OkHttpClient();
//        RequestBody requestBody= new FormBody.Builder().add("account",item).build();
//        Request request=new Request.Builder().post(requestBody).url(Constants.BaseUrl).addHeader("Content-Type","application/json").build();
//        okHttpClient.newCall(request).enqueue(callback);
    }

}