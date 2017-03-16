package com.project.sizihatak.movieguidenew.ui.main.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.project.sizihatak.movieguidenew.MovieGuideApp;
import com.project.sizihatak.movieguidenew.R;
import com.project.sizihatak.movieguidenew.data.network.model.Movie;
import com.project.sizihatak.movieguidenew.di.component.DaggerFragmentComponent;
import com.project.sizihatak.movieguidenew.di.module.ActivityModule;
import com.project.sizihatak.movieguidenew.di.module.FragmentModule;
import com.project.sizihatak.movieguidenew.ui.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsFragment
        extends BaseFragment<DetailsContract.View, DetailsContract.Presenter<DetailsContract.View>>
        implements DetailsContract.View {

    public static final String TAG = DetailsFragment.class.getName();
    public static final String MOVIE = "movie";

    @BindView(R.id.imageView_details_poster)
    ImageView posterImageView;

    @BindView(R.id.textView_details_title)
    TextView titleTextView;

    @BindView(R.id.textView_details_date)
    TextView dateTextView;

    @BindView(R.id.textView_details_rating)
    TextView ratingTextView;

    @BindView(R.id.textView_details_descriptions)
    TextView descriptionsTextView;

    @BindView(R.id.toolbar_details)
    Toolbar toolbar;

    public static DetailsFragment newInstance(Movie movie) {
        Bundle args = new Bundle();
        args.putParcelable(MOVIE, movie);
        DetailsFragment fragment = new DetailsFragment();
        fragment.setArguments(args);

        return fragment;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        setUnBinder(ButterKnife.bind(this, view));

        showMovieDetails(getArguments().getParcelable(MOVIE));

        return view;
    }

    public void showMovieDetails(Movie movie) {
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
        DaggerFragmentComponent.builder()
                .appComponent(((MovieGuideApp) getBaseActivity().getApplication()).getAppComponent())
                .activityModule(new ActivityModule(getBaseActivity()))
                .fragmentModule(new FragmentModule())
                .build().inject(this);
        super.onStart();
    }

    //TODO create Action bar
    @Override
    protected void setUp(View view) {
        /*setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");*/
    }

}
