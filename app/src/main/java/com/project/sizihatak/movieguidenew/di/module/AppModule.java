package com.project.sizihatak.movieguidenew.di.module;

import android.app.Application;
import android.content.Context;

import com.anadeainc.rxbus.Bus;
import com.anadeainc.rxbus.BusProvider;
import com.project.sizihatak.movieguidenew.data.AppDataManager;
import com.project.sizihatak.movieguidenew.data.DataManager;

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
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    Bus provideBus() {
        return BusProvider.getInstance();
    }

}