package com.project.sizihatak.movieguidenew.di.component;

import com.project.sizihatak.movieguidenew.di.module.ActivityModule;
import com.project.sizihatak.movieguidenew.di.scope.PerActivity;
import com.project.sizihatak.movieguidenew.ui.main.MainActivity;
import com.project.sizihatak.movieguidenew.ui.movie_details.MovieDetailsActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity activity);
    void inject(MovieDetailsActivity activity);
}
