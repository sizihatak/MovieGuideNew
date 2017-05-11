package com.project.sizihatak.movieguidenew.data;

import android.support.annotation.NonNull;

import com.project.sizihatak.movieguidenew.data.network.ApiHelper;
import com.project.sizihatak.movieguidenew.data.network.MovieGuideApi;
import com.project.sizihatak.movieguidenew.data.network.model.GetMovieResponse;
import com.project.sizihatak.movieguidenew.data.network.model.GetTrailersResponse;
import com.project.sizihatak.movieguidenew.data.network.model.Movie;
import com.project.sizihatak.movieguidenew.data.network.model.Trailer;

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

    @Override
    public Single<GetTrailersResponse> getTrailers(String trailerId) {
        return apiHelper.getApi().getTrailers(trailerId)
                .map(createThumbnailPathFunction());
    }

    @NonNull
    private Function<GetTrailersResponse, GetTrailersResponse> createThumbnailPathFunction() {
        return response -> {
            for (Trailer trailer : response.getTrailers()) {
                trailer.setThumbnailPath(String.format(apiHelper.getTrailerThumbnail(), trailer.getKey()));
                trailer.setTrailerYoutubeVideoPath(String.format(apiHelper.getYoutubeVideoTrailer(), trailer.getKey()));
            }
            return response;
        };
    }
}
