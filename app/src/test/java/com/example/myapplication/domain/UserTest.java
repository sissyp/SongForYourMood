package com.example.myapplication.domain;

import com.example.myapplication.InvalidDataException;
import com.example.myapplication.util.PasswordProtector;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class UserTest {

    User user;

    @Before
    public  void init(){
        user = new User();
    }

    @Test
    public void checkFirstName() throws InvalidDataException {
        String firstName = "Dora";
        user.setFirstName(firstName);
        Assert.assertEquals(firstName, user.getFirstName());
    }

    @Test
    public void checkLastName() throws InvalidDataException {
        String lastName = "Márquez";
        user.setLastName(lastName);
        Assert.assertEquals(lastName, user.getLastName());
    }

    @Test
    public void checkFullName() throws InvalidDataException {
        String firstName = "Dora";
        user.setFirstName(firstName);
        String lastName = "Márquez";
        user.setLastName(lastName);
        String message = "first name: Dora, last name: Márquez";
        Assert.assertEquals(message, user.getFullName());
    }

    @Test(expected = InvalidDataException.class)
    public void checkIncorrectMail() throws InvalidDataException {
        user.setMail("Dexter@Spackman");
    }

    @Test
    public void checkCorrectMail() throws InvalidDataException {
        user.setMail("BaxterStockman@yahoo.com");
    }

    @Test
    public void checkUserName() throws InvalidDataException {
        String username = "MasterSplinter";
        user.setUserName(username);
        Assert.assertEquals(username, user.getUserName());
    }

    @Test
    public void checkValidPassword() throws InvalidDataException {
        user.setPassword("888");
        Assert.assertEquals(PasswordProtector.md5("888"), user.getPassword());
    }

    @Test(expected = InvalidDataException.class)
    public void checkInvalidPassword() throws InvalidDataException {
        user.setPassword("");
    }

    @Test
    public void checkGenrePreference(){
        Genre[] genres = {Genre.JAZZ, Genre.ROCK};
        GenrePreference gp =  new GenrePreference(genres);
        user.setGenrePreference(gp);
        Assert.assertArrayEquals(genres, user.getGenrePreference());
    }

    @Test
    public void checkBandPreference(){
        Band[] bands = new Band[5];
        Band band1 = new Band("Nirvana",3,Genre.ROCK);
        bands[0] = band1;
        Band band2 = new Band("U2",4,Genre.ROCK);
        bands[1] = band2;
        BandPreference bp =  new BandPreference(bands);
        user.setBandPreference(bp);
        Assert.assertArrayEquals(bands, user.getBandPreference());
    }

}