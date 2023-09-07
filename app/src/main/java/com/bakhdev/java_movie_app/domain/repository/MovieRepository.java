package com.bakhdev.java_movie_app.domain.repository;

import com.bakhdev.java_movie_app.domain.entity.Cast;
import com.bakhdev.java_movie_app.domain.entity.Movie;
import com.bakhdev.java_movie_app.domain.entity.MovieDetail;

import java.util.List;

import io.reactivex.Observable;

public interface MovieRepository {

    Observable<List<Movie>> getNowPlaying();

    Observable<List<Movie>> getPopular();

    Observable<List<Movie>> getTopRated();

    Observable<MovieDetail> getDetail(int id);

    Observable<List<Cast>> getCasts(int id);
}
