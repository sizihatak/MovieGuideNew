package com.project.sizihatak.movieguidenew.data.network;

import com.project.sizihatak.movieguidenew.data.network.model.ApiError;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppApiHelper implements ApiHelper<MovieGuideApi>{

    private final MovieGuideApi api;

    @Inject
    public AppApiHelper(MovieGuideApi api) {
        this.api = api;
    }

    @Override
    public MovieGuideApi getApi() {
        return api;
    }

    @Override
    public ApiError obtainError(Throwable throwable) {
        return null;
    }

    @Override
    public String getEndPoint() {
        return ApiEndPoint.END_POINT;
    }

    @Override
    public String getPosterEndPoint() {
        return ApiEndPoint.POSTER_END_POINT;
    }

    @Override
    public String getTrailerThumbnail () {
        return ApiEndPoint.GET_THUMBNAIL_FOR_TRAILER;
    }

}
