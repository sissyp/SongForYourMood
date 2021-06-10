package com.example.myapplication.dao;

import com.example.myapplication.domain.SongRating;

import java.util.ArrayList;

/**
 * SongRatingDAOStub is the interface of the ratings' database
 */

public interface SongRatingDAOStub {

    /**
     * find searches ratings and returns the ones that refer to the specific song.
     * @param songId is the id of the given song.
     * @return an arraylist containing all the ratings of song with id = songId.
     */

    ArrayList<SongRating> find(int songId);

    /**
     * save stores a rating in the database.
     * @param rating is the rating to be stored.
     */

    void save(SongRating rating);

    /**
     * delete erases a rating from the database.
     * @param rating is the rating to be deleted.
     */

    void delete(SongRating rating);
}
