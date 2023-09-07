package com.bakhdev.java_movie_app.Helper;

import com.bakhdev.java_movie_app.domain.entity.MovieGenre;

import java.util.List;

public class Utils {

    public static String linkToShowImage(String path) {
        String imagePath = "https://image.tmdb.org/t/p/w500";
        return imagePath + path;
    }

    public static String getReleaseYear(String year) {
        //just get year from movie
        return year.substring(0, 4);
    }

    public static String getGenres(List<MovieGenre> movieGenres) {
        StringBuilder genre = new StringBuilder();

        //when genre not empty
        if (!movieGenres.isEmpty()) {
            for (int i = 0; i < movieGenres.size(); i++) {
                //just get 2 genres from each movie
                if (movieGenres.size() > 2) {
                    if (i == 1) {
                        genre.append(movieGenres.get(i).getName());
                        break;
                    } else {
                        genre.append(movieGenres.get(i).getName()).append(", ");
                    }
                }

                //when genres under 2
                else genre.append(movieGenres.get(i).getName());
            }

            return genre.toString();
        }

        //when genre is empty
        return "";
    }

    public static String getRuntime(int runtime) {
        int hours = runtime / 60;
        int minutes = runtime % 60;

        return hours + "h " + minutes + "m";
    }
}
