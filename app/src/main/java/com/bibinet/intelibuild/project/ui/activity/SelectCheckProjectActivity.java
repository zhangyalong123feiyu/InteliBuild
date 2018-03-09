package com.bibinet.intelibuild.project.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bibinet.intelibuild.R;
import com.bibinet.intelibuild.mvp.view.SelectCheckProjectActivityView;
import com.bibinet.intelibuild.project.adapter.SelectcheckProjectAdapter;
import com.bibinet.intelibuild.project.ui.baseui.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by bibinet on 2017-12-23.
 */

public class SelectCheckProjectActivity extends BaseActivity implements SelectCheckProjectActivityView{
    @BindView(R.id.printLabel)
    Button printLabel;
    @BindView(R.id.checkRecyclerView)
    RecyclerView checkRecyclerView;

    @Override
    protected int getChildlayout() {
        return R.layout.activity_selectcheckproject;
    }

    @Override
    protected void initView() {
        title.setText("选择检测项目");
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3);
        checkRecyclerView.setLayoutManager(gridLayoutManager);
        SelectcheckProjectAdapter adapter=new SelectcheckProjectAdapter(this);
        checkRecyclerView.setAdapter(adapter);
    }

    @OnClick({R.id.title_imageleft,R.id.printLabel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_imageleft:
                finish();
                break;

            case R.id.printLabel:
                toast("打印标签");
                break;

            default:
                break;
        }
    }

    @Override
    public void onPrintSelectSucess() {

    }

    @Override
    public void onPrintSelectFailed(String error) {

    }
}