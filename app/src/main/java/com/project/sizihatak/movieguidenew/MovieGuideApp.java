package com.project.sizihatak.movieguidenew;

import android.app.Application;

import com.project.sizihatak.movieguidenew.di.component.AppComponent;
import com.project.sizihatak.movieguidenew.di.component.DaggerAppComponent;
import com.project.sizihatak.movieguidenew.di.module.AppModule;

public class MovieGuideApp extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .build();
        }
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}