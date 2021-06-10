package com.example.myapplication.view.musicSession;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.domain.Song;
import com.example.myapplication.view.search.SearchableListAdapter;

import java.util.List;

public class MusicSessionListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    List<Song> data;
    Context context;

    public MusicSessionListAdapter(List<Song> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item_song, parent, false);
        return new MusicSessionListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        final Song song = data.get(position);
        MusicSessionListAdapter.ViewHolder customHolder = (MusicSessionListAdapter.ViewHolder) holder;

        TextView songTitleTV = customHolder.rootView.findViewById(R.id.song_title_tv);
        TextView songLinkTV = customHolder.rootView.findViewById(R.id.song_link_tv);

        songTitleTV.setText(song.getTitle());
        songLinkTV.setText(song.getLink());

        songTitleTV.setTextColor(Color.parseColor("#FFFFFF"));
        songLinkTV.setTextColor(Color.parseColor("#0000FF"));
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
