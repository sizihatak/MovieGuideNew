package com.project.sizihatak.movieguidenew.di.component;

import com.project.sizihatak.movieguidenew.di.module.ActivityModule;
import com.project.sizihatak.movieguidenew.di.module.FragmentModule;
import com.project.sizihatak.movieguidenew.di.scope.PerFragment;
import com.project.sizihatak.movieguidenew.ui.main.moviesDetails.MoviesDetailsFragment;
import com.project.sizihatak.movieguidenew.ui.main.moviesList.MoviesListFragment;

import dagger.Component;

@PerFragment
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class, FragmentModule.class})
public interface FragmentComponent {
    void inject(MoviesListFragment fragment);
    void inject(MoviesDetailsFragment fragment);
}
