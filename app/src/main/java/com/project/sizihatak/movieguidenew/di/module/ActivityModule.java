package com.project.sizihatak.movieguidenew.di.module;

import android.app.Activity;

import com.project.sizihatak.movieguidenew.ui.main.Contract;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    Contract.IMainPresenter<Contract.IMainView> provideMainPresenter(Contract.IMainPresenter<Contract.IMainView> presenter) {
        return presenter;
    }

}
