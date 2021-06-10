package com.example.myapplication.domain;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myapplication.InvalidDataException;

import java.time.LocalDateTime;

/**
 * MusicSession is used to store and process data(mood,intensity, activity and genre) when a
 * user chooses to perform a music session.
 */

public class MusicSession {
    private Mood mood;
    private Activity activity;
    private Intensity intensity;
    private Genre genre;
    Song song;
    LocalDateTime date;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public MusicSession(Song song){
        this.song = song;
        date = LocalDateTime.now();
    }

    public String getMood() {
        return Mood.getMoodAsString(mood);
    }

    public void setMood(Mood mood) throws InvalidDataException{
        if (Mood.getMoodAsString(mood).isEmpty()) {
            throw new InvalidDataException("Invalid mood");
        }
        this.mood = mood;
    }

    public String getActivity() {
        return Activity.getActivityAsString(activity);
    }

    public void setActivity(Activity activity) throws InvalidDataException{
        if (Activity.getActivityAsString(activity).isEmpty()) {
            throw new InvalidDataException("Invalid activity");
        }
        this.activity = activity;
    }

    public String getIntensity() {
        return Intensity.getIntensityAsString(intensity);
    }

    public void setIntensity(Intensity intensity) throws InvalidDataException{
        if (Intensity.getIntensityAsString(intensity).isEmpty()) {
            throw new InvalidDataException("Invalid intensity");
        }
        this.intensity = intensity;
    }

    public String getGenre() {
        return Genre.getGenreAsString(genre);
    }

    public void setGenre(Genre genre) throws InvalidDataException{
        if (Genre.getGenreAsString(genre).isEmpty()) {
            throw new InvalidDataException("Invalid mood");
        }
        this.genre = genre;
    }

    public Song getSong() {
        return song;
    }

}
