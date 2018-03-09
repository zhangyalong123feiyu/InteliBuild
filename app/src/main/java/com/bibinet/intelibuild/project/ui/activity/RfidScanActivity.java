package com.bibinet.intelibuild.project.ui.activity;

import android.content.Intent;
import android.view.View;

import com.bibinet.intelibuild.R;
import com.bibinet.intelibuild.project.application.Constants;
import com.bibinet.intelibuild.project.ui.baseui.BaseActivity;

/**
 * Created by bibinet on 2018-1-8.
 */

public class RfidScanActivity extends BaseActivity{
    @Override
    protected int getChildlayout() {
        return R.layout.activity_rfidscan;
    }

    @Override
    protected void initView() {
        title.setText("RFID");
        setListioner();
    }
    //扫描数据成功时
    private void setListioner() {
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Constants.isProductInfoShow) {
                    if (Constants.isSampleProductInfo) {
                        startActivity( new Intent(RfidScanActivity.this,SampleProductInfoShowActivity.class));
                    }else {
                        startActivity( new Intent(RfidScanActivity.this,ProductInfoShowActivity.class));
                    }
                }else {
                    if (Constants.isCollect) {
                        startActivity( new Intent(RfidScanActivity.this,CollectProductInfoActivity.class));
                    }else {
                        startActivity( new Intent(RfidScanActivity.this,ProductInfoEnsureActivity.class));
                    }
                }

            }
        });
    }
    //扫描数据失败时,重新扫描

}
