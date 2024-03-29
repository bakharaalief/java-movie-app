package com.bakhdev.java_movie_app.data.response.detail;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailMovieResponse {

    @SerializedName("overview")
    private String overview;

    @SerializedName("original_language")
    private String originalLanguage;

    @SerializedName("original_title")
    private String originalTitle;

    @SerializedName("imdb_id")
    private String imdbId;

    @SerializedName("runtime")
    private int runtime;

    @SerializedName("video")
    private boolean video;

    @SerializedName("title")
    private String title;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("backdrop_path")
    private String backdropPath;

    @SerializedName("revenue")
    private int revenue;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("genres")
    private List<GenresItem> genres;

    @SerializedName("popularity")
    private Object popularity;

    @SerializedName("vote_average")
    private Object voteAverage;

    @SerializedName("belongs_to_collection")
    private Object belongsToCollection;

    @SerializedName("tagline")
    private String tagline;

    @SerializedName("id")
    private int id;

    @SerializedName("adult")
    private boolean adult;

    @SerializedName("vote_count")
    private int voteCount;

    @SerializedName("budget")
    private int budget;

    @SerializedName("homepage")
    private String homepage;

    @SerializedName("status")
    private String status;

    public String getOverview() {
        return overview;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getImdbId() {
        return imdbId;
    }

    public int getRuntime() {
        return runtime;
    }

    public boolean isVideo() {
        return video;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public int getRevenue() {
        return revenue;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public List<GenresItem> getGenres() {
        return genres;
    }

    public Object getPopularity() {
        return popularity;
    }

    public Object getVoteAverage() {
        return voteAverage;
    }

    public Object getBelongsToCollection() {
        return belongsToCollection;
    }

    public String getTagline() {
        return tagline;
    }

    public int getId() {
        return id;
    }

    public boolean isAdult() {
        return adult;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public int getBudget() {
        return budget;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getStatus() {
        return status;
    }
}