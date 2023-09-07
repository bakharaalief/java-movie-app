package com.bakhdev.java_movie_app.presentation.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bakhdev.java_movie_app.Helper.Utils;
import com.bakhdev.java_movie_app.R;
import com.bakhdev.java_movie_app.databinding.ItemCastBinding;
import com.bakhdev.java_movie_app.domain.entity.Cast;
import com.bumptech.glide.Glide;

public class CastAdapter extends ListAdapter<Cast, CastAdapter.ViewHolder> {

    public CastAdapter() {
        super(CastDiffCallback);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCastBinding binding = ItemCastBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Cast cast = getItem(position);
        holder.bind(cast);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemCastBinding binding;

        ViewHolder(ItemCastBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Cast cast) {
            binding.tvCastName.setText(cast.getName());
            binding.tvCastCharacter.setText(cast.getCharacter());
            Glide
                    .with(itemView.getContext())
                    .load(Utils.linkToShowImage(cast.getProfilePath()))
                    .placeholder(R.drawable.ic_launcher_background)
                    .centerCrop()
                    .into(binding.imgCastPhoto);
        }
    }

    private static final DiffUtil.ItemCallback<Cast> CastDiffCallback = new DiffUtil.ItemCallback<Cast>() {

        @Override
        public boolean areItemsTheSame(@NonNull Cast oldItem, @NonNull Cast newItem) {
            return oldItem.getCastId() == newItem.getCastId();
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull Cast oldItem, @NonNull Cast newItem) {
            return oldItem.equals(newItem);
        }
    };
}
