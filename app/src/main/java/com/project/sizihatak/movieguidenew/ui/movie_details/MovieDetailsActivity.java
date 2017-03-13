package com.project.sizihatak.movieguidenew.ui.movie_details;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.project.sizihatak.movieguidenew.R;
import com.project.sizihatak.movieguidenew.data.network.model.Movie;
import com.project.sizihatak.movieguidenew.ui.base.BaseActivity;

public class MovieDetailsActivity extends BaseActivity<MovieDetailsContract.View, MovieDetailsContract.Presenter<MovieDetailsContract.View>>
        implements MovieDetailsContract.View{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        getActivityComponent().inject(this);
    }

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
