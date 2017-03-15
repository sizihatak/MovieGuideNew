package com.project.sizihatak.movieguidenew.ui.main.movies_list;

import com.project.sizihatak.movieguidenew.data.network.model.Movie;
import com.project.sizihatak.movieguidenew.ui.base.MvpPresenter;
import com.project.sizihatak.movieguidenew.ui.base.MvpView;

import java.util.List;

public class MoviesListContract {
    public interface Presenter<V extends MvpView> extends MvpPresenter<V> {
        void getMovies();
    }

    public interface View extends MvpView {
        void showMovies(List<Movie> movies);
        void onMovieClicked(Movie movie);
    }
}
