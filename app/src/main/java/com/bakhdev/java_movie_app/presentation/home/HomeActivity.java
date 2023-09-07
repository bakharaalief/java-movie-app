package com.bakhdev.java_movie_app.presentation.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bakhdev.java_movie_app.base.BaseActivity;
import com.bakhdev.java_movie_app.databinding.ActivityHomeBinding;
import com.bakhdev.java_movie_app.domain.entity.Movie;
import com.bakhdev.java_movie_app.presentation.adapter.MovieAdapter;
import com.bakhdev.java_movie_app.presentation.adapter.OnItemClickListener;
import com.bakhdev.java_movie_app.presentation.detail.DetailActivity;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeActivity extends BaseActivity<ActivityHomeBinding> implements OnItemClickListener {

    private HomeViewModel viewModel;
    private MovieAdapter nowPlayingMovieAdapter;
    private MovieAdapter popularMovieAdapter;
    private MovieAdapter topRatedMovieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setUpAdapter();
        setUpViewModel();
        setUpNowPlayingMovie();
        setUpPopularMovie();
        setUpTopRatedMovie();
        getMovieData();
    }

    @Override
    protected ActivityHomeBinding setBinding() {
        return ActivityHomeBinding.inflate(getLayoutInflater());
    }

    private void setUpAdapter() {
        nowPlayingMovieAdapter = new MovieAdapter();
        nowPlayingMovieAdapter.setOnItemClickListener(this);
        binding.rvNowPlayingMovie.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.rvNowPlayingMovie.setAdapter(nowPlayingMovieAdapter);

        popularMovieAdapter = new MovieAdapter();
        popularMovieAdapter.setOnItemClickListener(this);
        binding.rvPopularMovie.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.rvPopularMovie.setAdapter(popularMovieAdapter);

        topRatedMovieAdapter = new MovieAdapter();
        topRatedMovieAdapter.setOnItemClickListener(this);
        binding.rvTopRatedMovie.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.rvTopRatedMovie.setAdapter(topRatedMovieAdapter);
    }

    @Override
    public void onItemClick(Movie movie) {
        Intent intent = new Intent(HomeActivity.this, DetailActivity.class);
        intent.putExtra(DetailActivity.MOVIE_EXTRA, movie);
        this.startActivity(intent);
    }

    private void setUpViewModel() {
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
    }

    private void setUpNowPlayingMovie() {
        viewModel.getIsLoadingNowPlayingMovie().observe(this, isLoading -> {
            if (isLoading) {
                binding.progressNowPlayingMovie.setVisibility(View.VISIBLE);
                binding.tvErrorNowPlayingMovie.setVisibility(View.GONE);
            } else {
                binding.progressNowPlayingMovie.setVisibility(View.GONE);
            }
        });

        viewModel.getIsErrorNowPlayingMovie().observe(this, isError -> {
            if (isError) {
                binding.tvErrorNowPlayingMovie.setVisibility(View.VISIBLE);
                binding.rvNowPlayingMovie.setVisibility(View.GONE);
            }
        });

        viewModel.getNowPlayingMovie().observe(this, listMovie -> {
            nowPlayingMovieAdapter.submitList(listMovie);
        });
    }

    private void setUpPopularMovie() {
        viewModel.getIsLoadingPopularMovie().observe(this, isLoading -> {
            if (isLoading) {
                binding.progressPopularMovie.setVisibility(View.VISIBLE);
                binding.tvErrorPopularMovie.setVisibility(View.GONE);
            } else {
                binding.progressPopularMovie.setVisibility(View.GONE);
            }
        });

        viewModel.getIsErrorPopularMovie().observe(this, isError -> {
            if (isError) {
                binding.tvErrorPopularMovie.setVisibility(View.VISIBLE);
                binding.rvPopularMovie.setVisibility(View.GONE);
            }
        });

        viewModel.getPopularMovie().observe(this, listMovie -> {
            popularMovieAdapter.submitList(listMovie);
        });
    }

    private void setUpTopRatedMovie() {
        viewModel.getIsLoadingTopRatedMovie().observe(this, isLoading -> {
            if (isLoading) {
                binding.progressTopRatedMovie.setVisibility(View.VISIBLE);
                binding.tvErrorTopRatedMovie.setVisibility(View.GONE);
            } else {
                binding.progressTopRatedMovie.setVisibility(View.GONE);
            }
        });

        viewModel.getIsErrorTopRatedMovie().observe(this, isError -> {
            if (isError) {
                binding.tvErrorTopRatedMovie.setVisibility(View.VISIBLE);
                binding.rvTopRatedMovie.setVisibility(View.GONE);
            }
        });

        viewModel.getTopRatedMovie().observe(this, listMovie -> {
            topRatedMovieAdapter.submitList(listMovie);
        });
    }

    private void getMovieData() {
        viewModel.getNowPlayingMovieData();
        viewModel.getPopularMovieData();
        viewModel.getTopRatedMovieData();
    }
}