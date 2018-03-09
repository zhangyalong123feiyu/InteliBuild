package com.bibinet.intelibuild.project.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bibinet.intelibuild.R;
import com.bibinet.intelibuild.project.ui.baseui.BaseActivity;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by bibinet on 2017-12-27.
 */

public class ConnectDeviceActivity extends BaseActivity {
    @BindView(R.id.iv1)
    ImageView iv1;
    @BindView(R.id.iv2)
    ImageView iv2;
    @BindView(R.id.iv3)
    ImageView iv3;
    @BindView(R.id.sureDeviceConnect)
    TextView sureDeviceConnect;

    @Override
    protected int getChildlayout() {
        return R.layout.activity_connectdevice;
    }

    @Override
    protected void initView() {
        title.setText("链接设备");
        Glide.with(this).load(R.mipmap.connect).into(iv2);
//        toast("请确保设备已经连接");
    }

    @OnClick({R.id.sureDeviceConnect,R.id.title_imageleft})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sureDeviceConnect:
                startActivity(new Intent(this,SerialPortActivity.class));
                break;

            default:
                break;
        }
    }
}
