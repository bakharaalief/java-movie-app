package com.bakhdev.java_movie_app.di;

import com.bakhdev.java_movie_app.domain.usecase.MovieInteract;
import com.bakhdev.java_movie_app.domain.usecase.MovieUseCase;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.scopes.ViewModelScoped;

@Module
@InstallIn(ViewModelComponent.class)
public abstract class AppModule {

    @ViewModelScoped
    @Binds
    abstract MovieUseCase provideMovieUseCase(MovieInteract movieInteract);
}
