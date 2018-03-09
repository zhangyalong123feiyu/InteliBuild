package com.bibinet.intelibuild.project.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bibinet.intelibuild.R;
import com.bibinet.intelibuild.mvp.presenter.LoginActivityPresenter;
import com.bibinet.intelibuild.mvp.view.LoginActivityView;
import com.bibinet.intelibuild.project.ui.baseui.BaseActivity;
import com.bibinet.intelibuild.project.ui.baseui.MainActivity;
import com.zyl_android.generalutils.PhoneNumberUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by bibinet on 2017-12-18.
 */

public class LoginActivity extends BaseActivity implements LoginActivityView{
    @BindView(R.id.inputPhoneNumber)
    EditText inputPhoneNumber;
    @BindView(R.id.inputPassword)
    EditText inputPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    private LoginActivityPresenter loginActivityPresenter;

    @Override
    protected int getChildlayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        titleLayout.setVisibility(View.GONE);
        loginActivityPresenter=new LoginActivityPresenter(this);
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        String phoneNumb = inputPhoneNumber.getText().toString().trim();
        String password=inputPassword.getText().toString().trim();
        if (!PhoneNumberUtils.isMobileNumber(phoneNumb)) {
            toast("请输入正确的手机号");
            startActivity(new Intent(this, MainActivity.class));
            loginActivityPresenter.doLogin(this,phoneNumb,password);
            finish();
        }else {

        }
    }

    @Override
    public void onLoginSucess() {

    }

    @Override
    public void onLoginFailed(String msg) {

    }
}