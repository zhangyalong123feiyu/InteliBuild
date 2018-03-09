package com.bibinet.intelibuild.mvp.presenter;

import android.app.Activity;

import com.bibinet.intelibuild.mvp.model.FixOcrResultActivityModel;
import com.bibinet.intelibuild.mvp.view.FixOcrResultActivityView;

import java.io

        .IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by bibinet on 2018-1-10.
 */

public class FixOcrResultActivityPresenter extends BasePresenter {
    private FixOcrResultActivityModel fixOcrResultActivityModel;
    private FixOcrResultActivityView  fixOcrResultActivityView;

    public FixOcrResultActivityPresenter(FixOcrResultActivityView fixOcrResultActivityView) {
        this.fixOcrResultActivityView = fixOcrResultActivityView;
    }
    public void postFixResultData(final Activity activity,String userId, String fixData, String checkProjectData, String doStandard, String checkResult, String lastCheckResult, String fixReason){
        fixOcrResultActivityModel.postFixResultData(userId,fixData, checkProjectData, doStandard, checkResult, lastCheckResult, fixReason, new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        fixOcrResultActivityView.onPostFixResultFailed(e.getMessage());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        fixOcrResultActivityView.onPostFixResultSucess();
                    }
                });
            }
        });
    }
}
