package com.project.sizihatak.movieguidenew.ui.main;

import com.anadeainc.rxbus.Bus;
import com.anadeainc.rxbus.Subscribe;
import com.project.sizihatak.movieguidenew.data.DataManager;
import com.project.sizihatak.movieguidenew.ui.base.BasePresenter;
import com.project.sizihatak.movieguidenew.ui.main.event.OpenMovieDetailsEvent;
import com.project.sizihatak.movieguidenew.ui.main.event.OpenMoviesListEvent;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter<MainContract.View> {

    private static final String TAG = "MainPresenter";

    @Inject
    MainPresenter(Bus bus, CompositeDisposable compositeDisposable, DataManager dataManager) {
        super(bus, compositeDisposable, dataManager);
    }

    @Subscribe
    public void onEvent(OpenMovieDetailsEvent event) {
        getMvpView().openMoviesDetailsScreen();
    }


    @Subscribe
    public void onEvent(OpenMoviesListEvent event) {
        getMvpView().openMoviesListScreen();
    }

}
