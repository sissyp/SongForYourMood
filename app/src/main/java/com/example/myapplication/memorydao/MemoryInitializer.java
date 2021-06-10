package com.example.myapplication.memorydao;
import com.example.myapplication.dao.MemoryInitializerStub;
import com.example.myapplication.domain.MusicSession;
import com.example.myapplication.domain.Song;
import com.example.myapplication.domain.SongRating;
import com.example.myapplication.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * MemoryInitializer is responsible for initializing song, user and rating data.
 */

public class MemoryInitializer extends MemoryInitializerStub {

    /**
     * eraseAllData clears all users and songs lists
     */

    @Override
    public void eraseAllData() {
        ArrayList<MusicSession> ms = new ArrayList<>();
        ArrayList<SongRating> sr = new ArrayList<>();
        for (User u : UserDAO.usersList){
            u.setMusicSessions(ms);
            u.setSongRatings(sr);
            u.setBandPreference(null);
            u.setGenrePreference(null);
        }
        UserDAO.usersList.clear();
    }

    /**
     * getSongDAO
     * @return data related to all songs stored in songDAO.
     */

    @Override
    public SongDAO getSongDAO() {
        return new SongDAO();
    }

    /**
     * getSongRatingDAO
     * @return data related to all ratings stored in songRatingDAO.
     */

    @Override
    public SongRatingDAO getSongRatingDAO() {
        return new SongRatingDAO();
    }

    /**
     * getUserDAO
     * @return data related to all users stored in userDAO.
     */

    @Override
    public UserDAO getUserDAO() {
        return new UserDAO();
    }

}
