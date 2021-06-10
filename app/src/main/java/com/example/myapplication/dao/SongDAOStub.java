package com.example.myapplication.dao;
import com.example.myapplication.domain.Song;
import java.util.List;

/**
 * SongDAOStub is the interface of the songs' database
 */

public interface SongDAOStub {

    /**
     * find searches the list of all songs in order to find the one with id = songId
     * @param songId is the id of the specific song.
     * @return the song with the id given.
     */

    Song find(int songId);

    /**
     * findSongTitle searches the list of all songs in order to find the one with title given.
     * @param title is the title of the specific song.
     * @return the song with the title given.
     */

    Song findSongTitle(String title);

    /**
     * save stores a song in the database.
     * @param song is the song to be stored.
     */

    void save(Song song);

    /**
     * delete erases a song from the database.
     * @param songId is the id of the song we want to delete.
     */

    void delete(int songId);

    /**
     * findAll searches the database and returns all the available songs.
     * @return a list of all songs stored in the database.
     */

    List<Song> findAll();

    /**
     * nextId
     * @return the id of the next song.
     */

    int nextId();
}