package com.bakhdev.java_movie_app.domain.repository;

import com.bakhdev.java_movie_app.domain.entity.Cast;
import com.bakhdev.java_movie_app.domain.entity.Movie;
import com.bakhdev.java_movie_app.domain.entity.MovieDetail;

import java.util.List;

import io.reactivex.Observable;

public interface MovieRepository {

    abstract Observable<List<Movie>> getNowPlaying();

    abstract Observable<List<Movie>> getPopular();

    abstract Observable<List<Movie>> getTopRated();

    abstract Observable<MovieDetail> getDetail(int id);

    abstract Observable<List<Cast>> getCasts(int id);
}
