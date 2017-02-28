package com.project.sizihatak.movieguidenew.di.module;

import android.app.Application;
import android.content.Context;

import com.project.sizihatak.movieguidenew.data.network.ApiHelper;
import com.project.sizihatak.movieguidenew.data.network.ApiHelperImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context appContext() {
        return application;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper() {
        return new ApiHelperImpl();
    }

}
