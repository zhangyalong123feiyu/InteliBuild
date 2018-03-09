package com.bibinet.intelibuild.project.utils;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.bibinet.intelibuild.R;
import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.listener.CustomListener;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by bibinet on 2017-12-28.
 */

public class PickerViewUtils {
    private OptionsPickerView pickerView;
    private List<String> integerList=new ArrayList();
    public int labelNumber;
    public void initView(Context context, final TextView textView, int layoutId){
        if (integerList.size()==0) {
            integerList.add("1");
            integerList.add("2");
            integerList.add("3");
        }
        pickerView = new OptionsPickerView.Builder(context, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String tx = integerList.get(options1);
                Log.i("TAG","选中的位置的值为"+tx);
                textView.setText(tx);
            }
        })
                .setLayoutRes(layoutId, new CustomListener() {
                    @Override
                    public void customLayout(View v) {
                        final TextView tvSubmit = (TextView) v.findViewById(R.id.tv_finish);
                        TextView ivCancel = (TextView) v.findViewById(R.id.iv_cancel);
                        tvSubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pickerView.returnData();
                                pickerView.dismiss();
                            }
                        });

                        ivCancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pickerView.dismiss();
                            }
                        });

                    }
                })
                .setBgColor(Color.LTGRAY)
                .setContentTextSize(18)
                .isDialog(false)
                .build();

        pickerView.setPicker(integerList);//添加数据
        pickerView.show();
    }
    public void showPickerView(){
        pickerView.show();
    }
}
