package com.project.sizihatak.movieguidenew;

import android.app.Application;

import com.project.sizihatak.movieguidenew.di.AppComponent;
import com.project.sizihatak.movieguidenew.di.AppModule;

public class MovieGuideApp extends Application {

    private AppComponent appComponent;

    public AppComponent appComponent() {

        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .build();
        }

        return appComponent;
    }

}