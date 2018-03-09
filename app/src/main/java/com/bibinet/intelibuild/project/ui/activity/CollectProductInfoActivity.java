package com.bibinet.intelibuild.project.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bibinet.intelibuild.R;
import com.bibinet.intelibuild.mvp.presenter.CollectProductInfoPresenter;
import com.bibinet.intelibuild.mvp.view.CollectProudctInfoActivityView;
import com.bibinet.intelibuild.project.application.Constants;
import com.bibinet.intelibuild.project.ui.baseui.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by bibinet on 2018-1-3.
 */

public class CollectProductInfoActivity extends BaseActivity implements CollectProudctInfoActivityView{
    @BindView(R.id.proFileNumber)
    TextView proFileNumber;
    @BindView(R.id.productFile)
    TextView productFile;
    @BindView(R.id.productName)
    TextView productName;
    @BindView(R.id.doStandard)
    TextView doStandard;
    @BindView(R.id.sure)
    TextView sure;
    @BindView(R.id.repeatScan)
    TextView repeatScan;
    private CollectProductInfoPresenter collectProductInfoPresenter;

    @Override
    protected int getChildlayout() {
        return R.layout.activity_collectproductinfo;
    }

    @Override
    protected void initView() {
        title.setText("产品信息确认");
        collectProductInfoPresenter=new CollectProductInfoPresenter(this);
    }

    @OnClick({R.id.sure, R.id.repeatScan,R.id.title_imageleft})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_imageleft:
                finish();
                break;
            case R.id.sure:
                postCollectInfo();
                startActivity(new Intent(this,SelectCheckProjectActivity.class));
                break;
            case R.id.repeatScan:
                startActivity(new Intent(this,RfidScanActivity.class));
                break;
        }
    }

    private void postCollectInfo() {
        collectProductInfoPresenter.postCollecProductInfo(this,"userId",proFileNumber.getText().toString(),productFile.getText().toString(),productName.getText().toString(),
                doStandard.getText().toString());
    }

    @Override
    public void onPostCollectProductSucess() {

    }

    @Override
    public void onPostCollectProductFailed(String msg) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Constants.isCollect=false;
    }
}
