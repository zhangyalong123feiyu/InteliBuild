package com.bibinet.intelibuild.project.utils.ocrStrategy;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bibinet on 2018-2-6.
 */

public class OcrAllNumberGetTogether extends OcrAllNumberStrategy {

    public OcrAllNumberGetTogether(int type) {
        super(AllNumber);
    }

    @Override
    public int getOcrNumberToger(String string) {
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(string);
        String togetherNumber = m.replaceAll("").trim();
        if (!TextUtils.isEmpty(togetherNumber)) {
            return Integer.parseInt(togetherNumber);
        }
        return 0;
    }