/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.bibinet.intelibuild.project.utils;

import android.content.Context;

import java.io

        .File;

//文件的操作工具类
public class FileUtil {
    public static File getSaveFile(Context context) {
        File file = new File(context.getFilesDir(), "ocrPic.jpg");
        return file;
    }
}