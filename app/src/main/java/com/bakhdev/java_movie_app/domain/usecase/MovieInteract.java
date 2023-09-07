package com.bakhdev.java_movie_app.domain.usecase;

import com.bakhdev.java_movie_app.domain.entity.Cast;
import com.bakhdev.java_movie_app.domain.entity.Movie;
import com.bakhdev.java_movie_app.domain.entity.MovieDetail;
import com.bakhdev.java_movie_app.domain.repository.MovieRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class MovieInteract implements MovieUseCase {

    private final MovieRepository movieRepository;

    @Inject
    public MovieInteract(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Observable<List<Movie>> getNowPlaying() {
        return movieRepository.getNowPlaying();
    }

    @Override
    public Observable<List<Movie>> getPopular() {
        return movieRepository.getPopular();
    }

    @Override
    public Observable<List<Movie>> getTopRated() {
        return movieRepository.getTopRated();
    }

    @Override
    public Observable<MovieDetail> getDetail(int id) {
        return movieRepository.getDetail(id);
    }

    @Override
    public Observable<List<Cast>> getCasts(int id) {
        return movieRepository.getCasts(id);
    }
}
