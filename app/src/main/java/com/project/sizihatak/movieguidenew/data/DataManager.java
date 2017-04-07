package com.project.sizihatak.movieguidenew.data;

import com.project.sizihatak.movieguidenew.data.network.model.GetMovieResponse;
import com.project.sizihatak.movieguidenew.data.network.model.GetTrailersResponse;

import io.reactivex.Single;

public interface DataManager {
    Single<GetMovieResponse> getMovies(int page);
    Single<GetTrailersResponse> getTrailers(String movieId);
}
