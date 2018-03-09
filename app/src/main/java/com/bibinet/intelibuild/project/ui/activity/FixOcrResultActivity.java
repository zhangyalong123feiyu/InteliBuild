package com.bibinet.intelibuild.project.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bibinet.intelibuild.R;
import com.bibinet.intelibuild.mvp.presenter.FixOcrResultActivityPresenter;
import com.bibinet.intelibuild.mvp.view.FixOcrResultActivityView;
import com.bibinet.intelibuild.project.application.Constants;
import com.bibinet.intelibuild.project.builder.EditWatcher;
import com.bibinet.intelibuild.project.ui.baseui.BaseActivity;
import com.bibinet.intelibuild.project.utils.FileUtil;
import com.shawnlin.numberpicker.NumberPicker;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by bibinet on 2018-1-3.
 */

public class FixOcrResultActivity extends BaseActivity implements FixOcrResultActivityView{
    @BindView(R.id.ocrResult)
    EditText ocrResult;
    @BindView(R.id.numberPicker)
    NumberPicker numberPicker;
    @BindView(R.id.doStandard)
    TextView doStandard;
    @BindView(R.id.checkData)
    TextView checkData;
    @BindView(R.id.CheckResult)
    TextView CheckResult;
    @BindView(R.id.fixResult)
    EditText fixResult;
    @BindView(R.id.lastText)
    TextView lastText;
    @BindView(R.id.ocrPic)
    ImageView ocrPic;
    @BindView(R.id.postData)
    TextView postData;
    @BindView(R.id.backMain)
    TextView backMain;
    @BindView(R.id.checkdProductData)
    TextView checkdProductData;
    @BindView(R.id.checkResultLayout)
    RelativeLayout checkResultLayout;
    private String[] numberPickerValues = {"Ω", "kΩ", "MΩ"};
    private FixOcrResultActivityPresenter fixOcrResultActivityPresenter;
    private String selectedOcrUnit="KΩ";//设置默认选中的numberpicker的单位

    @Override
    protected int getChildlayout() {
        return R.layout.activity_fixocr;
    }

    @Override
    protected void initView() {
        title.setText("修改识别结果");
        String ocrData = getIntent().getStringExtra("ocrData");
        ocrResult.setText(ocrData.trim());
        fixOcrResultActivityPresenter=new FixOcrResultActivityPresenter(this);
        String picFile = FileUtil.getSaveFile(getApplicationContext()).getAbsolutePath();
        Bitmap bitmap = BitmapFactory.decodeFile(picFile);
        ocrPic.setImageBitmap(bitmap);
        ocrResult.setSelection(fixResult.getText().length());
        ocrResult.requestFocus();
        fixResult.addTextChangedListener(new EditWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {
                lastText.setText(String.valueOf(300-editable.toString().length()));
            }
        });
        initNumberPicker();
    }
    private void initNumberPicker() {
        numberPicker.setDisplayedValues(numberPickerValues);
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                selectedOcrUnit= numberPickerValues[i1];
            }
        });

    }
    @OnClick({R.id.ocrPic, R.id.postData, R.id.backMain})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ocrPic:
                startActivity(new Intent(this,BigImageActivity.class));
                break;
            case R.id.postData:
                postFixData();
                break;
            case R.id.backMain:
                finish();
                break;
        }
    }
    //提交修改结果
    private void postFixData() {
        String ocrResultData=ocrResult.getText().toString()+selectedOcrUnit;
//        fixOcrResultActivityPresenter.postFixResultData(this,ocrResultData,checkdProductData.getText().toString(),doStandard.getText().toString(),
//                checkData.getText().toString(),lastText.getText().toString(),fixResult.getText().toString());
        Intent intent= new Intent();
        intent.putExtra("fixValue",ocrResult.getText().toString().trim());
        intent.putExtra("ocrUnit",selectedOcrUnit);
        intent.putExtra("isfixData",true);
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    public void onPostFixResultSucess() {

    }

    @Override
    public void onPostFixResultFailed(String msg) {

    }
}
