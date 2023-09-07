package com.bakhdev.java_movie_app.domain.entity;

public class MovieGenre {
    private String name;
    private int id;

    public MovieGenre(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
