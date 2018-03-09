package com.bibinet.intelibuild.project.ui.activity;

import android.view.View;

import com.bibinet.intelibuild.R;
import com.bibinet.intelibuild.mvp.presenter.LogoutActivityPresenter;
import com.bibinet.intelibuild.mvp.view.LogoutActivityView;
import com.bibinet.intelibuild.project.ui.baseui.BaseActivity;

/**
 * Created by bibinet on 2017-12-18.
 */

public class LoginOutActivity extends BaseActivity implements LogoutActivityView{
    @Override
    protected int getChildlayout() {
        return R.layout.activity_checkinfo;
    }

    @Override
    protected void initView() {
        title.setText("退出登录");
        titleBackImage.setVisibility(View.VISIBLE);
        LogoutActivityPresenter logoutActivityPresenter=new LogoutActivityPresenter(this);
    }

    @Override
    public void onLoginSucess() {

    }

    @Override
    public void onLoginFailed(String msg) {

    }
}
