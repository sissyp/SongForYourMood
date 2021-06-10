package com.example.myapplication.view.statistics;
import com.example.myapplication.memorydao.SongDAO;


public class StatisticsPresenter {
    StatisticsView view;
    SongDAO songDAO;

    public StatisticsPresenter(StatisticsView view, SongDAO songDAO) {
        this.view = view;
        this.songDAO = songDAO;
    }

    public void loadAllSongs() {
        view.onFetchSongs(songDAO.findAll());
    }
}