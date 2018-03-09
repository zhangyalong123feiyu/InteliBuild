package com.bibinet.intelibuild.project.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.bibinet.intelibuild.R;


/**
 * Created by bibinet on 2017-6-9.
 */

public class PublicPopWindowUtils implements PopupWindow.OnDismissListener {
    private Context context;
    private View popview;
    private PopupWindow popupWindow;
    private onPopDismissListener listener;
    public PublicPopWindowUtils(Context context, onPopDismissListener listener) {
        this.context = context;
        this.listener = listener;
    }

    public void showPopWindow(int layoutId) {
        popupWindow = new PopupWindow(context);
        popupWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(WindowManager.LayoutParams.MATCH_PARENT);
        popview= LayoutInflater.from(context).inflate(layoutId,null);
        popupWindow.setContentView(popview);
        //点击popupWindow以外的区域自动关闭popupWindow
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popupWindow.setOnDismissListener(this);
        popupWindow.setAnimationStyle(R.anim.tr_void);
    }

    public void showPopWindow(View view){
        popupWindow.showAsDropDown(view, 0, 0);//设置popwindow的弹出方式为向下弹出
    }

    public void dissMisPopWindow(){
        popupWindow.dismiss();
    }

    public View getPopview() {
        return popview;
    }

    @Override
    public void onDismiss() {
        listener.onDismiss();
    }
    public interface onPopDismissListener{
        void onDismiss();
    }
}
