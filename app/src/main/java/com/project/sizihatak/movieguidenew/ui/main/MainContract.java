package com.project.sizihatak.movieguidenew.ui.main;

import com.project.sizihatak.movieguidenew.data.network.model.Movie;
import com.project.sizihatak.movieguidenew.ui.base.MvpPresenter;
import com.project.sizihatak.movieguidenew.ui.base.MvpView;

import java.util.List;

public class MainContract {

    public interface Presenter<V extends MvpView> extends MvpPresenter<V> {
        Object getMovies();
    }


    public interface View extends MvpView {
        void showMovies(List<Movie> movies, String endPoint);

        void onMovieClicked(Movie movie);
    }

}
