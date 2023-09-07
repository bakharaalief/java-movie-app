package com.bakhdev.java_movie_app.data;

import com.bakhdev.java_movie_app.data.response.detail.DetailMovieResponse;
import com.bakhdev.java_movie_app.data.response.list.ListMovieResponse;
import com.bakhdev.java_movie_app.data.response.listCast.ListCastResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApiService {

    @GET("movie/now_playing")
    Observable<ListMovieResponse> getNowPlaying(@Query("api_key") String apiKey);

    @GET("movie/popular")
    Observable<ListMovieResponse> getPopular(@Query("api_key") String apiKey);

    @GET("movie/top_rated")
    Observable<ListMovieResponse> getTopRated(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Observable<DetailMovieResponse> getDetail(
            @Path("id") int id,
            @Query("api_key") String apiKey
    );

    @GET("movie/{id}/casts")
    Observable<ListCastResponse> getCasts(
            @Path("id") int id,
            @Query("api_key") String apiKey
    );
}
