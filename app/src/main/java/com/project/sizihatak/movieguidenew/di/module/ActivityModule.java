package com.project.sizihatak.movieguidenew.di.module;

import android.app.Activity;

import com.project.sizihatak.movieguidenew.ui.main.ContractMain;
import com.project.sizihatak.movieguidenew.ui.main.MainPresenter;

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
    ContractMain.IMainPresenter<ContractMain.IMainView> provideMainPresenter(MainPresenter presenter) {
        return presenter;
    }

}
