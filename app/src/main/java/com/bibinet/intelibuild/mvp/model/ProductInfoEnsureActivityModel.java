package com.bibinet.intelibuild.mvp.model;

import com.bibinet.intelibuild.project.application.Constants;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by bibinet on 2018-1-12.
 */

public class ProductInfoEnsureActivityModel {
    public void postProductInfoEnsure(String userId, String productFileNumber, String productFileName, String productName,
                                      String productNumber, String checkProductName, String doStandard, String checkMatchine, Callback callback) {
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder().add("account", productFileNumber).add("password", productFileName).add("password", productFileName).
                add("password", productName).add("password", productNumber).add("password", checkProductName).
                add("password", doStandard).add("password", checkMatchine).build();
        Request request = new Request.Builder().post(requestBody).url(Constants.BaseUrl).addHeader("Content-Type", "application/json").build();
        okHttpClient.newCall(request).enqueue(callback);
    }
}