package com.bibinet.intelibuild.project.ui.activity;

import android.view.View;

import com.bibinet.intelibuild.R;
import com.bibinet.intelibuild.project.ui.baseui.BaseActivity;

/**
 * Created by bibinet on 2017-12-18.
 */

public class CheckInfoMationActivity extends BaseActivity {
    @Override
    protected int getChildlayout() {
        return R.layout.activity_checkinfo;
    }

    @Override
    protected void initView() {
        title.setText("扫描监控二维码");
        titleBackImage.setVisibility(View.VISIBLE);
    }
}