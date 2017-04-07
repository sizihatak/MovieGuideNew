package com.project.sizihatak.movieguidenew.data.network;

import com.project.sizihatak.movieguidenew.data.network.model.GetMovieResponse;
import com.project.sizihatak.movieguidenew.data.network.model.GetTrailersResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static com.project.sizihatak.movieguidenew.data.network.ApiEndPoint.GET_MOVIES;
import static com.project.sizihatak.movieguidenew.data.network.ApiEndPoint.GET_TRAILERS;

public interface MovieGuideApi {

    String ACCEPT_JSON = "Accept: application/json";
    String TYPE_JSON = "Content-type: application/json";

    @Headers({TYPE_JSON, ACCEPT_JSON})
    @GET(GET_MOVIES)
    Single<GetMovieResponse> getMovies(@Query("page") int numPage);

    @Headers({TYPE_JSON, ACCEPT_JSON})
    @GET(GET_TRAILERS)
    Single<GetTrailersResponse> getTrailers(@Path("id") String movieId);
}
