package com.project.sizihatak.movieguidenew.ui.movie_details;

import com.project.sizihatak.movieguidenew.data.network.model.Movie;
import com.project.sizihatak.movieguidenew.ui.base.MvpPresenter;
import com.project.sizihatak.movieguidenew.ui.base.MvpView;

import java.util.List;

public interface MovieDetailsContract {
    interface Presenter<V extends MvpView> extends MvpPresenter<V> {
        void getMovieMovieDetails();
    }

    interface View extends MvpView {
        void showMovieDetails(Movie movie);
    }

}
