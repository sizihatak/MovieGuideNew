package com.project.sizihatak.movieguidenew.data.network;

import com.project.sizihatak.movieguidenew.BuildConfig;

public class ApiEndPoint {

    protected static final String END_POINT = BuildConfig.BASE_URL;
    protected static final String API_KEY = BuildConfig.API_KEY; // add your API key here
    protected static final String POSTER_END_POINT = "http://image.tmdb.org/t/p/w342"; // add your API key here
    protected static final String GET_MOVIES = "discover/movie?api_key=" + API_KEY;
    protected static final String GET_HIGHEST_RATED_MOVIES = "discover/movie?vote_count.gte=500&language=en&sort_by=vote_average.desc&api_key=" + API_KEY;

    protected static final String GET_THUMBNAIL_FOR_TRAILER = "https://img.youtube.com/vi/%s/0.jpg";

    protected static final String GET_TRAILERS = "movie/{id}/videos?api_key=" + API_KEY;
    protected static final String GET_REVIEWS = "movie/%s/reviews?api_key=" + API_KEY;

    protected static final String GET_VIDEO_FOR_TRAILER = "http://www.youtube.com/watch?v=%s";

    private ApiEndPoint() {
        // This class is not publicly instantiable
    }
}
