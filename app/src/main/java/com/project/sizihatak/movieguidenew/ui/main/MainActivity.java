package com.project.sizihatak.movieguidenew.ui.main;

import android.os.Bundle;

import com.project.sizihatak.movieguidenew.R;
import com.project.sizihatak.movieguidenew.data.network.model.Movie;
import com.project.sizihatak.movieguidenew.ui.base.BaseActivity;
import com.project.sizihatak.movieguidenew.ui.main.details.DetailsFragment;
import com.project.sizihatak.movieguidenew.ui.main.list.MoviesListFragment;

public class MainActivity extends BaseActivity<MainContract.View, MainContract.Presenter<MainContract.View>>
        implements MainContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActivityComponent().inject(this);
        openMoviesListScreen();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void setUp() {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void openMoviesDetailsScreen(Movie movie) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout_main_fragmentContainer, DetailsFragment.newInstance(movie), DetailsFragment.TAG)
                .addToBackStack(DetailsFragment.TAG)
                .commit();
    }

    @Override
    public void openMoviesListScreen() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout_main_fragmentContainer, MoviesListFragment.newInstance(), MoviesListFragment.TAG)
                .addToBackStack(MoviesListFragment.TAG)
                .commit();
    }
}