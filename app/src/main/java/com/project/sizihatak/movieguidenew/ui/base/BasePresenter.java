package com.project.sizihatak.movieguidenew.ui.base;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V>{
    private V mMvpView;

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
