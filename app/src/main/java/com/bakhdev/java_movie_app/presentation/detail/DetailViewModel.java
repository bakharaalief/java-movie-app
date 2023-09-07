package com.bakhdev.java_movie_app.presentation.detail;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bakhdev.java_movie_app.domain.entity.Cast;
import com.bakhdev.java_movie_app.domain.entity.MovieDetail;
import com.bakhdev.java_movie_app.domain.usecase.MovieUseCase;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.disposables.CompositeDisposable;

@HiltViewModel
public class DetailViewModel extends ViewModel {

    private final MovieUseCase movieUseCase;

    private final CompositeDisposable disposables = new CompositeDisposable();

    private final MutableLiveData<Boolean> isLoadingMovieDetail = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isLoadingListCast = new MutableLiveData<>();

    private final MutableLiveData<Boolean> isErrorMovieDetail = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isErrorListCast = new MutableLiveData<>();

    private final MutableLiveData<MovieDetail> movieDetail = new MutableLiveData<>();
    private final MutableLiveData<List<Cast>> listCast = new MutableLiveData<>();

    @Inject
    public DetailViewModel(MovieUseCase movieUseCase) {
        this.movieUseCase = movieUseCase;
    }

    public MutableLiveData<Boolean> getIsLoadingMovieDetail() {
        return isLoadingMovieDetail;
    }

    public MutableLiveData<Boolean> getIsLoadingListCast() {
        return isLoadingListCast;
    }

    public MutableLiveData<Boolean> getIsErrorMovieDetail() {
        return isErrorMovieDetail;
    }

    public MutableLiveData<Boolean> getIsErrorListCast() {
        return isErrorListCast;
    }

    public MutableLiveData<MovieDetail> getMovieDetail() {
        return movieDetail;
    }

    public MutableLiveData<List<Cast>> getListCast() {
        return listCast;
    }

    public void getMovieDetailData(int id) {
        isLoadingMovieDetail.setValue(true);
        isErrorMovieDetail.setValue(false);

        disposables.add(movieUseCase.getDetail(id).subscribe(movie -> {
            isLoadingMovieDetail.setValue(false);
            isErrorMovieDetail.setValue(false);
            movieDetail.setValue(movie);
        }, throwable -> {
            isLoadingMovieDetail.setValue(false);
            isErrorMovieDetail.setValue(true);
        }));
    }

    public void getListCastData(int id) {
        isLoadingListCast.setValue(true);
        isErrorListCast.setValue(false);

        disposables.add(movieUseCase.getCasts(id).subscribe(casts -> {
            isLoadingListCast.setValue(false);
            isErrorListCast.setValue(false);
            listCast.setValue(casts);
        }, throwable -> {
            isLoadingListCast.setValue(false);
            isErrorListCast.setValue(true);
        }));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.clear();
    }
}
