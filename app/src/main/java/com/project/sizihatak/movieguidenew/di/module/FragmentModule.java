package com.project.sizihatak.movieguidenew.di.module;

import com.project.sizihatak.movieguidenew.di.scope.PerFragment;
import com.project.sizihatak.movieguidenew.ui.main.moviesDetails.MoviesDetailsContract;
import com.project.sizihatak.movieguidenew.ui.main.moviesDetails.MoviesDetailsPresenter;
import com.project.sizihatak.movieguidenew.ui.main.moviesList.MoviesListContract;
import com.project.sizihatak.movieguidenew.ui.main.moviesList.MoviesListPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {
    @PerFragment
    @Provides
    MoviesListContract.Presenter<MoviesListContract.View> provideMoviesListPresenter(MoviesListPresenter presenter) {
        return presenter;
    }

    @PerFragment
    @Provides
    MoviesDetailsContract.Presenter<MoviesDetailsContract.View> provideDetailsPresenter(MoviesDetailsPresenter presenter) {
        return presenter;
    }
}
