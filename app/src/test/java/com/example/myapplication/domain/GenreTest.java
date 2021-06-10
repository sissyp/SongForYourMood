package com.example.myapplication.domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class GenreTest {

    @Test
    public void checkValidGenre() {
        String genre = "disco";
        Assert.assertTrue(Genre.isAvailable(genre));
    }

    @Test
    public void checkInvalidGenre() {
        String genre = "lol";
        Assert.assertFalse(Genre.isAvailable(genre));
    }

    @Test
    public void checkAvailableGenres() {
        Genre[] genres = {Genre.JAZZ, Genre.ROCK, Genre.POP, Genre.DISCO, Genre.RAP, Genre.CLASSICAL};
        Assert.assertArrayEquals(genres, Genre.getAvailableGenres());
    }
}