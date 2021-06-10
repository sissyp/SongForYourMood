package com.example.myapplication.view.statistics;

import com.example.myapplication.domain.Song;

import java.util.List;

public interface StatisticsView {
    void onFetchSongs(List<Song> songList);

}