package com.project.sizihatak.movieguidenew.ui.main.details;

import com.anadeainc.rxbus.Bus;
import com.project.sizihatak.movieguidenew.data.DataManager;
import com.project.sizihatak.movieguidenew.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;


public class DetailsPresenter extends BasePresenter<DetailsContract.View> implements DetailsContract.Presenter<DetailsContract.View> {

    @Inject
    public DetailsPresenter(Bus eventBus, CompositeDisposable compositeDisposable, DataManager dataManager) {
        super(eventBus, compositeDisposable, dataManager);
    }
}
