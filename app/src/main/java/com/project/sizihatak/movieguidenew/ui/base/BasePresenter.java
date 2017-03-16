package com.project.sizihatak.movieguidenew.ui.base;

import com.anadeainc.rxbus.Bus;
import com.project.sizihatak.movieguidenew.data.DataManager;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V>{
    private V mMvpView;

    private Bus eventBus;

    private CompositeDisposable compositeDisposable;
    private DataManager dataManager;

    @Inject
    public BasePresenter(Bus eventBus, CompositeDisposable compositeDisposable, DataManager dataManager) {
        this.compositeDisposable = compositeDisposable;
        this.dataManager = dataManager;
        this.eventBus = eventBus;
    }

    protected CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    protected DataManager getDataManager() {
        return dataManager;
    }

    protected Bus getEventBus() {
        return eventBus;
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
        this.eventBus.register(this);
    }

    //TODO
    @Override
    public void onDetach() {
        eventBus.unregister(this);
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
