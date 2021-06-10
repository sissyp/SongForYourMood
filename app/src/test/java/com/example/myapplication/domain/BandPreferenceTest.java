package com.example.myapplication.domain;
import com.example.myapplication.InvalidDataException;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;



public class BandPreferenceTest {



    @Test (expected = InvalidDataException.class)
    public void addFailed() throws InvalidDataException{

        Band[] bands = new Band[5];
        Band band1 = new Band("Nirvana",3,Genre.ROCK);
        bands[0] = band1;
        Band band2 = new Band("U2",4,Genre.ROCK);
        bands[1] = band2;
        Band band3 = new Band("Red Hot Chili Peppers",4,Genre.ROCK);
        bands[2] = band3;
        Band band4 = new Band("Linkin Park",6,Genre.ROCK);
        bands[3] = band4;
        Band band5 = new Band("Aerosmith",5,Genre.ROCK);
        bands[4] = band5;

        BandPreference bandpreference = new BandPreference(bands);

        Assert.assertEquals(-1, BandPreference.findEmptyCellIndex());
        Band band6 = new Band("R.E.M",4,Genre.ROCK);
        bandpreference.add(band6);

    }



    @Test
    public void add() throws InvalidDataException {
        Band[] bands = new Band[5];
        Band band1 = new Band("Nirvana",3,Genre.ROCK);
        bands[0] = band1;
        Band band2 = new Band("U2",4,Genre.ROCK);
        bands[1] = band2;
        BandPreference bandpreference = new BandPreference(bands);

        Assert.assertEquals(2, BandPreference.findEmptyCellIndex());
        Band band3 = new Band("R.E.M",4,Genre.ROCK);
        bandpreference.add(band3);
    }
}