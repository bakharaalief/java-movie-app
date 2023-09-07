package com.bakhdev.java_movie_app.presentation.detail;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bakhdev.java_movie_app.Helper.Utils;
import com.bakhdev.java_movie_app.R;
import com.bakhdev.java_movie_app.base.BaseActivity;
import com.bakhdev.java_movie_app.databinding.ActivityDetailBinding;
import com.bakhdev.java_movie_app.domain.entity.Movie;
import com.bakhdev.java_movie_app.presentation.adapter.CastAdapter;
import com.bumptech.glide.Glide;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class DetailActivity extends BaseActivity<ActivityDetailBinding> {

    public static String MOVIE_EXTRA = "MOVIE_EXTRA";
    private Movie movie;
    private DetailViewModel viewModel;
    private CastAdapter castAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getIntentData();
        setTopAppBarInfo();
        setUpViewModel();
        setUpMovieDetail();
        getMovieDetailData();
        setPlayButton();
        setOverviewDetail();
        setUpAdapter();
        setUpListCast();
        getListCastData();
    }

    @Override
    protected ActivityDetailBinding setBinding() {
        return ActivityDetailBinding.inflate(getLayoutInflater());
    }

    private void getIntentData() {
        if (this.getIntent() != null) {
            movie = getIntent().getParcelableExtra(MOVIE_EXTRA, Movie.class);
        }
    }

    private void setTopAppBarInfo() {
        setSupportActionBar(binding.topAppBar);

        if (movie != null) {
            binding.topAppBar.setTitle(movie.getTitle());
            binding.tvMovieTitle.setText(movie.getTitle());

            Glide.with(this)
                    .load(Utils.linkToShowImage(movie.getBackdropPath()))
                    .placeholder(R.drawable.ic_launcher_background)
                    .centerCrop()
                    .into(binding.imgMovieBackdrop);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setUpViewModel() {
        viewModel = new ViewModelProvider(this).get(DetailViewModel.class);
    }

    private void setUpMovieDetail() {
        viewModel.getIsLoadingMovieDetail().observe(this, isLoading -> {
            if (isLoading) {
                binding.progressMovieReleaseGenreRuntime.setVisibility(View.VISIBLE);
                binding.tvErrorMovieReleaseGenreRuntime.setVisibility(View.GONE);
                binding.tvMovieReleaseGenreRuntime.setVisibility(View.GONE);
            } else {
                binding.progressMovieReleaseGenreRuntime.setVisibility(View.GONE);
                binding.tvMovieReleaseGenreRuntime.setVisibility(View.VISIBLE);
            }
        });

        viewModel.getIsErrorMovieDetail().observe(this, isError -> {
            if (isError) {
                binding.tvErrorMovieReleaseGenreRuntime.setVisibility(View.VISIBLE);
                binding.tvMovieReleaseGenreRuntime.setVisibility(View.GONE);
            }
        });

        viewModel.getMovieDetail().observe(this, movie -> {
            String year = Utils.getReleaseYear(movie.getReleaseDate());
            String genres = Utils.getGenres(movie.getGenres());
            String runtime = Utils.getRuntime(movie.getRuntime());
            String combine = year + " • " + genres + " • " + runtime;

            binding.tvMovieReleaseGenreRuntime.setText(combine);
        });
    }

    private void getMovieDetailData() {
        if (movie != null) {
            viewModel.getMovieDetailData(movie.getId());
        }
    }

    private void setPlayButton() {
        binding.btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = new Toast(DetailActivity.this);
                toast.setText("Ini Hanya dummy");
                toast.show();
            }
        });
    }

    private void setOverviewDetail() {
        if (movie != null) {
            binding.tvOverviewDetail.setText(movie.getOverview());
        }
    }

    private void setUpAdapter() {
        castAdapter = new CastAdapter();
        binding.rvCast.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.rvCast.setAdapter(castAdapter);
    }

    private void setUpListCast() {
        viewModel.getIsLoadingListCast().observe(this, isLoading -> {
            if (isLoading) {
                binding.progressCast.setVisibility(View.VISIBLE);
                binding.tvErrorCast.setVisibility(View.GONE);
            } else {
                binding.progressCast.setVisibility(View.GONE);
            }
        });

        viewModel.getIsErrorListCast().observe(this, isError -> {
            if (isError) {
                binding.tvErrorCast.setVisibility(View.VISIBLE);
                binding.rvCast.setVisibility(View.GONE);
            }
        });

        viewModel.getListCast().observe(this, listMovie -> {
            castAdapter.submitList(listMovie);
        });
    }

    private void getListCastData() {
        if (movie != null) {
            viewModel.getListCastData(movie.getId());
        }
    }
}