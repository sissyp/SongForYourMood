package com.example.myapplication.view.statistics;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myapplication.App;
import com.example.myapplication.R;
import com.example.myapplication.databinding.LayoutActivityStatisticsBinding;
import com.example.myapplication.domain.Song;

import java.util.List;

public class StatisticsActivity extends AppCompatActivity implements StatisticsView {

    LayoutActivityStatisticsBinding binding;
    StatisticsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.layout_activity_statistics);
        presenter = new StatisticsPresenter(this, App.memoryInitializer.getSongDAO());

        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        binding.songRv.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    protected void onResume() {
        super.onResume();
        presenter.loadAllSongs();
    }

    @Override
    public void onFetchSongs(List<Song> songList) {
        binding.songRv.setAdapter(new StatisticsListAdapter(songList, this));
    }


}