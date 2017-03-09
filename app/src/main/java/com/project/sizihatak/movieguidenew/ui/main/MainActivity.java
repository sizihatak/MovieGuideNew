package com.project.sizihatak.movieguidenew.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.project.sizihatak.movieguidenew.R;
import com.project.sizihatak.movieguidenew.data.network.model.Movie;
import com.project.sizihatak.movieguidenew.ui.base.BaseActivity;
import com.project.sizihatak.movieguidenew.ui.movie_details.MovieDetailsActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MainContract.View, MainContract.Presenter<MainContract.View>>
        implements MainContract.View {

    @BindView(R.id.movies_listing)
    RecyclerView moviesRecyclerView;

    private final static int COLUMNS = 2;
    private MoviesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        setUp();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.getMovies();
    }

    @Override
    protected void setUp() {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void showMovies(List<Movie> movies) {
        moviesRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, COLUMNS);

        moviesRecyclerView.setLayoutManager(layoutManager);
        adapter = new MoviesAdapter(movies, this);
        moviesRecyclerView.setAdapter(adapter);
    }

    @Override
    public void openMovieDetailsActivity(Movie movie) {
        Intent intent = new Intent(this, MovieDetailsActivity.class);
        intent.putExtra("MovieId", movie.getId());
        startActivity(intent);
    }

    @Override
    public void onMovieClicked(Movie movie) {
        presenter.showMovieDetails(movie);
    }



}
