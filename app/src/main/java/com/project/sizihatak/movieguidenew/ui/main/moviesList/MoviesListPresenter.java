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

    private static final String TAG = "MoviesListPresenter";
    private List<Movie> movies = new ArrayList<>();
    private int currentPage;
    private int totalPages;


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

    private void getMovies() {
        getDataManager().getApi().getMovies(++currentPage)
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
                    currentPage = response.getPage();
                    totalPages = response.getTotalPages();
                    for (Movie movie : response.getMovies()) {
                        movie.addEndPointToPosterPath(getDataManager().getPosterEndPoint());
                        movie.addEndPointToBackdropPath(getDataManager().getPosterEndPoint());
                    }
                })
                .doAfterSuccess(
                        response -> {
                            movies.addAll(response.getMovies());
                            getMvpView().showMovies(movies);
                            state = State.IDEAL;
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

    @Override
    public void getMovies(int visibleItemCount, int totalItemCount, int firstVisibleItemPosition) {
        if (state != State.LOADING && currentPage <= totalPages) {
            if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                    && firstVisibleItemPosition >= 0
                    && totalItemCount >= 20) {
                getMovies();
            }
        }
    }
}
