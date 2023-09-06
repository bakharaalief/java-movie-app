package com.bakhdev.java_movie_app.presentation.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bakhdev.java_movie_app.domain.entity.Movie;
import com.bakhdev.java_movie_app.domain.usecase.MovieUseCase;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.disposables.CompositeDisposable;

@HiltViewModel
public class HomeViewModel extends ViewModel {

    private final MovieUseCase movieUseCase;

    private final CompositeDisposable disposables = new CompositeDisposable();

    private final MutableLiveData<Boolean> isLoadingNowPlayingMovie = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isLoadingPopularMovie = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isLoadingTopRatedMovie = new MutableLiveData<>();

    private final MutableLiveData<Boolean> isErrorNowPlayingMovie = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isErrorPopularMovie = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isErrorTopRatedMovie = new MutableLiveData<>();

    private final MutableLiveData<List<Movie>> nowPlayingMovie = new MutableLiveData<>();
    private final MutableLiveData<List<Movie>> popularMovie = new MutableLiveData<>();
    private final MutableLiveData<List<Movie>> topRatedMovie = new MutableLiveData<>();

    @Inject
    public HomeViewModel(MovieUseCase movieUseCase) {
        this.movieUseCase = movieUseCase;
    }

    public LiveData<Boolean> getIsLoadingNowPlayingMovie() {
        return isLoadingNowPlayingMovie;
    }

    public LiveData<Boolean> getIsLoadingPopularMovie() {
        return isLoadingPopularMovie;
    }

    public LiveData<Boolean> getIsLoadingTopRatedMovie() {
        return isLoadingTopRatedMovie;
    }

    public LiveData<Boolean> getIsErrorNowPlayingMovie() {
        return isErrorNowPlayingMovie;
    }

    public LiveData<Boolean> getIsErrorPopularMovie() {
        return isErrorPopularMovie;
    }

    public LiveData<Boolean> getIsErrorTopRatedMovie() {
        return isErrorTopRatedMovie;
    }

    public LiveData<List<Movie>> getNowPlayingMovie() {
        return nowPlayingMovie;
    }

    public LiveData<List<Movie>> getPopularMovie() {
        return popularMovie;
    }

    public LiveData<List<Movie>> getTopRatedMovie() {
        return topRatedMovie;
    }

    public void getNowPlayingMovieData() {
        isLoadingNowPlayingMovie.setValue(true);
        isErrorNowPlayingMovie.setValue(false);

        disposables.add(movieUseCase.getNowPlaying().subscribe(listMovie -> {
            isLoadingNowPlayingMovie.setValue(false);
            isErrorNowPlayingMovie.setValue(false);
            nowPlayingMovie.setValue(listMovie);
        }, throwable -> {
            isLoadingNowPlayingMovie.setValue(false);
            isErrorNowPlayingMovie.setValue(true);
        }));
    }

    public void getPopularMovieData() {
        isLoadingPopularMovie.setValue(true);
        isErrorPopularMovie.setValue(false);

        disposables.add(movieUseCase.getPopular().subscribe(listMovie -> {
            isLoadingPopularMovie.setValue(false);
            isErrorPopularMovie.setValue(false);
            popularMovie.setValue(listMovie);
        }, throwable -> {
            isLoadingPopularMovie.setValue(false);
            isErrorPopularMovie.setValue(true);
        }));
    }

    public void getTopRatedMovieData() {
        isLoadingTopRatedMovie.setValue(true);
        isErrorTopRatedMovie.setValue(false);

        disposables.add(movieUseCase.getTopRated().subscribe(listMovie -> {
            isLoadingTopRatedMovie.setValue(false);
            isErrorTopRatedMovie.setValue(false);
            topRatedMovie.setValue(listMovie);
        }, throwable -> {
            isLoadingTopRatedMovie.setValue(false);
            isErrorTopRatedMovie.setValue(true);
        }));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.clear();
    }
}
