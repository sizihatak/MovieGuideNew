package com.project.sizihatak.movieguidenew.data.network;

import com.project.sizihatak.movieguidenew.data.network.model.ApiError;

public interface ApiHelper<T> {
    T getApi();

    ApiError obtainError(Throwable throwable);

    String getEndPoint();

    String getPosterEndPoint();

    String getTrailerThumbnail();

    String getYoutubeVideoTrailer();
}
