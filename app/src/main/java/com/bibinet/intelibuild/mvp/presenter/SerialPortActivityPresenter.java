package com.bibinet.intelibuild.mvp.presenter;

import android.app.Activity;

import com.bibinet.intelibuild.mvp.model.SerialPortActivityModel;
import com.bibinet.intelibuild.mvp.view.SerialPortActivityView;

import java.io

        .IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by bibinet on 2018-1-13.
 */

public class SerialPortActivityPresenter extends BasePresenter {
    private SerialPortActivityModel serialPortActivityModel;
    private SerialPortActivityView serialPortActivityView;

    public SerialPortActivityPresenter(SerialPortActivityView serialPortActivityView) {
        this.serialPortActivityView = serialPortActivityView;
        this.serialPortActivityModel=new SerialPortActivityModel();
    }
    public void postSerialData(final Activity activity, String userId,String serialNumb, String productFileNumber, String productFileName, String productName,
                               String productNumber, String checkProductName, String doStandard, String serialCheckData,String isCorrect){
        serialPortActivityModel.postSerialPostInfo(userId,serialNumb, productFileNumber, productFileName, productName, productNumber, checkProductName, doStandard, serialCheckData,isCorrect,new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        serialPortActivityView.onPostSerialPortActivityFailed();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        serialPortActivityView.onPostSerialPortActivitySucess();
                    }
                });
            }
        });
    }
}
