package com.example.myapplication.util;

import com.example.myapplication.App;
import com.example.myapplication.InvalidDataException;
import com.example.myapplication.domain.Activity;
import com.example.myapplication.domain.Band;
import com.example.myapplication.domain.Genre;
import com.example.myapplication.domain.Intensity;
import com.example.myapplication.domain.Mood;
import com.example.myapplication.domain.Song;
import com.example.myapplication.domain.SongRating;
import com.example.myapplication.memorydao.MemoryInitializer;
import com.example.myapplication.memorydao.SongDAO;
import com.example.myapplication.memorydao.SongRatingDAO;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class StatisticsTest {

    @Test
    public void calculateRatings() throws InvalidDataException {

        MemoryInitializer memoryInitializer = new MemoryInitializer();
        try {
            memoryInitializer.prepareData();
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }

        Band bandaki3 = new Band("Blur", 4, Genre.POP);
        Song song = new Song("Girls And Boys", Genre.POP, 1994, bandaki3,"https://youtu.be/WDswiT87oo8",3);
        Statistics stats = new Statistics(song);

        SongRating rating = new SongRating(song);
        rating.setMood(Mood.HAPPY);
        rating.setActivity(Activity.HOBBY);
        rating.setIntensity(Intensity.MEDIUM);
        memoryInitializer.getSongRatingDAO().save(rating);

        SongRating rating2 = new SongRating(song);
        rating2.setMood(Mood.HAPPY);
        rating2.setActivity(Activity.HOBBY);
        rating2.setIntensity(Intensity.MEDIUM);
        memoryInitializer.getSongRatingDAO().save(rating2);

        SongRating rating3 = new SongRating(song);
        rating3.setMood(Mood.HAPPY);
        rating3.setActivity(Activity.PARTY);
        rating3.setIntensity(Intensity.MEDIUM);
        memoryInitializer.getSongRatingDAO().save(rating3);

        HashMap<String, Integer> per = new HashMap<String, Integer>();
        per.put("HAPPY", 83);
        per.put("HOBBY", 33);
        per.put("MEDIUM", 83);


        per = Statistics.sortByValue(per);
        Statistics.initialize();
        Assert.assertEquals(per, Statistics.sortByValue(stats.calculateRatings(memoryInitializer.getSongRatingDAO())));
    }
}