package com.project.sizihatak.movieguidenew.ui.main.moviesList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.sizihatak.movieguidenew.R;
import com.project.sizihatak.movieguidenew.data.network.model.Movie;
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
    private MoviesAdapter adapter;

    public static MoviesListFragment newInstance() {
        Bundle args = new Bundle();
        MoviesListFragment fragment = new MoviesListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies_list, container, false);
        setUnBinder(ButterKnife.bind(this, view));
        setUp(view);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new MoviesAdapter(this);
    }

    @Override
    public void onStart() {
        getFragmentComponent().inject(this);
        super.onStart();
    }

    @Override
    protected void setUp(View view) {
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), COLUMNS);
        moviesRecyclerView.setHasFixedSize(true);
        moviesRecyclerView.setLayoutManager(layoutManager);
        moviesRecyclerView.setAdapter(adapter);
        moviesRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();
                int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
                presenter.getMovies(visibleItemCount, totalItemCount, firstVisibleItemPosition);
            }
        });
    }

    @Override
    public void showMovies(List<Movie> movies) {
        adapter.setMovies(movies);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onMovieClick(int position) {
        presenter.onMoviePressed(position);
    }
}
