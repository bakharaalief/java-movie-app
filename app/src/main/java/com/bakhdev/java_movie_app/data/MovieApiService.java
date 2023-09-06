package com.bakhdev.java_movie_app.data;

import com.bakhdev.java_movie_app.data.response.list.ListMovieResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApiService {

    @GET("movie/now_playing")
    abstract Observable<ListMovieResponse> getNowPlaying(@Query("api_key") String apiKey);

    @GET("movie/popular")
    abstract Observable<ListMovieResponse> getPopular(@Query("api_key") String apiKey);

    @GET("movie/top_rated")
    abstract Observable<ListMovieResponse> getTopRated(@Query("api_key") String apiKey);
}
