package com.example.myapplication.view.songRating;

import com.example.myapplication.domain.Genre;
import com.example.myapplication.domain.Song;
import com.example.myapplication.memorydao.SongDAO;

import java.util.List;

public class MoodRatingPresenter {

    MoodRatingView view;
    SongDAO songDAO;

    public MoodRatingPresenter(MoodRatingView view,SongDAO songDAO) {
        this.view = view;
        this.songDAO = songDAO;
    }

    public void onClickMoodRating(String mood) {
        view.handleMoodRating(mood);
    }

    public String findSongForElement(String element){
        List<Song> allSongs = songDAO.findAll();
        for(Song s : allSongs){
            if(s.getBand().getName().equals(element)){
                return s.getTitle();
            }
            else if(Genre.getGenreAsString(s.getGenre()).equals(element))
                return s.getTitle();
        }
        return "No song found for given element";

    }

    void detach() {
        view = null;
    }
}
