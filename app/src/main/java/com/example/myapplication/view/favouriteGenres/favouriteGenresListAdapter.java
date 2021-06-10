package com.example.myapplication.view.favouriteGenres;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.domain.Genre;

import java.util.List;

public class favouriteGenresListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    List<Genre> data;
    Context context;

    public favouriteGenresListAdapter(List<Genre> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item_genre, parent, false);
        return new favouriteGenresListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        final Genre genre= data.get(position);
        favouriteGenresListAdapter.ViewHolder customHolder = (favouriteGenresListAdapter.ViewHolder) holder;

        TextView genreTitleTV = customHolder.rootView.findViewById(R.id.genre_tv);

        genreTitleTV.setText(Genre.getGenreAsString(genre));

        genreTitleTV.setTextColor(Color.parseColor("#FFFFFF"));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View rootView;

        public ViewHolder(View itemView) {
            super(itemView);
            rootView = itemView;
        }
    }
}
