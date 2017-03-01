package com.project.sizihatak.movieguidenew.ui.base;

import com.project.sizihatak.movieguidenew.data.DataManager;

import javax.inject.Inject;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V>{
    private V mMvpView;

    private DataManager dataManager;

    @Inject
    public BasePresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    //TODO
    @Override
    public void onDetach() {
        mMvpView = null;
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public V getMvpView() {
        return mMvpView;
    }

    //TODO
    @Override
    public void handleApiError(String error) {

    }

    //TODO
    @Override
    public void setUserAsLoggedOut() {

    }

}
