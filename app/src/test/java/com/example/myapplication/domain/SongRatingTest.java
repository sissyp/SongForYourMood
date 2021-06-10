package com.example.myapplication.domain;

import com.example.myapplication.InvalidDataException;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SongRatingTest {

    @Test
    public void checkMood() throws InvalidDataException {
        Band bandaki = new Band("Aerosmith", 5, Genre.ROCK);
        Song song = new Song("Dream On", Genre.ROCK, 1973, bandaki,"rjvgh",1);
        SongRating ms = new SongRating(song);
        Mood mood = Mood.HAPPY;
        ms.setMood(mood);
        Assert.assertEquals(Mood.getMoodAsString(mood), ms.getMood());
    }

    @Test
    public void checkActivity() throws InvalidDataException{
        Band bandaki = new Band("Aerosmith", 5, Genre.ROCK);
        Song song = new Song("Dream On", Genre.ROCK, 1973, bandaki,"ehfi4hf",1);
        SongRating ms = new SongRating(song);
        Activity activity = Activity.HOBBY;
        ms.setActivity(activity);
        Assert.assertEquals(Activity.getActivityAsString(activity), ms.getActivity());
    }

    @Test
    public void checkIntensity() throws InvalidDataException{
        Band bandaki = new Band("Aerosmith", 5, Genre.ROCK);
        Song song = new Song("Dream On", Genre.ROCK, 1973, bandaki,"hrf8rih",1);
        SongRating ms = new SongRating(song);
        Intensity intensity = Intensity.MEDIUM;
        ms.setIntensity(intensity);
        Assert.assertEquals(Intensity.getIntensityAsString(intensity), ms.getIntensity());
    }
}