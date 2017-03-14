package com.project.sizihatak.movieguidenew.ui.movie_details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.project.sizihatak.movieguidenew.R;
import com.project.sizihatak.movieguidenew.data.network.model.Movie;
import com.project.sizihatak.movieguidenew.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieDetailsActivity extends BaseActivity<MovieDetailsContract.View, MovieDetailsContract.Presenter<MovieDetailsContract.View>>
        implements MovieDetailsContract.View{

    public static final String MOVIE = "movie";

    @BindView(R.id.imageView_movieDetails_poster)
    ImageView posterImageView;

    @BindView(R.id.textView_movieDetails_title)
    TextView titleTextView;

    @BindView(R.id.textView_movieDetails_date)
    TextView dateTextView;

    @BindView(R.id.textView_movieDetails_rating)
    TextView ratingTextView;

    @BindView(R.id.textView_movieDetails_descriptions)
    TextView descriptionsTextView;

    @BindView(R.id.toolbar_movieDetails)
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        setUp();
        showMovieDetails(getIntent().getExtras().getParcelable(MOVIE));
    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void showMovieDetails(Movie movie) {
        Glide.with(getApplicationContext()).load(movie.getBackdropPath())
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(posterImageView);
        titleTextView.setText(movie.getTitle());
        dateTextView.setText(String.format(getString(R.string.movieDetails_releaseDate), movie.getReleaseDate()));
        ratingTextView.setText(String.format(getString(R.string.movieDetails_rating), String.valueOf(movie.getVoteAverage())));
        descriptionsTextView.setText(movie.getOverview());
    }

    @Override
    protected void setUp() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}