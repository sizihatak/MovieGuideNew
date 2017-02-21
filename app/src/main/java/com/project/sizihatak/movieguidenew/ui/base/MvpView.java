package com.project.sizihatak.movieguidenew.ui.base;

import android.support.annotation.StringRes;

interface MvpView {

    void showLoading();

    void hideLoading();

    void openActivityOnTokenExpire();

    void onError(@StringRes int resId);

    void onError(String message);

    boolean isNetworkConnected();

    void hideKeyboard();

}