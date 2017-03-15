package com.project.sizihatak.movieguidenew.di.module;

import com.project.sizihatak.movieguidenew.ui.main.details.DetailsContract;
import com.project.sizihatak.movieguidenew.ui.main.details.DetailsPresenter;
import com.project.sizihatak.movieguidenew.ui.main.list.MoviesListContract;
import com.project.sizihatak.movieguidenew.ui.main.list.MoviesListPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {
    @Provides
    MoviesListContract.Presenter<MoviesListContract.View> provideMoviesListPresenter(MoviesListPresenter presenter) {
        return presenter;
    }

    @Provides
    DetailsContract.Presenter<DetailsContract.View> provideDetailsPresenter(DetailsPresenter presenter) {
        return presenter;
    }
}
