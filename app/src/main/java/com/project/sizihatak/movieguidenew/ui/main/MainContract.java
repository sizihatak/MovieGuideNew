package com.project.sizihatak.movieguidenew.ui.main;

import android.os.Bundle;

import com.project.sizihatak.movieguidenew.ui.base.MvpPresenter;
import com.project.sizihatak.movieguidenew.ui.base.MvpView;

public class MainContract {

    public interface Presenter<V extends MvpView> extends MvpPresenter<V> {
        void onBackClick();
    }

    public interface View extends MvpView {
        void openMoviesDetailsScreen(Bundle args);
        void openMoviesListScreen();
        void showBackArrow();
        void hideBackArrow();
        void onPreviousScreen();
    }

}
