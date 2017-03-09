package com.project.sizihatak.movieguidenew.ui.movie_details;

import com.project.sizihatak.movieguidenew.data.DataManager;
import com.project.sizihatak.movieguidenew.ui.base.BasePresenter;
import com.project.sizihatak.movieguidenew.ui.main.MainContract;

import io.reactivex.disposables.CompositeDisposable;

public class MovieDetailsPresenter extends BasePresenter<MovieDetailsContract.View>
        implements MovieDetailsContract.Presenter<MovieDetailsContract.View> {

    public MovieDetailsPresenter(CompositeDisposable compositeDisposable, DataManager dataManager) {
        super(compositeDisposable, dataManager);
    }

    @Override
    public void getMovieMovieDetails() {

    }
}
