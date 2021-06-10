package com.example.myapplication.view.statistics;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.App;
import com.example.myapplication.R;
import com.example.myapplication.domain.Activity;
import com.example.myapplication.domain.Genre;
import com.example.myapplication.domain.Intensity;
import com.example.myapplication.domain.Mood;
import com.example.myapplication.domain.Song;
import com.example.myapplication.util.Statistics;


import java.util.List;
import java.util.Map;

public class StatisticsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
        List<Song> data;
        Context context;

        public StatisticsListAdapter(List<Song> data, Context context) {
            this.data = data;
            this.context = context;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_item_song, parent, false);
            return new StatisticsListAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
            final Song song = data.get(position);
            StatisticsListAdapter.ViewHolder customHolder = (StatisticsListAdapter.ViewHolder) holder;

            TextView songTitleTV = customHolder.rootView.findViewById(R.id.song_title_tv);
            TextView songLinkTV = customHolder.rootView.findViewById(R.id.song_link_tv);
            TextView songMoodTV = customHolder.rootView.findViewById(R.id.mood_tv);
            TextView songActivityTV = customHolder.rootView.findViewById(R.id.activity_tv);
            TextView songGenreTV = customHolder.rootView.findViewById(R.id.genre_tv);
            TextView songIntensityTV = customHolder.rootView.findViewById(R.id.intensity_tv);

            songTitleTV.setText(song.getTitle());
            songLinkTV.setText(song.getLink());
            String genre = "GENRE: " + Genre.getGenreAsString(song.getGenre()).toUpperCase();
            songGenreTV.setText(genre);

            songTitleTV.setTextColor(Color.parseColor("#FFFFFF"));
            songLinkTV.setTextColor(Color.parseColor("#0000FF"));
            songGenreTV.setTextColor(Color.parseColor("#FFFFFF"));

            Statistics songStats = new Statistics(song);
            Statistics.initialize();

            for (Map.Entry<String,Integer> s: songStats.calculateRatings(App.memoryInitializer.getSongRatingDAO()).entrySet()){
                if (Mood.isAvailable(s.getKey().toLowerCase())){
                    String mood = s.getKey() + ": " + s.getValue() + "%";
                    songMoodTV.setText(mood);
                    songMoodTV.setTextColor(Color.parseColor("#FFFFFF"));
                }
                if (Activity.isAvailable(s.getKey().toLowerCase())){
                    String activity = s.getKey() + ": " + s.getValue() + "%";
                    songActivityTV.setText(activity);
                    songActivityTV.setTextColor(Color.parseColor("#FFFFFF"));
                }
                if (Intensity.isAvailable(s.getKey().toLowerCase())){
                    String intensity = s.getKey() + ": " + s.getValue() + "%";
                    songIntensityTV.setText(intensity);
                    songIntensityTV.setTextColor(Color.parseColor("#FFFFFF"));
                }
            }
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
