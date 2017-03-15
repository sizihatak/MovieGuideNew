package com.project.sizihatak.movieguidenew.ui.main.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.sizihatak.movieguidenew.MovieGuideApp;
import com.project.sizihatak.movieguidenew.R;
import com.project.sizihatak.movieguidenew.data.network.model.Movie;
import com.project.sizihatak.movieguidenew.di.component.DaggerFragmentComponent;
import com.project.sizihatak.movieguidenew.di.module.ActivityModule;
import com.project.sizihatak.movieguidenew.di.module.FragmentModule;
import com.project.sizihatak.movieguidenew.ui.base.BaseFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesListFragment
        extends BaseFragment<MoviesListContract.View, MoviesListContract.Presenter<MoviesListContract.View>>
        implements MoviesListContract.View {

    public static final String TAG = MoviesListFragment.class.getName();

    private final static int COLUMNS = 2;

    @BindView(R.id.recyclerView_main_movies)
    RecyclerView moviesRecyclerView;

    public static MoviesListFragment newInstance() {
        Bundle args = new Bundle();
        MoviesListFragment fragment = new MoviesListFragment();
        fragment.setArguments(args);

        return fragment;
    }


    @Override
    public void onStart() {
        DaggerFragmentComponent.builder()
                .appComponent(((MovieGuideApp) getBaseActivity().getApplication()).getAppComponent())
                .activityModule(new ActivityModule(getBaseActivity()))
                .fragmentModule(new FragmentModule())
                .build().inject(this);
        super.onStart();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        setUnBinder(ButterKnife.bind(this, view));
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.getMovies();
    }

    @Override
    protected void setUp(View view) {

    }

    @Override
    public void showMovies(List<Movie> movies) {
        moviesRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), COLUMNS);

        moviesRecyclerView.setLayoutManager(layoutManager);
        MoviesAdapter adapter = new MoviesAdapter(movies, this);
        moviesRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onMovieClicked(Movie movie) {
        presenter.onMovieClicked(movie);
    }
}
