package com.project.sizihatak.movieguidenew.ui.main.moviesDetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.project.sizihatak.movieguidenew.R;
import com.project.sizihatak.movieguidenew.data.network.model.Movie;
import com.project.sizihatak.movieguidenew.ui.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesDetailsFragment
        extends BaseFragment<MoviesDetailsContract.View, MoviesDetailsContract.Presenter<MoviesDetailsContract.View>>
        implements MoviesDetailsContract.View {

    public static final String TAG = MoviesDetailsFragment.class.getName();
    public static final String MOVIE = "movie";

    @BindView(R.id.imageView_moviesDetails_poster)
    ImageView posterImageView;

    @BindView(R.id.textView_moviesDetails_title)
    TextView titleTextView;

    @BindView(R.id.textView_moviesDetails_date)
    TextView dateTextView;

    @BindView(R.id.textView_moviesDetails_rating)
    TextView ratingTextView;

    @BindView(R.id.textView_moviesDetails_descriptions)
    TextView descriptionsTextView;

    public static MoviesDetailsFragment newInstance(Bundle args) {
        MoviesDetailsFragment fragment = new MoviesDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies_details, container, false);
        setUnBinder(ButterKnife.bind(this, view));

        showMovieDetails(getArguments().getParcelable(MOVIE));

        return view;
    }

    public void showMovieDetails(Movie movie) {
        if (movie == null) {
            return;
        }
        Glide.with(getContext()).load(movie.getBackdropPath())
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(posterImageView);
        titleTextView.setText(movie.getTitle());
        dateTextView.setText(String.format(getString(R.string.movieDetails_releaseDate), movie.getReleaseDate()));
        ratingTextView.setText(String.format(getString(R.string.movieDetails_rating), String.valueOf(movie.getVoteAverage())));
        descriptionsTextView.setText(movie.getOverview());
    }

    @Override
    public void onStart() {
        getFragmentComponent().inject(this);
        super.onStart();
    }

    @Override
    protected void setUp(View view) {
    }

    @Override
    public void onDestroyView() {
        getArguments().clear();
        super.onDestroyView();
    }
}
