package com.project.sizihatak.movieguidenew.data.network;

import com.project.sizihatak.movieguidenew.BuildConfig;

public class ApiEndPoint {

    public static final String END_POINT = BuildConfig.BASE_URL;
    public static final String API_KEY = BuildConfig.API_KEY; // add your API key here
    public static final String GET_POPULAR_MOVIES = "discover/movie?language=en&sort_by=popularity.desc&api_key=" + API_KEY;
    public static final String GET_HIGHEST_RATED_MOVIES = "discover/movie?vote_count.gte=500&language=en&sort_by=vote_average.desc&api_key=" + API_KEY;
    public static final String GET_TRAILERS = "movie/%s/videos?api_key=" + API_KEY;
    public static final String GET_REVIEWS = "movie/%s/reviews?api_key=" + API_KEY;

    private ApiEndPoint() {
        // This class is not publicly instantiable
    }
}
