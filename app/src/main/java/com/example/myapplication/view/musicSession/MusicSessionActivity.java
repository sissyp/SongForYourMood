package com.example.myapplication.view.musicSession;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myapplication.App;
import com.example.myapplication.InvalidDataException;
import com.example.myapplication.R;
import com.example.myapplication.databinding.LayoutActivityMusicSessionBinding;
import com.example.myapplication.domain.Mood;
import com.example.myapplication.domain.MusicSession;
import com.example.myapplication.domain.Song;
import com.example.myapplication.view.search.SearchableListAdapter;

import java.util.List;

public class MusicSessionActivity extends AppCompatActivity implements MusicSessionView{
    LayoutActivityMusicSessionBinding binding;
    MusicSessionPresenter presenter;
    String mood;
    String genre;
    String intensity;
    String activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.layout_activity_music_session);
        presenter = new MusicSessionPresenter(this, App.memoryInitializer.getSongDAO());
        Bundle extras = getIntent().getExtras();
        mood = extras.getString("mood");
        genre = extras.getString("genre");
        intensity = extras.getString("intensity");
        activity = extras.getString("activity");

        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        binding.songRv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.loadAllSongs(mood,genre,intensity,activity);
    }

    @Override
    public void onFetchSongs(List<Song> songList) {
        binding.songRv.setAdapter(new MusicSessionListAdapter(songList, this));
    }

    @Override
    public void noSongsMatch() {
        String notFound = "No songs match your choices... ";
        binding.noSongsMatch.setText(notFound);
    }
}
