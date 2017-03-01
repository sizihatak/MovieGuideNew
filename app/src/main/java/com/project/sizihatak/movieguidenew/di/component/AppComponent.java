package com.project.sizihatak.movieguidenew.di.component;

import com.project.sizihatak.movieguidenew.MovieGuideApp;
import com.project.sizihatak.movieguidenew.data.DataManager;
import com.project.sizihatak.movieguidenew.di.module.AppModule;
import com.project.sizihatak.movieguidenew.di.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {

    void inject(MovieGuideApp app);

    DataManager getDataManager();
}
