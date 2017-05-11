package com.project.sizihatak.movieguidenew.ui.main.moviesDetails;

import com.project.sizihatak.movieguidenew.data.network.model.Movie;
import com.project.sizihatak.movieguidenew.data.network.model.Trailer;
import com.project.sizihatak.movieguidenew.ui.base.MvpPresenter;
import com.project.sizihatak.movieguidenew.ui.base.MvpView;

import java.util.List;

public class MoviesDetailsContract {
    public interface Presenter<V extends MvpView> extends MvpPresenter<V> {
        void setMovie(Movie movie);

        void onTrailerPressed(int position);
    }

    public interface View extends MvpView {
        void showMovieDetails(Movie movie);

        void showTrailers(List<Trailer> trailers);

        void onTrailerClick(int position);

        void showYoutubeTrailer(String path);
    }
}
