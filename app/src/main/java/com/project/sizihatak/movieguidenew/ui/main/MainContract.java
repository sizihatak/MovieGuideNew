package com.project.sizihatak.movieguidenew.ui.main;

import com.project.sizihatak.movieguidenew.data.network.model.Movie;
import com.project.sizihatak.movieguidenew.ui.base.MvpPresenter;
import com.project.sizihatak.movieguidenew.ui.base.MvpView;

public class MainContract {

    public interface Presenter<V extends MvpView> extends MvpPresenter<V> {
        void onBackArrowClick();
    }

    public interface View extends MvpView {
        void openMoviesDetailsScreen(Movie movie);
        void openMoviesListScreen();
        void showBackArrow();
        void hideBackArrow();
    }

}
