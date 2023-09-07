package com.bakhdev.java_movie_app.Helper;

import com.bakhdev.java_movie_app.data.response.detail.DetailMovieResponse;
import com.bakhdev.java_movie_app.data.response.detail.GenresItem;
import com.bakhdev.java_movie_app.data.response.list.ListMovieResponse;
import com.bakhdev.java_movie_app.data.response.list.ResultsItem;
import com.bakhdev.java_movie_app.data.response.listCast.CastItem;
import com.bakhdev.java_movie_app.domain.entity.Cast;
import com.bakhdev.java_movie_app.domain.entity.Movie;
import com.bakhdev.java_movie_app.domain.entity.MovieDetail;
import com.bakhdev.java_movie_app.domain.entity.MovieGenre;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    public static ArrayList<Movie> listMovieResponseToListMovie(ListMovieResponse listMovieResponse) {
        ArrayList<Movie> listMovie = new ArrayList<Movie>();

        for (ResultsItem resultsItem : listMovieResponse.getResults()) {
            Movie movie = new Movie(
                    resultsItem.getId(),
                    resultsItem.getTitle(),
                    resultsItem.getOverview(),
                    resultsItem.getPosterPath(),
                    resultsItem.getPosterPath()
            );
            listMovie.add(movie);
        }

        return listMovie;
    }

    public static MovieDetail detailMovieResponseToMovieDetail(DetailMovieResponse detailMovieResponse) {
        return new MovieDetail(
                detailMovieResponse.getRuntime(),
                detailMovieResponse.getReleaseDate(),
                genreItemToListMovieGenre(detailMovieResponse.getGenres())
        );
    }

    public static ArrayList<MovieGenre> genreItemToListMovieGenre(List<GenresItem> listGenreItem) {
        ArrayList<MovieGenre> listGenreMovie = new ArrayList<MovieGenre>();

        for (GenresItem listGenre : listGenreItem) {
            MovieGenre movieGenre = new MovieGenre(
                    listGenre.getName(),
                    listGenre.getId());
            listGenreMovie.add(movieGenre);
        }

        return listGenreMovie;
    }

    public static ArrayList<Cast> listCastItemToListCast(List<CastItem> listCastItem) {
        ArrayList<Cast> listCast = new ArrayList<Cast>();

        for (CastItem castItem : listCastItem) {
            Cast cast = new Cast(
                    castItem.getCastId(),
                    castItem.getName(),
                    castItem.getCharacter(),
                    castItem.getProfilePath()
            );
            listCast.add(cast);
        }

        return listCast;
    }
}
