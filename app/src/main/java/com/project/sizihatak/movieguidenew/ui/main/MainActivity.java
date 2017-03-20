package com.project.sizihatak.movieguidenew.ui.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.project.sizihatak.movieguidenew.R;
import com.project.sizihatak.movieguidenew.data.network.model.Movie;
import com.project.sizihatak.movieguidenew.ui.base.BaseActivity;
import com.project.sizihatak.movieguidenew.ui.main.moviesDetails.MoviesDetailsFragment;
import com.project.sizihatak.movieguidenew.ui.main.moviesList.MoviesListFragment;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity<MainContract.View, MainContract.Presenter<MainContract.View>>
        implements MainContract.View {

    @BindView(R.id.toolbar_main)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        setUp();
        openMoviesListScreen();
    }

    @Override
    protected void setUp() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
    }

    @Override
    public void showBackArrow(){
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void hideBackArrow(){
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            presenter.onBackArrowClick();
            return true;
        }
        return super.onOptionsItemSelected(item);
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
        Fragment fragment = fragmentManager.findFragmentByTag(MoviesDetailsFragment.TAG);
        if (fragment == null) {
            fragment = MoviesDetailsFragment.newInstance(movie);
        } else {
            Bundle args = new Bundle();
            args.putParcelable(MoviesDetailsFragment.MOVIE, movie);
            fragment.setArguments(args);
        }
        fragmentManager
                .beginTransaction()
                .replace(R.id.frameLayout_main_fragmentContainer, fragment, MoviesDetailsFragment.TAG)
                .addToBackStack(MoviesDetailsFragment.TAG)
                .commit();
    }
}