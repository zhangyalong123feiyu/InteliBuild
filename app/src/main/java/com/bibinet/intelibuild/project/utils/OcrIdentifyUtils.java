package com.bibinet.intelibuild.project.utils;

import android.app.Activity;
import android.database.Cursor;
import android.net

        .Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.TextView;

import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.AccessToken;
import com.baidu.ocr.sdk.model.GeneralParams;
import com.baidu.ocr.sdk.model.GeneralResult;
import com.baidu.ocr.sdk.model.WordSimple;
import com.bibinet.intelibuild.project.application.IntelBuildApplication;

import java.io

        .File;

/**
 * Created by bibinet on 2017-12-21.
 */

public class OcrIdentifyUtils {
    public static void initOcrToken(){
        OCR.getInstance().initAccessToken(new OnResultListener<AccessToken>() {
            @Override
            public void onResult(AccessToken accessToken) {
                String token = accessToken.getAccessToken();
                Log.i("TAG","licence方式获取token成功");
            }

            @Override
            public void onError(OCRError error) {
                error.printStackTrace();
                Log.i("TAG", "licence方式获取token失败");
            }
        }, IntelBuildApplication.context);
    }

    public static void recGeneral(final ocrIndentifyView ocrIndentifyView, String filePath) {
        GeneralParams param = new GeneralParams();
        param.setDetectDirection(true);
        param.setImageFile(new File(filePath));
        OCR.getInstance().recognizeGeneral(param, new OnResultListener<GeneralResult>() {
            @Override
            public void onResult(GeneralResult result) {
                final StringBuilder sb = new StringBuilder();
                for (WordSimple word : result.getWordList()) {
                    sb.append(word.getWords());
                    sb.append("\n");
                }
                ocrIndentifyView.onOcrIndentifySucess(sb.toString());
            }

            @Override
            public void onError(final OCRError error) {
                ocrIndentifyView.onOcrIndentifyFailed(error.getMessage());
            }
        });
    }

    public static String getRealPathFromURI(Activity activity,Uri contentURI) {
        String result;
        Cursor cursor =activity.getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) { // Source is Dropbox or other similar local file path
            result = contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            result = cursor.getString(idx);
            cursor.close();
        }
        return result;
    }
    public   interface ocrIndentifyView{
        void onOcrIndentifySucess(String info);
        void onOcrIndentifyFailed(String error);
    }
}
