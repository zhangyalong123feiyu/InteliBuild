package com.bibinet.intelibuild.mvp.presenter;

import com.google.gson.Gson;

/**
 * Created by bibinet on 2017-12-18.
 */

public class BasePresenter {
    protected Gson gson;

    public BasePresenter() {
        this.gson = new Gson();
    }
}