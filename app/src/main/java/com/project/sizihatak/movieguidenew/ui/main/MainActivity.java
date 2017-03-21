package com.project.sizihatak.movieguidenew.ui.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.project.sizihatak.movieguidenew.R;
import com.project.sizihatak.movieguidenew.ui.base.BaseActivity;
import com.project.sizihatak.movieguidenew.ui.main.moviesDetails.MoviesDetailsFragment;
import com.project.sizihatak.movieguidenew.ui.main.moviesList.MoviesListFragment;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity<MainContract.View, MainContract.Presenter<MainContract.View>>
        implements MainContract.View {

    private static final String TAG = MainActivity.class.getName();
    @BindView(R.id.toolbar_main)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUnBinder(ButterKnife.bind(this));
        setUp();
        openMoviesListScreen();
    }

    @Override
    protected void inject() {
        getActivityComponent().inject(this);

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
    public void onBackPressed() {
        presenter.onBackClick();
        super.onBackPressed();
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
    public void openMoviesDetailsScreen(Bundle args) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        MoviesDetailsFragment fragment = (MoviesDetailsFragment) fragmentManager.findFragmentByTag(MoviesDetailsFragment.TAG);
        if (fragment == null) {
            fragment = MoviesDetailsFragment.newInstance(args);
        } else {
            fragment.getArguments().putAll(args);
        }
        fragmentManager
                .beginTransaction()
                .replace(R.id.frameLayout_main_fragmentContainer, fragment, MoviesDetailsFragment.TAG)
                .addToBackStack(MoviesDetailsFragment.TAG)
                .commit();
    }
}