package com.project.sizihatak.movieguidenew.di.module;

import android.app.Activity;

import com.project.sizihatak.movieguidenew.ui.main.MainContract;
import com.project.sizihatak.movieguidenew.ui.main.MainPresenter;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

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
    MainContract.Presenter<MainContract.View> provideMainPresenter(MainPresenter presenter) {
        return presenter;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

}
