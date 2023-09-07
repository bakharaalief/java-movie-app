package com.bakhdev.java_movie_app.domain.entity;

public class Cast {

    private int castId;
    private String name;
    private String character;
    private String profilePath;

    public Cast(int castId, String name, String character, String profilePath) {
        this.castId = castId;
        this.name = name;
        this.character = character;
        this.profilePath = profilePath;
    }

    public int getCastId() {
        return castId;
    }

    public void setCastId(int castId) {
        this.castId = castId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }
}
