package com.project.sizihatak.movieguidenew.ui.base;

interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);

    void onDetach();

    void handleApiError(String error);

    void setUserAsLoggedOut();
}
