package com.project.sizihatak.movieguidenew.ui.main;

import com.project.sizihatak.movieguidenew.data.DataManager;
import com.project.sizihatak.movieguidenew.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter<MainContract.View> {

    private static final String TAG = "MainPresenter";

    @Inject
    public MainPresenter(CompositeDisposable compositeDisposable, DataManager dataManager) {
        super(compositeDisposable, dataManager);
    }


    @Override
    public Object getMovies() {
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
                    getMvpView().showMovies(response.getMovies(), getDataManager().getEndPoint());
                })
                .subscribe((o, throwable) -> {
                    getCompositeDisposable().clear();
                    if (isViewAttached())
                        getMvpView().hideLoading();
                })

        ;
        return null;
    }
}
