package com.example.myapplication.memorydao;
import com.example.myapplication.dao.SongRatingDAOStub;
import com.example.myapplication.domain.Song;
import com.example.myapplication.domain.SongRating;
import java.util.ArrayList;
import java.util.List;

/**
 * SongRatingDAO represents the ratings' database
 */

public class SongRatingDAO implements SongRatingDAOStub {

    protected static List<SongRating> songRatingList = new ArrayList<>();
    public SongRatingDAO() {
    }

    /**
     * find searches ratings and returns the ones that refer to the specific song.
     * @param songId is the id of the given song.
     * @return an arraylist containing all the ratings of song with id = songId.
     */

    @Override
    public ArrayList<SongRating> find(int songId) {
        ArrayList<SongRating> songRatings = new ArrayList<>();
        for (SongRating s : songRatingList) {
            if (s.getSong().getSongId() == songId) songRatings.add(s);
        }
        return songRatings;
    }

    /**
     * save stores a rating in the database.
     * @param rating is the rating to be stored.
     */

    @Override
    public void save(SongRating rating) {
        songRatingList.add(rating);
    }

    /**
     * delete erases a rating from the database.
     * @param rating is the rating to be deleted.
     */

    @Override
    public void delete(SongRating rating) {
        songRatingList.remove(rating);
    }

}