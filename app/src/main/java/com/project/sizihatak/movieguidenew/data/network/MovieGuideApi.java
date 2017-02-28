package com.project.sizihatak.movieguidenew.data.network;

import retrofit2.http.GET;
import retrofit2.http.Headers;

import static com.project.sizihatak.movieguidenew.data.network.ApiEndPoint.GET_POPULAR_MOVIES;

interface MovieGuideApi {

    static final String ACCEPT_JSON = "Accept: application/json";
    static final String TYPE_JSON = "Content-type: application/json";

    @Headers({TYPE_JSON, ACCEPT_JSON})
    @GET(GET_POPULAR_MOVIES)
    Object profile();
}
