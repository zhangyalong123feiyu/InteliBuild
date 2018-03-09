package com.bibinet.intelibuild.mvp.presenter;

import android.app.Activity;

import com.bibinet.intelibuild.mvp.model.LogoutActivityModel;
import com.bibinet.intelibuild.mvp.view.LogoutActivityView;

/**
 * Created by bibinet on 2018-1-5.
 */

public class LogoutActivityPresenter {
    private LogoutActivityView logoutActivityView;
    private LogoutActivityModel logoutActivityModel;

    public LogoutActivityPresenter(LogoutActivityView logoutActivityView) {
        this.logoutActivityView = logoutActivityView;
        this.logoutActivityModel=new LogoutActivityModel();
    }
//    public void doLoginOut(Activity activity,){
//        logoutActivityModel.doLogin();
//    }
}