package com.project.sizihatak.movieguidenew.ui.main.list;

import com.anadeainc.rxbus.Bus;
import com.project.sizihatak.movieguidenew.data.DataManager;
import com.project.sizihatak.movieguidenew.data.network.model.Movie;
import com.project.sizihatak.movieguidenew.ui.base.BasePresenter;
import com.project.sizihatak.movieguidenew.ui.main.event.OpenMovieDetailsEvent;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MoviesListPresenter extends BasePresenter<MoviesListContract.View>
        implements MoviesListContract.Presenter<MoviesListContract.View> {

    @Inject
    public MoviesListPresenter(Bus bus, CompositeDisposable compositeDisposable, DataManager dataManager) {
        super(bus, compositeDisposable, dataManager);
    }

    @Override
    public void getMovies() {
        getDataManager().getApi().getMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> getMvpView().showLoading())
                .doOnError(throwable -> {
                    if (isViewAttached()) {
                        getMvpView().onError("Error on server");
                    }
                })
                .doOnSuccess(response -> {
                    for (Movie movie : response.getMovies()) {
                        movie.addEndPointToPosterPath(getDataManager().getPosterEndPoint());
                        movie.addEndPointToBackdropPath(getDataManager().getPosterEndPoint());
                    }
                })
                .doAfterSuccess(
                        response -> {
                            getMvpView().showMovies(response.getMovies());
                        }
                )
                .subscribe((o, throwable) -> {
                    getCompositeDisposable().clear();
                    if (isViewAttached())
                        getMvpView().hideLoading();
                });
    }

    @Override
    public void onMovieClicked(Movie movie) {
        getEventBus().post(new OpenMovieDetailsEvent(movie));
    }
}
