package com.bibinet.intelibuild.project.application;

import android.app.Application;
import android.content.Context;

import com.bibinet.intelibuild.project.utils.OcrIdentifyUtils;

/**
 * Created by bibinet on 2017-12-18.
 */

public class IntelBuildApplication extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
        OcrIdentifyUtils.initOcrToken();//初始化识别
    }
}
