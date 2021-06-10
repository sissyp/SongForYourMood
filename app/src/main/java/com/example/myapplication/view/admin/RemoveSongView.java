package com.example.myapplication.view.admin;

import com.example.myapplication.domain.Song;

import java.util.List;

public interface RemoveSongView {

    void onFetchSongs(List<Song> songList);

    String getSongTitle();

    void setSongTitle(String title);

    void onSuccessRemove();

    void showEmptyOrWrongFieldsDetected();


}
