package com.project.sizihatak.movieguidenew.ui.main;

import com.project.sizihatak.movieguidenew.data.DataManager;
import com.project.sizihatak.movieguidenew.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter<MainContract.View> {

    private static final String TAG = "MainPresenter";

    @Inject
    MainPresenter(CompositeDisposable compositeDisposable, DataManager dataManager) {
        super(compositeDisposable, dataManager);
    }
}
