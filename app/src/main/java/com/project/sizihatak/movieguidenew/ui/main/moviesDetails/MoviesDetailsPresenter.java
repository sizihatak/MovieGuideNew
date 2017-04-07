package com.project.sizihatak.movieguidenew.ui.main.moviesDetails;

import com.anadeainc.rxbus.Bus;
import com.project.sizihatak.movieguidenew.data.DataManager;
import com.project.sizihatak.movieguidenew.data.network.model.Movie;
import com.project.sizihatak.movieguidenew.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


public class MoviesDetailsPresenter extends BasePresenter<MoviesDetailsContract.View> implements MoviesDetailsContract.Presenter<MoviesDetailsContract.View> {

    private Movie movie;

    @Inject
    MoviesDetailsPresenter(Bus eventBus, CompositeDisposable compositeDisposable, DataManager dataManager) {
        super(eventBus, compositeDisposable, dataManager);
    }

    @Override
    public void onAttach(MoviesDetailsContract.View mvpView) {
        super.onAttach(mvpView);
        getMvpView().showMovieDetails(movie);
        getTrailers();
    }

    private void getTrailers() {
        getCompositeDisposable().add(getDataManager().getTrailers(movie.getId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> {
                    state = State.LOADING;
                    getMvpView().showLoading();
                })
                .doOnError(throwable -> {
                    state = State.ERROR;
                    if (isViewAttached()) {
                        getMvpView().onError("Error on server");
                    }
                })
                .doOnSuccess(
                        response -> {
                            state = State.IDEAL;
                            getMvpView().showTrailers(response.getTrailers());
                        }
                )
                .subscribe((o, throwable) -> {
                            getCompositeDisposable().clear();
                            if (isViewAttached())
                                getMvpView().hideLoading();
                        }
                ));
    }

    @Override
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
