package com.project.sizihatak.movieguidenew.ui.movie_details;

import com.project.sizihatak.movieguidenew.data.network.model.Movie;
import com.project.sizihatak.movieguidenew.ui.base.BaseActivity;
import com.project.sizihatak.movieguidenew.ui.main.MainContract;

public class MovieDetailsActivity extends BaseActivity<MovieDetailsContract.View, MovieDetailsContract.Presenter<MovieDetailsContract.View>>
        implements MovieDetailsContract.View{
    @Override
    public void onError(String message) {

    }

    @Override
    public void showMovieDetails(Movie movie) {

    }

    @Override
    protected void setUp() {

    }
}
