package com.bibinet.intelibuild.project.builder;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by bibinet on 2018-1-19.
 */

public class CustomerLinearLayout extends LinearLayout {
    private boolean isCanUse;
    public CustomerLinearLayout(Context context) {
        super(context);
    }

    public CustomerLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomerLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setCanUse (boolean canUse){
        this.isCanUse=canUse;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (isCanUse) {
            return true;
        }else {
            return super.dispatchTouchEvent(ev);
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (isCanUse) {
            return true;
        }else {
            return super.onTouchEvent(event);
        }
    }
}