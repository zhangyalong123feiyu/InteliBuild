package com.bibinet.intelibuild.mvp.presenter;

import android.app.Activity;

import com.bibinet.intelibuild.mvp.model.OcrIndentifyResultActivityModel;
import com.bibinet.intelibuild.mvp.view.OcrIndentifyResultActivityView;

import java.io

        .IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by bibinet on 2018-1-13.
 */

public class OcrIndentifyResultActivityPresenter extends BasePresenter {
    private OcrIndentifyResultActivityModel ocrIndentifyResultActivityModel;
    private OcrIndentifyResultActivityView ocrIndentifyResultActivityView;

    public OcrIndentifyResultActivityPresenter(OcrIndentifyResultActivityView ocrIndentifyResultActivityView) {
        this.ocrIndentifyResultActivityView = ocrIndentifyResultActivityView;
        this.ocrIndentifyResultActivityModel=new OcrIndentifyResultActivityModel();
    }
    public void postOcrResult(final Activity activity,String userId,String productName, String productNumb, String checkProductName,
                              String doStandard, String checkData){
        ocrIndentifyResultActivityModel.postOcrResult(userId,productName,productNumb,checkProductName,doStandard,checkData, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ocrIndentifyResultActivityView.onPostOcrIndentifyResultFailed();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ocrIndentifyResultActivityView.onPostOcrIndentifyResultSuceess();
                    }
                });
            }
        });
    }
}
