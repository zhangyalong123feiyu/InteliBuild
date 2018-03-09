package com.bibinet.intelibuild.project.ui.baseui;

import android.Manifest;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bibinet.intelibuild.R;
import com.bibinet.intelibuild.project.application.Constants;
import com.bibinet.intelibuild.project.ui.activity.CheckInfoMationActivity;
import com.bibinet.intelibuild.project.ui.activity.CollectInfoMationActivity;
import com.bibinet.intelibuild.project.ui.activity.HistoryCheckInfoActivity;
import com.bibinet.intelibuild.project.ui.activity.LoginOutActivity;
import com.bibinet.intelibuild.project.ui.activity.OcrIdentifyActivity;
import com.bibinet.intelibuild.project.ui.activity.OpenMonitorActivity;
import com.bibinet.intelibuild.project.ui.activity.ProductInfoEnsureActivity;
import com.bibinet.intelibuild.project.ui.activity.RestPasswrodActivity;
import com.bibinet.intelibuild.project.ui.activity.RfidScanActivity;
import com.bibinet.intelibuild.project.ui.activity.SelectCheckProjectActivity;
import com.bibinet.intelibuild.project.utils.PublicPopWindowUtils;
import com.zyl_android.generalutils.DialogUtils;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements PublicPopWindowUtils.onPopDismissListener{
    @BindView(R.id.getProduct)
    RelativeLayout getProduct;
    @BindView(R.id.checkProduct)
    RelativeLayout checkProduct;
    @BindView(R.id.historyCheck)
    RelativeLayout historyCheck;
    @BindView(R.id.logout)
    RelativeLayout logout;
    private boolean isCanExit = false;
    private PublicPopWindowUtils popWindowUtils;

    @Override
    protected int getChildlayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        title.setText("智能监造");
        titleImageRight.setVisibility(View.VISIBLE);
        titleBackImage.setImageResource(R.mipmap.saoyisao_1);
        popWindowUtils=new PublicPopWindowUtils(this,this);
        mRequestPermission(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, Constants.StoragePermisson);
    }

    @OnClick({R.id.title_imageleft, R.id.title_imageright,R.id.getProduct, R.id.checkProduct, R.id.historyCheck, R.id.logout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_imageleft:
                Constants.isProductInfoShow=true;
                startActivity(new Intent(this, RfidScanActivity.class));
                break;
            case R.id.title_imageright:
                showPop();
                break;
            case R.id.getProduct:
                mRequestPermission(new String[]{Manifest.permission.CAMERA}, Constants.CameralPermissson);
                break;
            case R.id.checkProduct:
                Constants.isProductInfoShow=false;
                startActivity(new Intent(this, OpenMonitorActivity.class));
                break;
            case R.id.historyCheck:
                startActivity(new Intent(this, LoginOutActivity.class));
                break;
            case R.id.logout:
                toast("退出登录");
                break;
        }
    }
    private void showPop() {
        popWindowUtils.showPopWindow(R.layout.item_mainctivity_account);
        popWindowUtils.showPopWindow(titleImageRight);
        View view = popWindowUtils.getPopview();
        RelativeLayout userName = (RelativeLayout) view.findViewById(R.id.userName);
        RelativeLayout resetPassword = (RelativeLayout) view.findViewById(R.id.resetPassword);
        userName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toast("用户名点击");
                popWindowUtils.dissMisPopWindow();
            }
        });
        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popWindowUtils.dissMisPopWindow();
                startActivity(new Intent(MainActivity.this, RestPasswrodActivity.class));
            }
        });
    }

    @Override
    public void permissionSuccess(int requestCode) {
        super.permissionSuccess(requestCode);
        switch (requestCode) {
            case Constants.CameralPermissson:
                Constants.isCollect=true;
                startActivity(new Intent(this,OpenMonitorActivity.class));
                break;
            case Constants.StoragePermisson:
                break;
            default:
                break;
        }
    }

    @Override
    public void permissionFail(int requestCode) {
        super.permissionFail(requestCode);
        switch (requestCode) {
            case Constants.CameralPermissson:
                toast("请开启摄像头以后再进行，相关功能操作");
                break;
            case Constants.StoragePermisson:
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0) {
            if (isCanExit) {
                return super.onKeyDown(keyCode, event);
            }
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            isCanExit = true;
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    isCanExit = false;
                }
            }, 2000);
        }
        return true;
    }

    //popwindow 监听
    @Override
    public void onDismiss() {

    }
}
