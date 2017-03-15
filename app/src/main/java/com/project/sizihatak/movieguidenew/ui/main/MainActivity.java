package com.project.sizihatak.movieguidenew.ui.main;

import android.os.Bundle;

import com.project.sizihatak.movieguidenew.R;
import com.project.sizihatak.movieguidenew.ui.base.BaseActivity;
import com.project.sizihatak.movieguidenew.ui.main.movies_list.MoviesListFragment;

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
    public void openMoviesDetailsScreen() {

    }

    @Override
    public void openMoviesListScreen() {
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .add(R.id.frameLayout_activityMain_fragmentContainer, MoviesListFragment.newInstance(), MoviesListFragment.TAG)
                .commit();
    }
}