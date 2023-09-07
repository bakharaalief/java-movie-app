package com.bakhdev.java_movie_app.data;

import com.bakhdev.java_movie_app.BuildConfig;
import com.bakhdev.java_movie_app.Helper.Mapper;
import com.bakhdev.java_movie_app.data.response.detail.DetailMovieResponse;
import com.bakhdev.java_movie_app.data.response.list.ListMovieResponse;
import com.bakhdev.java_movie_app.data.response.listCast.ListCastResponse;
import com.bakhdev.java_movie_app.domain.entity.Cast;
import com.bakhdev.java_movie_app.domain.entity.Movie;
import com.bakhdev.java_movie_app.domain.entity.MovieDetail;
import com.bakhdev.java_movie_app.domain.repository.MovieRepository;

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
                             return Mapper.listMovieResponseToListMovie(listMovieResponse);
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
                             return Mapper.listMovieResponseToListMovie(listMovieResponse);
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
                             return Mapper.listMovieResponseToListMovie(listMovieResponse);
                         }
                     }
                );
    }

    @Override
    public Observable<MovieDetail> getDetail(int id) {
        return movieApiService.getDetail(id, BuildConfig.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<DetailMovieResponse, MovieDetail>() {
                    @Override
                    public MovieDetail apply(DetailMovieResponse detailMovieResponse) throws Exception {
                        return Mapper.detailMovieResponseToMovieDetail(detailMovieResponse);
                    }
                });
    }

    @Override
    public Observable<List<Cast>> getCasts(int id) {
        return movieApiService.getCasts(id, BuildConfig.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<ListCastResponse, List<Cast>>() {
                    @Override
                    public List<Cast> apply(ListCastResponse listCastResponse) throws Exception {
                        return Mapper.listCastItemToListCast(listCastResponse.getCast());
                    }
                });
    }
}
