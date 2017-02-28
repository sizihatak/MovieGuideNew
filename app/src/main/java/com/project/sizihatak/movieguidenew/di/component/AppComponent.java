package com.project.sizihatak.movieguidenew.di.component;

import com.project.sizihatak.movieguidenew.MovieGuideApp;
import com.project.sizihatak.movieguidenew.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(MovieGuideApp app);

}
