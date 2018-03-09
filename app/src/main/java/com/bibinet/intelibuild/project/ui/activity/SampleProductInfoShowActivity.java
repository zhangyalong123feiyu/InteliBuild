package com.bibinet.intelibuild.project.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bibinet.intelibuild.R;
import com.bibinet.intelibuild.project.application.Constants;
import com.bibinet.intelibuild.project.ui.baseui.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bibinet on 2018-1-12.
 */

public class SampleProductInfoShowActivity extends BaseActivity {
    @BindView(R.id.proFileNumber)
    TextView proFileNumber;
    @BindView(R.id.productFile)
    TextView productFile;
    @BindView(R.id.productName)
    TextView productName;
    @BindView(R.id.productNumb)
    TextView productNumb;
    @BindView(R.id.checkProjcet)
    TextView checkProjcet;
    @BindView(R.id.doStandard)
    TextView doStandard;
    @BindView(R.id.checkMachine)
    TextView checkMachine;

    @Override
    protected int getChildlayout() {
        return R.layout.activity_sampleproductinfoshow;
    }

    @Override
    protected void initView() {
        title.setText("样品信息展示");
        //将扫描结果赋值到界面上
        titleBackImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Constants.isProductInfoShow=false;
    }
}
