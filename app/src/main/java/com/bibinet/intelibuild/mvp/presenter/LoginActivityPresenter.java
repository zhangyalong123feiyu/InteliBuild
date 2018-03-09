package com.bibinet.intelibuild.mvp.presenter;

import android.app.Activity;
import android.util.Log;

import com.bibinet.intelibuild.mvp.model.LoginActivityModel;
import com.bibinet.intelibuild.mvp.view.LoginActivityView;
import com.google.gson.Gson;

import java.io

        .IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by bibinet on 2017-12-18.
 */

public class LoginActivityPresenter extends BasePresenter {
    private LoginActivityModel loginActivityModel;
    private LoginActivityView loginActivityView;

    public LoginActivityPresenter(LoginActivityView loginActivityView) {
        this.loginActivityView = loginActivityView;
        this.loginActivityModel=new LoginActivityModel();
    }

    public void doLogin(final Activity activity, String account, String password){
        loginActivityModel.doLogin(account,password, new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                Log.i("TAG","shibai");
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        loginActivityView.onLoginFailed(e.getMessage());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        loginActivityView.onLoginSucess();
                    }
                });
                Log.i("TAG","成功");
            }
        });
    }
}