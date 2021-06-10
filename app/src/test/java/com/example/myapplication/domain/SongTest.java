package com.example.myapplication.domain;

import com.example.myapplication.InvalidDataException;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class SongTest {
    Song song;

    @Before
    public void init(){
        Band bandaki = new Band("Aerosmith", 5, Genre.ROCK);
        song = new Song("Dream On", Genre.ROCK, 1973, bandaki,"http/jiernci",1);
    }

    @Test(expected = InvalidDataException.class)
    public void checkSetTitle() throws InvalidDataException {
        song.setTitle("Brick by Brick");
        assertEquals("Brick by Brick", song.getTitle());
        song.setTitle("");
        assertNull(song.getTitle());
    }

    @Test
    public void checkSetGenre() throws InvalidDataException {
        song = new Song("Heart Of Glass","http/uhceihnbq",8);
        song.setGenre(Genre.DISCO);
        assertEquals(Genre.DISCO, song.getGenre());
    }

    @Test(expected = InvalidDataException.class)
    public void checkSetProductionYear() throws InvalidDataException {
        song = new Song("Call Me","http/hncei03cbfine",15);
        song.setProductionYear(1980);
        assertEquals(1980, song.getProductionYear());
        song.setProductionYear(-1980);
    }

    @Test(expected = InvalidDataException.class)
    public void checkSetBand() throws InvalidDataException {
        song = new Song(14);
        Band LooneyTunesComposer = new Band("Carl W. Stalling", 1, Genre.CLASSICAL);
        song.setBand(LooneyTunesComposer);
        assertEquals(LooneyTunesComposer, song.getBand());
        Band Roadrunner = new Band("", 1, Genre.CLASSICAL);
        song.setBand(Roadrunner);
    }

    @Test
    public void checkSetDuration() {
        song = new Song("Wait A Minute","http/hr9cf983rhfr",16);
        String dur = "03:17";
        song.setDuration(dur);
        assertEquals(dur, song.getDuration());
    }
/*
    @Test
    public void checkCalculateStatisticsR() throws InvalidDataException {
        Band bandaki = new Band("Aerosmith", 5, Genre.ROCK);
        song = new Song("Dream On", Genre.ROCK, 1973, bandaki);
        SongRating rating = new SongRating(song);
        rating.setUserId(1);
        rating.setMood(Mood.HAPPY);
        rating.setActivity(Activity.HOBBY);
        rating.setIntensity(Intensity.MEDIUM);
        SongRating rating2 = new SongRating(song);
        rating2.setUserId(2);
        rating2.setMood(Mood.HAPPY);
        rating2.setActivity(Activity.HOBBY);
        rating2.setIntensity(Intensity.MEDIUM);
        ArrayList<SongRating> ratings = new ArrayList<SongRating>(Arrays.asList(rating, rating2));
        for (SongRating r: ratings)
            song.calculateStatisticsR(r);

        MusicSession session = new MusicSession(song);
        session.setUserId(3);
        session.setMood(Mood.HAPPY);
        session.setActivity(Activity.HOBBY);
        session.setIntensity(Intensity.MEDIUM);
        session.setGenre(Genre.ROCK);
        song.calculateStatisticsMS(session);
        HashMap<String, Integer> per = new HashMap<String, Integer>();
        per.put("HAPPY", 100);
        per.put("HOBBY", 100);
        per.put("MEDIUM", 100);
        Assert.assertEquals(per, Song.sortByValue(song.songStatistics()));
    }*/
}