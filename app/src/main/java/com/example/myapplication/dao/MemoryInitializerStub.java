package com.example.myapplication.dao;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myapplication.InvalidDataException;
import com.example.myapplication.domain.Activity;
import com.example.myapplication.domain.Band;
import com.example.myapplication.domain.BandPreference;
import com.example.myapplication.domain.Genre;
import com.example.myapplication.domain.GenrePreference;
import com.example.myapplication.domain.Intensity;
import com.example.myapplication.domain.ManagementUser;
import com.example.myapplication.domain.Mood;
import com.example.myapplication.domain.Song;
import com.example.myapplication.domain.SongRating;
import com.example.myapplication.domain.User;
import com.example.myapplication.memorydao.SongDAO;
import com.example.myapplication.memorydao.SongRatingDAO;
import com.example.myapplication.memorydao.UserDAO;
import com.example.myapplication.util.PasswordProtector;
import com.example.myapplication.util.Statistics;

import java.util.ArrayList;

/**
 * Abstract class that initializes song, user and rating data
 */
public abstract class MemoryInitializerStub {

    /**
     * eraseAllData clears all users and songs lists
     */

    public abstract void eraseAllData();

    /**
     * prepareData creates management users, users, bands, songs and ratings and stores them in userDAO,
     * songDAO and songRatingDAO.
     * @throws InvalidDataException in case of wrong data given.
     */

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void prepareData() throws InvalidDataException {
        eraseAllData();

        ManagementUser managementUser1 = new ManagementUser("JohnDoe@gmail.com","JohnDoe",PasswordProtector.md5("111"),"responsible for adding and deleting app data",1);
        ManagementUser managementUser2 = new ManagementUser("JaneDoe@gmail.com","JaneDoe",PasswordProtector.md5("222"),"responsible for adding and deleting app data",2);
        getUserDAO().register(managementUser1);
        getUserDAO().register(managementUser2);

        Genre[] genres = {Genre.JAZZ, Genre.ROCK};
        GenrePreference gp =  new GenrePreference(genres);
        Band[] bands = new Band[5];
        Band band1 = new Band("Nirvana",3,Genre.ROCK);
        bands[0] = band1;
        Band band2 = new Band("U2",4,Genre.ROCK);
        bands[1] = band2;
        BandPreference bp =  new BandPreference(bands);
        User user1 = new User("John", "Somebody", "johnSomebody@gmail.com", "johnS", PasswordProtector.md5("js2000"), gp, bp);

        Genre[] genres2 = {Genre.JAZZ, Genre.ROCK};
        GenrePreference gp2 =  new GenrePreference(genres);
        Band[] bands2 = new Band[5];
        Band banda = new Band("Nirvana",3,Genre.ROCK);
        bands[0] = banda;
        Band bandb = new Band("U2",4,Genre.ROCK);
        bands[1] = bandb;
        BandPreference bp2 =  new BandPreference(bands);
        User user2 = new User("Jacob", "Else", "jacobElse@gmail.com", "jacobE", PasswordProtector.md5("je1999"), gp2, bp2);

        getUserDAO().register(user1);
        getUserDAO().register(user2);

        Band bandaki1 = new Band("Aerosmith", 5, Genre.ROCK);
        Song song1 = new Song("Dream On", Genre.ROCK, 1973, bandaki1,"https://youtu.be/twPtvZuBrAg",1);
        getSongDAO().save(song1);

        Band bandaki2 = new Band("ABBA", 4, Genre.DISCO);
        Song song2 = new Song("Dancing Queen", Genre.DISCO, 1976, bandaki2,"https://youtu.be/3ij_pUtJJrw",2);
        getSongDAO().save(song2);

        Band bandaki3 = new Band("Blur", 4, Genre.POP);
        Song song3 = new Song("Girls And Boys", Genre.POP, 1994, bandaki3,"https://youtu.be/WDswiT87oo8",3);
        getSongDAO().save(song3);

        Band bandaki4 = new Band("Nina Simone", 1, Genre.JAZZ);
        Song song4 = new Song("Feeling Good", Genre.JAZZ, 1965, bandaki4,"https://youtu.be/D5Y11hwjMNs",4);
        getSongDAO().save(song4);

        Band bandaki5 = new Band("Eminem", 1, Genre.RAP);
        Song song5 = new Song("The Real Slim Shady", Genre.RAP, 2000, bandaki5,"https://youtu.be/eJO5HU_7_1w",5);
        getSongDAO().save(song5);

        Band bandaki6 = new Band("Tin Pan Alley (Cliff Friend and Dave Franklin)", 2, Genre.CLASSICAL);
        Song song6 = new Song("The Merry-Go-Round Broke Down", Genre.CLASSICAL, 1937, bandaki6,"https://youtu.be/oBgAHK36sx4",6);
        getSongDAO().save(song6);

        Band bandaki7 = new Band("La Femme", 7, Genre.POP);
        Song song7 = new Song("Mystere", Genre.POP, 2016, bandaki7,"https://youtu.be/jTMSguDFlMI",7);
        getSongDAO().save(song7);

        Band bandaki8 = new Band("Blondie", 6, Genre.ROCK);
        Song song8 = new Song("Heart Of Glass", Genre.ROCK, 1979, bandaki8,"https://youtu.be/WGU_4-5RaxU",8);
        getSongDAO().save(song8);

        Band bandaki9 = new Band("Nirvana",3,Genre.ROCK);
        Song song9 = new Song("Heart-Shaped Box", Genre.ROCK, 1993, bandaki9,"https://youtu.be/n6P0SitRwy8",9);
        getSongDAO().save(song9);

        Band bandaki10 = new Band("U2",4,Genre.ROCK);
        Song song10 = new Song("Where the streets have no name", Genre.ROCK, 1987, bandaki10,"https://youtu.be/GzZWSrr5wFI",10);
        getSongDAO().save(song10);

        Band bandaki11 = new Band("Red Hot Chili Peppers",4,Genre.ROCK);
        Song song11 = new Song("Dark necessities", Genre.ROCK, 2016, bandaki11,"https://youtu.be/qJ_Tw0w3lLA",11);
        getSongDAO().save(song11);

        Band bandaki12 = new Band("Linkin Park",6,Genre.ROCK);
        Song song12 = new Song("Burn it down", Genre.ROCK, 2012, bandaki12,"https://youtu.be/dxytyRy-O1k",12);
        getSongDAO().save(song12);

        Band bandaki13 = new Band("R.E.M",4,Genre.ROCK);
        Song song13 = new Song("Radio Free Europe", Genre.ROCK, 1981, bandaki13,"https://youtu.be/B7Dekd24kMM",13);
        getSongDAO().save(song13);

        Statistics.initialize();



        SongRating rating1 = new SongRating(song9);
        rating1.setMood(Mood.STRESSED);
        rating1.setActivity(Activity.NO_ACTIVITY);
        rating1.setIntensity(Intensity.MEDIUM);

        SongRating rating2 = new SongRating(song1);
        rating2.setMood(Mood.HAPPY);
        rating2.setActivity(Activity.WORKING_OUT);
        rating2.setIntensity(Intensity.MEDIUM);

        SongRating rating3 = new SongRating(song2);
        rating3.setMood(Mood.STRESSED);
        rating3.setActivity(Activity.PARTY);
        rating3.setIntensity(Intensity.HIGH);

        SongRating rating4 = new SongRating(song3);
        rating4.setMood(Mood.HAPPY);
        rating4.setActivity(Activity.PARTY);
        rating4.setIntensity(Intensity.MEDIUM);

        SongRating rating5 = new SongRating(song7);
        rating5.setMood(Mood.NOSTALGIC);
        rating5.setActivity(Activity.WORK);
        rating5.setIntensity(Intensity.LOW);

        SongRating rating6 = new SongRating(song4);
        rating6.setMood(Mood.CALM);
        rating6.setActivity(Activity.NO_ACTIVITY);
        rating6.setIntensity(Intensity.LOW);

        SongRating rating7 = new SongRating(song5);
        rating7.setMood(Mood.HAPPY);
        rating7.setActivity(Activity.PARTY);
        rating7.setIntensity(Intensity.HIGH);

        SongRating rating8 = new SongRating(song6);
        rating8.setMood(Mood.HAPPY);
        rating8.setActivity(Activity.STUDYING);
        rating8.setIntensity(Intensity.MEDIUM);

        SongRating rating9 = new SongRating(song8);
        rating9.setMood(Mood.HAPPY);
        rating9.setActivity(Activity.WORK);
        rating9.setIntensity(Intensity.MEDIUM);

        SongRating rating10 = new SongRating(song10);
        rating10.setMood(Mood.SAD);
        rating10.setActivity(Activity.NO_ACTIVITY);
        rating10.setIntensity(Intensity.LOW);

        SongRating rating11 = new SongRating(song11);
        rating11.setMood(Mood.CALM);
        rating11.setActivity(Activity.WORKING_OUT);
        rating11.setIntensity(Intensity.LOW);

        SongRating rating12 = new SongRating(song12);
        rating12.setMood(Mood.ANGRY);
        rating12.setActivity(Activity.WORKING_OUT);
        rating12.setIntensity(Intensity.MEDIUM);

        SongRating rating13 = new SongRating(song13);
        rating13.setMood(Mood.NOSTALGIC);
        rating13.setActivity(Activity.STUDYING);
        rating13.setIntensity(Intensity.LOW);

        SongRating rating14 = new SongRating(song9);
        rating14.setMood(Mood.STRESSED);
        rating14.setActivity(Activity.WORK);
        rating14.setIntensity(Intensity.LOW);

        SongRating rating15 = new SongRating(song1);
        rating15.setMood(Mood.STRESSED);
        rating15.setActivity(Activity.WORKING_OUT);
        rating15.setIntensity(Intensity.MEDIUM);

        SongRating rating16 = new SongRating(song2);
        rating16.setMood(Mood.STRESSED);
        rating16.setActivity(Activity.HOBBY);
        rating16.setIntensity(Intensity.LOW);

        SongRating rating17 = new SongRating(song3);
        rating17.setMood(Mood.NOSTALGIC);
        rating17.setActivity(Activity.NO_ACTIVITY);
        rating17.setIntensity(Intensity.LOW);

        SongRating rating18 = new SongRating(song7);
        rating18.setMood(Mood.CALM);
        rating18.setActivity(Activity.WORK);
        rating18.setIntensity(Intensity.MEDIUM);

        SongRating rating19 = new SongRating(song4);
        rating19.setMood(Mood.CALM);
        rating19.setActivity(Activity.NO_ACTIVITY);
        rating19.setIntensity(Intensity.LOW);

        SongRating rating20 = new SongRating(song5);
        rating20.setMood(Mood.ANGRY);
        rating20.setActivity(Activity.WORKING_OUT);
        rating20.setIntensity(Intensity.MEDIUM);

        SongRating rating21 = new SongRating(song6);
        rating21.setMood(Mood.SAD);
        rating21.setActivity(Activity.STUDYING);
        rating21.setIntensity(Intensity.LOW);

        SongRating rating22 = new SongRating(song8);
        rating22.setMood(Mood.CALM);
        rating22.setActivity(Activity.WORKING_OUT);
        rating22.setIntensity(Intensity.MEDIUM);

        SongRating rating23 = new SongRating(song10);
        rating23.setMood(Mood.NOSTALGIC);
        rating23.setActivity(Activity.STUDYING);
        rating23.setIntensity(Intensity.MEDIUM);

        SongRating rating24 = new SongRating(song11);
        rating24.setMood(Mood.HAPPY);
        rating24.setActivity(Activity.PARTY);
        rating24.setIntensity(Intensity.MEDIUM);

        SongRating rating25 = new SongRating(song12);
        rating25.setMood(Mood.STRESSED);
        rating25.setActivity(Activity.WORK);
        rating25.setIntensity(Intensity.HIGH);

        SongRating rating26 = new SongRating(song13);
        rating26.setMood(Mood.CALM);
        rating26.setActivity(Activity.WORKING_OUT);
        rating26.setIntensity(Intensity.MEDIUM);

        SongRating rating27 = new SongRating(song9);
        rating27.setMood(Mood.ANGRY);
        rating27.setActivity(Activity.WORKING_OUT);
        rating27.setIntensity(Intensity.MEDIUM);

        SongRating rating28 = new SongRating(song1);
        rating28.setMood(Mood.HAPPY);
        rating28.setActivity(Activity.WORKING_OUT);
        rating28.setIntensity(Intensity.MEDIUM);

        SongRating rating30 = new SongRating(song2);
        rating30.setMood(Mood.ANGRY);
        rating30.setActivity(Activity.STUDYING);
        rating30.setIntensity(Intensity.MEDIUM);

        SongRating rating31 = new SongRating(song3);
        rating31.setMood(Mood.HAPPY);
        rating31.setActivity(Activity.WORKING_OUT);
        rating31.setIntensity(Intensity.MEDIUM);

        SongRating rating32 = new SongRating(song7);
        rating32.setMood(Mood.CALM);
        rating32.setActivity(Activity.WORK);
        rating32.setIntensity(Intensity.MEDIUM);

        SongRating rating33 = new SongRating(song4);
        rating33.setMood(Mood.CALM);
        rating33.setActivity(Activity.HOBBY);
        rating33.setIntensity(Intensity.LOW);

        SongRating rating34 = new SongRating(song5);
        rating34.setMood(Mood.HAPPY);
        rating34.setActivity(Activity.PARTY);
        rating34.setIntensity(Intensity.HIGH);

        SongRating rating35 = new SongRating(song6);
        rating35.setMood(Mood.HAPPY);
        rating35.setActivity(Activity.HOBBY);
        rating35.setIntensity(Intensity.MEDIUM);

        SongRating rating36 = new SongRating(song8);
        rating36.setMood(Mood.HAPPY);
        rating36.setActivity(Activity.PARTY);
        rating36.setIntensity(Intensity.MEDIUM);

        SongRating rating37 = new SongRating(song10);
        rating37.setMood(Mood.NOSTALGIC);
        rating37.setActivity(Activity.STUDYING);
        rating37.setIntensity(Intensity.LOW);

        SongRating rating38 = new SongRating(song11);
        rating38.setMood(Mood.CALM);
        rating38.setActivity(Activity.WORK);
        rating38.setIntensity(Intensity.LOW);

        SongRating rating39 = new SongRating(song12);
        rating39.setMood(Mood.STRESSED);
        rating39.setActivity(Activity.NO_ACTIVITY);
        rating39.setIntensity(Intensity.MEDIUM);

        SongRating rating29 = new SongRating(song13);
        rating29.setMood(Mood.NOSTALGIC);
        rating29.setActivity(Activity.STUDYING);
        rating29.setIntensity(Intensity.LOW);

        getSongRatingDAO().save(rating1);
        getSongRatingDAO().save(rating2);
        getSongRatingDAO().save(rating3);
        getSongRatingDAO().save(rating4);
        getSongRatingDAO().save(rating5);
        getSongRatingDAO().save(rating6);
        getSongRatingDAO().save(rating7);
        getSongRatingDAO().save(rating8);
        getSongRatingDAO().save(rating9);
        getSongRatingDAO().save(rating10);
        getSongRatingDAO().save(rating11);
        getSongRatingDAO().save(rating12);
        getSongRatingDAO().save(rating13);
        getSongRatingDAO().save(rating14);
        getSongRatingDAO().save(rating15);
        getSongRatingDAO().save(rating16);
        getSongRatingDAO().save(rating17);
        getSongRatingDAO().save(rating18);
        getSongRatingDAO().save(rating19);
        getSongRatingDAO().save(rating20);
        getSongRatingDAO().save(rating21);
        getSongRatingDAO().save(rating22);
        getSongRatingDAO().save(rating23);
        getSongRatingDAO().save(rating24);
        getSongRatingDAO().save(rating25);
        getSongRatingDAO().save(rating26);
        getSongRatingDAO().save(rating27);
        getSongRatingDAO().save(rating28);
        getSongRatingDAO().save(rating29);
        getSongRatingDAO().save(rating30);
        getSongRatingDAO().save(rating31);
        getSongRatingDAO().save(rating32);
        getSongRatingDAO().save(rating33);
        getSongRatingDAO().save(rating34);
        getSongRatingDAO().save(rating35);
        getSongRatingDAO().save(rating36);
        getSongRatingDAO().save(rating37);
        getSongRatingDAO().save(rating38);
        getSongRatingDAO().save(rating39);


        ArrayList<SongRating> sr1 = new ArrayList<>();
        sr1.add(rating1);
        sr1.add(rating2);
        sr1.add(rating3);
        sr1.add(rating4);
        sr1.add(rating5);
        sr1.add(rating11);
        sr1.add(rating12);
        user1.setSongRatings(sr1);

        ArrayList<SongRating> sr2 = new ArrayList<>();
        sr2.add(rating6);
        sr2.add(rating7);
        sr2.add(rating8);
        sr2.add(rating9);
        sr2.add(rating10);
        sr2.add(rating13);
        user2.setSongRatings(sr2);
    }

    /**
     * getSongDAO
     * @return data related to all songs stored in songDAO.
     */
    public abstract SongDAO getSongDAO();

    /**
     * getSongRatingDAO
     * @return data related to all ratings stored in songRatingDAO.
     */

    public abstract SongRatingDAO getSongRatingDAO();

    /**
     * getUserDAO
     * @return data related to all users stored in userDAO.
     */

    public abstract UserDAO getUserDAO();

}
