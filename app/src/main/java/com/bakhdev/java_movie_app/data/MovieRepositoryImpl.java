package com.bakhdev.java_movie_app.data;

import com.bakhdev.java_movie_app.BuildConfig;
import com.bakhdev.java_movie_app.data.response.list.ListMovieResponse;
import com.bakhdev.java_movie_app.data.response.list.ResultsItem;
import com.bakhdev.java_movie_app.domain.entity.Movie;
import com.bakhdev.java_movie_app.domain.repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MovieRepositoryImpl implements MovieRepository {

    private final MovieApiService movieApiService;

    @Inject
    public MovieRepositoryImpl(MovieApiService movieApiService) {
        this.movieApiService = movieApiService;
    }

    @Override
    public Observable<List<Movie>> getNowPlaying() {
        return movieApiService.getNowPlaying(BuildConfig.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<ListMovieResponse, List<Movie>>() {
                         @Override
                         public List<Movie> apply(ListMovieResponse listMovieResponse) throws Exception {
                             ArrayList<Movie> listMovie = new ArrayList<>();

                             for (ResultsItem resultsItem : listMovieResponse.getResults()) {
                                 Movie movie = new Movie(resultsItem.getId(), resultsItem.getPosterPath());
                                 listMovie.add(movie);
                             }

                             return listMovie;
                         }
                     }
                );
    }

    @Override
    public Observable<List<Movie>> getPopular() {
        return movieApiService.getPopular(BuildConfig.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<ListMovieResponse, List<Movie>>() {
                         @Override
                         public List<Movie> apply(ListMovieResponse listMovieResponse) throws Exception {
                             ArrayList<Movie> listMovie = new ArrayList<Movie>();

                             for (ResultsItem resultsItem : listMovieResponse.getResults()) {
                                 Movie movie = new Movie(resultsItem.getId(), resultsItem.getPosterPath());
                                 listMovie.add(movie);
                             }

                             return listMovie;
                         }
                     }
                );
    }

    @Override
    public Observable<List<Movie>> getTopRated() {
        return movieApiService.getTopRated(BuildConfig.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<ListMovieResponse, List<Movie>>() {
                         @Override
                         public List<Movie> apply(ListMovieResponse listMovieResponse) throws Exception {
                             ArrayList<Movie> listMovie = new ArrayList<Movie>();

                             for (ResultsItem resultsItem : listMovieResponse.getResults()) {
                                 Movie movie = new Movie(resultsItem.getId(), resultsItem.getPosterPath());
                                 listMovie.add(movie);
                             }

                             return listMovie;
                         }
                     }
                );
    }
}
