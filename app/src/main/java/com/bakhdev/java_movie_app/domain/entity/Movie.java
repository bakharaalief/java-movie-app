package com.bakhdev.java_movie_app.domain.entity;

public class Movie {

    private int id;
    private String posterPath;

    public Movie(int id, String posterPath) {
        this.id = id;
        this.posterPath = posterPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String id) {
        this.posterPath = posterPath;
    }
}
