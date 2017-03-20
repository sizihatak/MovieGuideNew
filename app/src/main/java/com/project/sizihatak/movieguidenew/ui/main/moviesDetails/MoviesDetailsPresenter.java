package com.project.sizihatak.movieguidenew.ui.main.moviesDetails;

import com.anadeainc.rxbus.Bus;
import com.project.sizihatak.movieguidenew.data.DataManager;
import com.project.sizihatak.movieguidenew.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;


public class MoviesDetailsPresenter extends BasePresenter<MoviesDetailsContract.View> implements MoviesDetailsContract.Presenter<MoviesDetailsContract.View> {

    @Inject
    public MoviesDetailsPresenter(Bus eventBus, CompositeDisposable compositeDisposable, DataManager dataManager) {
        super(eventBus, compositeDisposable, dataManager);
    }
}
