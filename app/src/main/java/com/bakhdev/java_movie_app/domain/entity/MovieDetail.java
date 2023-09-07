package com.bakhdev.java_movie_app.domain.entity;

import com.bakhdev.java_movie_app.data.response.detail.GenresItem;

import java.util.List;

public class MovieDetail {

    private int runtime;
    private String releaseDate;
    private List<MovieGenre> genres;

    public MovieDetail(int runtime, String releaseDate, List<MovieGenre> genres){
        this.runtime = runtime;
        this.releaseDate = releaseDate;
        this.genres = genres;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<MovieGenre> getGenres() {
        return genres;
    }

    public void setGenres(List<MovieGenre> genres) {
        this.genres = genres;
    }
}
