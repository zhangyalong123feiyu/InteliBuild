package com.bibinet.intelibuild.mvp.view;

import com.bibinet.intelibuild.project.bean.FixOcrResultBean;

/**
 * Created by bibinet on 2018-1-10.
 */

public interface FixOcrResultActivityView {
    void onPostFixResultSucess();
    void onPostFixResultFailed(String msg);
}