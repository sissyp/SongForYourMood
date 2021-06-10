package com.example.myapplication.domain;



import com.example.myapplication.InvalidDataException;

import org.junit.Assert;
import org.junit.Test;


import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;



public class BandTest {



    @Test
    public void checkName() throws InvalidDataException {
        Band band = new Band();
        String bandName = "Queen";
        band.setName(bandName);
        Assert.assertEquals(bandName, band.getName());
    }




    @Test
    public void checkMembers() throws InvalidDataException{
        Band band = new Band();
        int bandMembers = 4;
        band.setMembers(bandMembers);
        Assert.assertEquals(bandMembers, band.getMembers());
    }




    @Test
    public void checkGenre() throws InvalidDataException{
        Band band = new Band();
        Genre bandGenre = Genre.ROCK;
        band.setGenre(bandGenre);
        Assert.assertEquals(bandGenre, band.getGenre());
    }




    @Test
    public void checkForSoloArtist() throws InvalidDataException{
        Band band = new Band("Freddie Mercury",1, Genre.ROCK);
        Assert.assertEquals(0, band.getMemberNames().size());
        Assert.assertTrue(band.checkForSoloArtist());
    }



    @Test
    public void checkMemberNames() throws InvalidDataException{
        Band band = new Band();
        ArrayList<String> memberNames = new java.util.ArrayList<String>(
                Arrays.asList("Freddie Mercury", "Brian May", "John Deacon", "Roger Taylor"));
        band.setMemberNames(memberNames);
        Assert.assertEquals(memberNames, band.getMemberNames());
    }



}