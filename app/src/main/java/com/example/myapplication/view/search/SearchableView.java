package com.example.myapplication.view.search;

import com.example.myapplication.domain.Song;

import java.util.List;

public interface SearchableView {
    void onFetchSongs(List<Song> songList);


    void noResultsFound();

}