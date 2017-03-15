package com.project.sizihatak.movieguidenew.di.component;

import com.project.sizihatak.movieguidenew.di.module.ActivityModule;
import com.project.sizihatak.movieguidenew.di.module.FragmentModule;
import com.project.sizihatak.movieguidenew.di.scope.PerActivity;
import com.project.sizihatak.movieguidenew.ui.main.details.DetailsFragment;
import com.project.sizihatak.movieguidenew.ui.main.list.MoviesListFragment;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class, FragmentModule.class})
public interface FragmentComponent {
    void inject(MoviesListFragment fragment);
    void inject(DetailsFragment fragment);
}
