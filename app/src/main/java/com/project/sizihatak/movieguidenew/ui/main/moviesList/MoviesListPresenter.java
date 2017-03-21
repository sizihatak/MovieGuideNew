package com.project.sizihatak.movieguidenew.ui.main.moviesList;

import com.anadeainc.rxbus.Bus;
import com.project.sizihatak.movieguidenew.data.DataManager;
import com.project.sizihatak.movieguidenew.data.network.model.Movie;
import com.project.sizihatak.movieguidenew.ui.base.BasePresenter;
import com.project.sizihatak.movieguidenew.ui.main.event.OpenMovieDetailsEvent;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MoviesListPresenter extends BasePresenter<MoviesListContract.View>
        implements MoviesListContract.Presenter<MoviesListContract.View> {

    private List<Movie> movies = new ArrayList<>();


    @Inject
    public MoviesListPresenter(Bus bus, CompositeDisposable compositeDisposable, DataManager dataManager) {
        super(bus, compositeDisposable, dataManager);
    }

    @Override
    public void onAttach(MoviesListContract.View mvpView) {
        super.onAttach(mvpView);
        if (state == State.EMPTY) {
            getMovies();
        }
    }

    @Override
    public void getMovies() {
        getDataManager().getApi().getMovies()
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
                .doOnSuccess(response -> {
                    state = State.IDEAL;
                    for (Movie movie : response.getMovies()) {
                        movie.addEndPointToPosterPath(getDataManager().getPosterEndPoint());
                        movie.addEndPointToBackdropPath(getDataManager().getPosterEndPoint());
                    }
                })
                .doAfterSuccess(
                        response -> {
                            movies = response.getMovies();
                            getMvpView().showMovies(movies);
                        }
                )
                .subscribe((o, throwable) -> {
                    getCompositeDisposable().clear();
                    if (isViewAttached())
                        getMvpView().hideLoading();
                });
    }

    @Override
    public void onMoviePressed(int position) {
        getEventBus().post(new OpenMovieDetailsEvent(movies.get(position)));
    }
}
