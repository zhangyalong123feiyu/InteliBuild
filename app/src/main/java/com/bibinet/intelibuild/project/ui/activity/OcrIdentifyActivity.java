package com.bibinet.intelibuild.project.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net

        .Uri;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.ocr.ui.camera.CameraActivity;
import com.bibinet.intelibuild.R;
import com.bibinet.intelibuild.project.ui.baseui.BaseActivity;
import com.bibinet.intelibuild.project.utils.FileUtil;
import com.bibinet.intelibuild.project.utils.OcrIdentifyUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by bibinet on 2017-12-21.
 */

public class OcrIdentifyActivity extends BaseActivity implements OcrIdentifyUtils.ocrIndentifyView {
    private static final int REQUEST_CODE_CAMERA = 1;
    private static final int REQUEST_CODE_PICK_IMAGE = 2;
    @BindView(R.id.starOcr)
    Button starOcr;
    @BindView(R.id.iamge)
    ImageView iamge;
    @BindView(R.id.imageInfoText)
    TextView imageInfoText;

    @Override
    protected int getChildlayout() {
        return R.layout.activity_ocridentify;
    }

    @Override
    protected void initView() {
        title.setText("文字识别");
        titleBackImage.setVisibility(View.VISIBLE);
        OcrIdentifyUtils.initOcrToken();
    }

    @OnClick(R.id.starOcr)
    public void onViewClicked() {
        Intent intent = new Intent(this, CameraActivity.class);
        intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH,
                FileUtil.getSaveFile(getApplication()).getAbsolutePath());
        intent.putExtra(CameraActivity.KEY_CONTENT_TYPE,
                CameraActivity.CONTENT_TYPE_GENERAL);
        startActivityForResult(intent, REQUEST_CODE_CAMERA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
            String filePath = OcrIdentifyUtils.getRealPathFromURI(this,uri);
            OcrIdentifyUtils.recGeneral(this,filePath);
        }

        if (requestCode == REQUEST_CODE_CAMERA && resultCode == Activity.RESULT_OK) {
            OcrIdentifyUtils.recGeneral(this,FileUtil.getSaveFile(getApplicationContext()).getAbsolutePath());
            String picFile = FileUtil.getSaveFile(getApplicationContext()).getAbsolutePath();
            Bitmap bitmap= BitmapFactory.decodeFile(picFile);
            iamge.setImageBitmap(bitmap);
        }
    }

    @Override
    public void onOcrIndentifySucess(String info) {
        imageInfoText.setText(info);
    }

    @Override
    public void onOcrIndentifyFailed(String error) {
        imageInfoText.setText(error);
    }
}
