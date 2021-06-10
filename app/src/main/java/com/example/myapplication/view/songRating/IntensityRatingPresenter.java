package com.example.myapplication.view.songRating;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myapplication.InvalidDataException;
import com.example.myapplication.domain.Activity;
import com.example.myapplication.domain.Intensity;
import com.example.myapplication.domain.Mood;
import com.example.myapplication.domain.Song;
import com.example.myapplication.domain.SongRating;
import com.example.myapplication.memorydao.SongDAO;
import com.example.myapplication.memorydao.SongRatingDAO;

import java.util.List;


public class IntensityRatingPresenter {

    IntensityRatingView view;
    SongRatingDAO songRatingDAO;
    SongDAO songDAO;

    public IntensityRatingPresenter(IntensityRatingView view,SongDAO songDAO,SongRatingDAO songRatingDAO) {
        this.view = view;
        this.songDAO = songDAO;
        this.songRatingDAO = songRatingDAO;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onClickIntensityRating(String intensity, String song, String mood, String activity) throws InvalidDataException {
        addRating(intensity,song,mood,activity);
        view.handleIntensityRating();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void addRating(String intensity, String song, String mood, String activity) throws InvalidDataException {
        List<Song> allSongs = songDAO.findAll();
        for(Song s: allSongs){
            if(s.getTitle().equals(song)) {
                SongRating rating = new SongRating(s);
                rating.setMood(Mood.valueOf(mood.toUpperCase()));
                rating.setActivity(Activity.valueOf(activity.toUpperCase()));
                rating.setIntensity(Intensity.valueOf(intensity.toUpperCase()));
                songRatingDAO.save(rating);
            }
        }
    }


    void detach() {
        view = null;
    }
}
