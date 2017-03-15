package com.project.sizihatak.movieguidenew.ui.main;

import com.project.sizihatak.movieguidenew.ui.base.MvpPresenter;
import com.project.sizihatak.movieguidenew.ui.base.MvpView;

public class MainContract {

    public interface Presenter<V extends MvpView> extends MvpPresenter<V> {

    }


    public interface View extends MvpView {
        void openMoviesDetailsScreen();
        void openMoviesListScreen();
    }

}
