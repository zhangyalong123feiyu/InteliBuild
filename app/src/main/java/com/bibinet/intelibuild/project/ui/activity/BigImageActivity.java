package com.bibinet.intelibuild.project.ui.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;

import com.bibinet.intelibuild.R;
import com.bibinet.intelibuild.project.ui.baseui.BaseActivity;
import com.bibinet.intelibuild.project.utils.FileUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by bibinet on 2018-1-10.
 */

public class BigImageActivity extends BaseActivity {
    @BindView(R.id.bigImage)
    ImageView bigImage;

    @Override
    protected int getChildlayout() {
        return R.layout.activity_bigimage;
    }

    @Override
    protected void initView() {
        titleLayout.setVisibility(View.GONE);
        String picFile = FileUtil.getSaveFile(getApplicationContext()).getAbsolutePath();
        Bitmap bitmap = BitmapFactory.decodeFile(picFile);
        bigImage.setImageBitmap(bitmap);
    }

    @OnClick({R.id.title_imageleft,R.id.bigImage})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_imageleft:

                break;
            case R.id.bigImage:

                break;
            default:
                break;
        }
    }
}