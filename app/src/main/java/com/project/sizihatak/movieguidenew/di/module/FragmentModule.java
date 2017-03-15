package com.project.sizihatak.movieguidenew.di.module;

import com.project.sizihatak.movieguidenew.ui.main.movies_list.MoviesListContract;
import com.project.sizihatak.movieguidenew.ui.main.movies_list.MoviesListPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {
    @Provides
    MoviesListContract.Presenter<MoviesListContract.View> provideMainPresenter(MoviesListPresenter presenter) {
        return presenter;
    }
}
