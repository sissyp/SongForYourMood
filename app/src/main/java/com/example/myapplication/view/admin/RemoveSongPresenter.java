package com.example.myapplication.view.admin;

import com.example.myapplication.domain.Song;
import com.example.myapplication.memorydao.SongDAO;


public class RemoveSongPresenter {

    RemoveSongView view;
    SongDAO songDAO;

    public RemoveSongPresenter(RemoveSongView view, SongDAO songDAO) {
        this.view = view;
        this.songDAO = songDAO;
    }

    public void loadAllSongs() {
        view.onFetchSongs(songDAO.findAll());
    }

    public void onRemoveSong() {

        if (songDAO.findSongTitle(view.getSongTitle()) != null) {
            Song songToBeRemoved = songDAO.findSongTitle(view.getSongTitle());
            songDAO.delete(songToBeRemoved.getSongId());
            view.onSuccessRemove();
        }
        else{
            view.showEmptyOrWrongFieldsDetected();
        }

    }
}
