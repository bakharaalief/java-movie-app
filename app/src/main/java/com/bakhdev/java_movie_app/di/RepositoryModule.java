package com.bakhdev.java_movie_app.di;

import com.bakhdev.java_movie_app.data.MovieRepositoryImpl;
import com.bakhdev.java_movie_app.domain.repository.MovieRepository;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract MovieRepository provideMovieRepository(MovieRepositoryImpl movieRepositoryImpl);
}
