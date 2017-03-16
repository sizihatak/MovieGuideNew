package com.project.sizihatak.movieguidenew.ui.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

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
    protected void setUp() {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void openMoviesListScreen() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(MoviesListFragment.TAG);
        fragmentManager
                .beginTransaction()
                .replace(R.id.frameLayout_main_fragmentContainer,
                        (fragment == null) ? MoviesListFragment.newInstance() : fragment, MoviesListFragment.TAG)
                .commit();
    }

    @Override
    public void openMoviesDetailsScreen(Movie movie) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(DetailsFragment.TAG);
        fragmentManager
                .beginTransaction()
                .replace(R.id.frameLayout_main_fragmentContainer,
                        (fragment == null) ? DetailsFragment.newInstance(movie) : fragment, DetailsFragment.TAG)
                .addToBackStack(DetailsFragment.TAG)
                .commit();
    }
}