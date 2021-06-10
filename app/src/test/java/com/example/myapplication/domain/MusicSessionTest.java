package com.example.myapplication.domain;



import com.example.myapplication.InvalidDataException;

import org.junit.Assert;
import org.junit.Test;



import static org.junit.Assert.*;



public class MusicSessionTest {




    @Test
    public void checkMood() throws InvalidDataException{
        Band bandaki = new Band("Aerosmith", 5, Genre.ROCK);
        Song song = new Song("Dream On", Genre.ROCK, 1973, bandaki,"hrubvucr",1);
        MusicSession ms = new MusicSession(song);
        Mood mood = Mood.HAPPY;
        ms.setMood(mood);
        Assert.assertEquals(Mood.getMoodAsString(mood), ms.getMood());
    }




    @Test
    public void checkActivity() throws InvalidDataException{
        Band bandaki = new Band("Aerosmith", 5, Genre.ROCK);
        Song song = new Song("Dream On", Genre.ROCK, 1973, bandaki,"hriewnv",1);
        MusicSession ms = new MusicSession(song);
        Activity activity = Activity.HOBBY;
        ms.setActivity(activity);
        Assert.assertEquals(Activity.getActivityAsString(activity), ms.getActivity());
    }





    @Test
    public void checkIntensity() throws InvalidDataException{
        Band bandaki = new Band("Aerosmith", 5, Genre.ROCK);
        Song song = new Song("Dream On", Genre.ROCK, 1973, bandaki,"ehncfinr",1);
        MusicSession ms = new MusicSession(song);
        Intensity intensity = Intensity.MEDIUM;
        ms.setIntensity(intensity);
        Assert.assertEquals(Intensity.getIntensityAsString(intensity), ms.getIntensity());
    }




    @Test
    public void checkGenre() throws InvalidDataException{
        Band bandaki = new Band("Aerosmith", 5, Genre.ROCK);
        Song song = new Song("Dream On", Genre.ROCK, 1973, bandaki,"rhif98hr",1);
        MusicSession ms = new MusicSession(song);
        Genre genre = Genre.POP;
        ms.setGenre(genre);
        Assert.assertEquals(Genre.getGenreAsString(genre), ms.getGenre());
    }
}