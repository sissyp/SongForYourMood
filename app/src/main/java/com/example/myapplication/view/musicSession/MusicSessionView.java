package com.example.myapplication.view.musicSession;


import com.example.myapplication.domain.Song;

import java.util.List;

public interface MusicSessionView {

    void noSongsMatch();

    void onFetchSongs(List<Song> songList);
}
