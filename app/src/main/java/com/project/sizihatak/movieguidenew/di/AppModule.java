package com.project.sizihatak.movieguidenew.di;

import android.app.Application;
import android.content.Context;

import com.project.sizihatak.movieguidenew.di.qualifiers.AppContext;

import dagger.Provides;

public class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @AppContext
    Context appContext() {
        return application;
    }

}
