package com.project.sizihatak.movieguidenew.ui.main.moviesDetails;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.project.sizihatak.movieguidenew.R;
import com.project.sizihatak.movieguidenew.data.network.model.Movie;
import com.project.sizihatak.movieguidenew.data.network.model.Trailer;
import com.project.sizihatak.movieguidenew.ui.base.BaseFragment;

import java.util.List;

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

    @BindView(R.id.recyclerView_moviesDetails_trailers)
    RecyclerView trailersRecyclerView;

    private TrailersAdapter adapter;


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
        setUp(view);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new TrailersAdapter(this);
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
    protected void setUp(View view) {
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        trailersRecyclerView.setHasFixedSize(true);
        trailersRecyclerView.setLayoutManager(layoutManager);
        trailersRecyclerView.setAdapter(adapter);
    }


    @Override
    public void showTrailers(List<Trailer> trailers) {
        adapter.setTrailers(trailers);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onTrailerClick(int position) {
        presenter.onTrailerPressed(position);
    }

    @Override
    public void showYoutubeTrailer(String path) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(path)));
    }

    @Override
    public void onStart() {
        getFragmentComponent().inject(this);
        presenter.setMovie(getArguments().getParcelable(MOVIE));
        super.onStart();
    }


    @Override
    public void onDestroyView() {
        getArguments().clear();
        super.onDestroyView();
    }
}
