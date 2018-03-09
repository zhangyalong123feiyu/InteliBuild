package com.bibinet.intelibuild.mvp.presenter;

import android.app.Activity;

import com.bibinet.intelibuild.mvp.model.SelectCheckProjectActivityModel;
import com.bibinet.intelibuild.mvp.view.SelectCheckProjectActivityView;

import java.io

        .IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by bibinet on 2018-1-29.
 */

public class SelectCheckProjectActivityPresenter extends BasePresenter {
    private SelectCheckProjectActivityModel selectCheckProjectActivityModel;
    private SelectCheckProjectActivityView selectCheckProjectActivityView;

    public SelectCheckProjectActivityPresenter(SelectCheckProjectActivityView selectCheckProjectActivityView) {
        this.selectCheckProjectActivityView = selectCheckProjectActivityView;
        this.selectCheckProjectActivityModel=new SelectCheckProjectActivityModel();
    }
//    public void postPrintSelectSucess(final Activity activity, String item){
//        selectCheckProjectActivityModel.printSelectCheckProject(item, new Callback() {
//            @Override
//            public void onFailure(Call call, final IOException e) {
//                activity.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        selectCheckProjectActivityView.onPrintSelectFailed(e.getMessage());
//                    }
//                });
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                activity.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        selectCheckProjectActivityView.onPrintSelectSucess();
//                    }
//                });
//            }
//        });
//    }
}
