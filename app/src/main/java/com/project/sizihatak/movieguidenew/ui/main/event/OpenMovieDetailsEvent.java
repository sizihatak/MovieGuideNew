package com.project.sizihatak.movieguidenew.ui.main.event;

import com.project.sizihatak.movieguidenew.data.network.model.Movie;

public class OpenMovieDetailsEvent {
    private Movie movie;

    public OpenMovieDetailsEvent(Movie movie) {
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }
}
