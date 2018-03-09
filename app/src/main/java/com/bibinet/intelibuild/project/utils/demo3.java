package com.bibinet.intelibuild.project.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class demo3 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String a="love23next234csdn3423javaeye";
        List<String> digitList = new ArrayList<String>();
        Pattern p = Pattern.compile("^(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))$");
        Matcher m = p.matcher(a);
        String result = m.replaceAll("");
        for (int i = 0; i < result.length(); i++) {
            digitList.add(result.substring(i, i+1));

        }
        System.out.println(digitList);

    }

}