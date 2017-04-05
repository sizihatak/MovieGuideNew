package com.project.sizihatak.movieguidenew.data;

import com.project.sizihatak.movieguidenew.data.network.model.GetMovieResponse;

import io.reactivex.Single;

public interface DataManager {
    Single<GetMovieResponse> getMovies(int page);
}
