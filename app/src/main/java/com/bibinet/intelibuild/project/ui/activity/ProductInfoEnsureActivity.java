package com.bibinet.intelibuild.project.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.baidu.ocr.ui.camera.CameraActivity;
import com.bibinet.intelibuild.R;
import com.bibinet.intelibuild.mvp.presenter.ProductInfoEnsureActivityPresenter;
import com.bibinet.intelibuild.mvp.view.ProductInfoEnsureActivityView;
import com.bibinet.intelibuild.project.application.Constants;
import com.bibinet.intelibuild.project.builder.OcrMessageEvent;
import com.bibinet.intelibuild.project.builder.SerialPortMessageEvent;
import com.bibinet.intelibuild.project.ui.baseui.BaseActivity;
import com.bibinet.intelibuild.project.utils.FileUtil;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by bibinet on 2017-12-22.
 */

public class ProductInfoEnsureActivity extends BaseActivity implements ProductInfoEnsureActivityView {
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
    @BindView(R.id.sure)
    Button sure;
    @BindView(R.id.repeatScan)
    Button repeatScan;
    public static boolean isFirstConnect;
    private ProductInfoEnsureActivityPresenter presenter;

    @Override
    protected int getChildlayout() {
        return R.layout.activity_productinfosure;
    }

    @Override
    protected void initView() {
        title.setText("样品信息确认");
        presenter=new ProductInfoEnsureActivityPresenter(this);
    }

    @OnClick({R.id.sure, R.id.repeatScan,R.id.title_imageleft})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_imageleft:
                finish();
                break;
            case R.id.sure:
//              doSerialPortCheck();
//                postData();
                doOcrCheck();
                break;
            case R.id.repeatScan:
                startActivity(new Intent(this,RfidScanActivity.class));
                break;
        }
    }

    private void postData() {
        presenter.postProductEnsureInfo(this,"userid",proFileNumber.getText().toString().trim(),productFile.getText().toString().trim(),productName.getText().toString().trim()
                ,productNumb.getText().toString().trim(),checkProjcet.getText().toString().trim(),doStandard.getText().toString().trim(),checkMachine.getText().toString());
    }

    private void doOcrCheck() {
        Intent intent = new Intent(this, CameraActivity.class);
        intent.putExtra("isNative",true);
        intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH, FileUtil.getSaveFile(getApplication()).getAbsolutePath());
        intent.putExtra(CameraActivity.KEY_CONTENT_TYPE, CameraActivity.CONTENT_TYPE_GENERAL);
        startActivity(intent);
        Constants.ocrProductName=productName.getText().toString().trim();
        Constants.ocrProductNumber=productNumb.getText().toString().trim();
        Constants.ocrCheckProject=checkProjcet.getText().toString().trim();
        Constants.ocrDoStand=doStandard.getText().toString().trim();
    }

    private void doSerialPortCheck() {
        if (!isFirstConnect) {
            startActivity(new Intent(this,ConnectDeviceActivity.class));
            isFirstConnect=true;

        }else {
            startActivity(new Intent(this,SerialPortActivity.class));
        }
        Constants.serialProductFileNumb=proFileNumber.getText().toString().trim();
        Constants.serialProductFileName=productFile.getText().toString().trim();
        Constants.serialProductName=productName.getText().toString().trim();
        Constants.serialProductNumber=productNumb.getText().toString().trim();
        Constants.serialCheckProject=checkProjcet.getText().toString().trim();
        Constants.serialDoStand=doStandard.getText().toString().trim();
    }

    @Override
    public void onPostProductInfoEnsureSucess() {

    }

    @Override
    public void onPostProductInfoEnsureFailed() {

    }
}
