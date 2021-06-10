package com.example.myapplication.domain;
import com.example.myapplication.InvalidDataException;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;



public class GenrePreferenceTest {



    @Test (expected = InvalidDataException.class)
    public void addFailed() throws InvalidDataException{

        Genre[] genres = new Genre[5];
        Genre genre1 = Genre.ROCK;
        genres[0] = genre1;
        Genre genre2 = Genre.JAZZ;
        genres[1] = genre2;
        Genre genre3 = Genre.POP;
        genres[2] = genre3;
        Genre genre4 = Genre.RAP;
        genres[3] = genre4;
        Genre genre5 = Genre.DISCO;
        genres[4] = genre5;

        GenrePreference genrepreference = new GenrePreference(genres);

        Assert.assertEquals(-1, genrepreference.findEmptyCellIndex());
        Genre genre6 = Genre.CLASSICAL;
        genrepreference.add(genre6);

    }



    @Test
    public void add() throws InvalidDataException {
        Genre[] genres = new Genre[5];
        Genre genre1 = Genre.ROCK;
        genres[0] = genre1;
        Genre genre2 = Genre.JAZZ;
        genres[1] = genre2;

        GenrePreference genrepreference = new GenrePreference(genres);

        Assert.assertEquals(2, genrepreference.findEmptyCellIndex());
        Genre genre3 = Genre.CLASSICAL;
        genrepreference.add(genre3);
    }
}