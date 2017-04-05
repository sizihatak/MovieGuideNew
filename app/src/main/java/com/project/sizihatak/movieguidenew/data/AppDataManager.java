package com.project.sizihatak.movieguidenew.data;

import android.support.annotation.NonNull;

import com.project.sizihatak.movieguidenew.data.network.ApiHelper;
import com.project.sizihatak.movieguidenew.data.network.MovieGuideApi;
import com.project.sizihatak.movieguidenew.data.network.model.GetMovieResponse;
import com.project.sizihatak.movieguidenew.data.network.model.Movie;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.functions.Function;

public class AppDataManager implements DataManager {

    private ApiHelper<MovieGuideApi> apiHelper;

    @Inject
    AppDataManager(ApiHelper<MovieGuideApi> apiHelper) {
        this.apiHelper = apiHelper;
    }

    @Override
    public Single<GetMovieResponse> getMovies(int page) {
        return apiHelper.getApi().getMovies(page)
                .map(addEndPointToBackdropPathFunction());
    }

    @NonNull
    private Function<GetMovieResponse, GetMovieResponse> addEndPointToBackdropPathFunction() {
        return response -> {
            for (Movie movie : response.getMovies()) {
                movie.addEndPointToPosterPath(apiHelper.getPosterEndPoint());
                movie.addEndPointToBackdropPath(apiHelper.getPosterEndPoint());
            }
            return response;
        };
    }
}
