package com.project.sizihatak.movieguidenew.data.network;

import com.project.sizihatak.movieguidenew.data.network.model.GetMovieResponse;

public interface ApiHelper {
    Observable<GetMovieResponse> doGetMoviesListApiCall(GetMovieRequest request);
}
