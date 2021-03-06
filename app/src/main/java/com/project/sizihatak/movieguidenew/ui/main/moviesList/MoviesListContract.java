package com.project.sizihatak.movieguidenew.ui.main.moviesList;

import com.project.sizihatak.movieguidenew.data.network.model.Movie;
import com.project.sizihatak.movieguidenew.ui.base.MvpPresenter;
import com.project.sizihatak.movieguidenew.ui.base.MvpView;

import java.util.List;

public class MoviesListContract {
    public interface Presenter<V extends MvpView> extends MvpPresenter<V> {
        void onMoviePressed(int position);
        void getMovies(int visibleItemCount, int totalItemCount, int firstVisibleItemPosition);
        void refreshMovies();
    }

    public interface View extends MvpView {
        void showMovies(List<Movie> movies);
        void onMovieClick(int position);
    }
}
