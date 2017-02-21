package com.project.sizihatak.movieguidenew.ui.base;

import com.androidnetworking.error.ANError;

interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);

    void onDetach();

    void handleApiError(ANError error);

    void setUserAsLoggedOut();
}
