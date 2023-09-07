package com.bakhdev.java_movie_app.presentation.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bakhdev.java_movie_app.Helper.Utils;
import com.bakhdev.java_movie_app.R;
import com.bakhdev.java_movie_app.databinding.ItemMovieBinding;
import com.bakhdev.java_movie_app.domain.entity.Movie;
import com.bumptech.glide.Glide;

public class MovieAdapter extends ListAdapter<Movie, MovieAdapter.ViewHolder> {

    private OnItemClickListener itemListener;

    public MovieAdapter() {
        super(MovieDiffCallback);
    }

    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMovieBinding binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int position) {
        Movie movie = getItem(position);
        holder.bind(movie);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemMovieBinding binding;

        ViewHolder(ItemMovieBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Movie movie) {
            Glide
                .with(itemView.getContext())
                .load(Utils.linkToShowImage(movie.getPosterPath()))
                .placeholder(R.drawable.ic_launcher_background)
                .centerCrop()
                .into(binding.imgMoviePoster);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (itemListener != null) {
                        itemListener.onItemClick(movie);
                    }
                }
            });
        }
    }

    public void setOnItemClickListener(OnItemClickListener itemListener) {
        this.itemListener = itemListener;
    }

    private static final DiffUtil.ItemCallback<Movie> MovieDiffCallback = new DiffUtil.ItemCallback<Movie>() {

        @Override
        public boolean areItemsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
            return oldItem.equals(newItem);
        }
    };
}




