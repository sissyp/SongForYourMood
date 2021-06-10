package com.example.myapplication.memorydao;

import com.example.myapplication.dao.SongDAOStub;
import com.example.myapplication.domain.Song;

import java.util.ArrayList;
import java.util.List;

/**
 * SongDAOS represents the songs' database
 */

public class SongDAO implements SongDAOStub {
    protected static List<Song> songList = new ArrayList<>();
    private static int userIdCounter = 0;

    /**
     * SongDAO empty constructor.
     */

    public SongDAO() {
    }

    /**
     * find searches the list of all songs in order to find the one with id = songId
     * @param songId is the id of the specific song.
     * @return the song with the id given.
     */

    @Override
    public Song find(int songId) {
        for (Song s : songList) {
            if (s.getSongId() == songId) return s;
        }
        return null;
    }

    /**
     * findSongTitle searches the list of all songs in order to find the one with title given.
     * @param title is the title of the specific song.
     * @return the song with the title given.
     */

    @Override
    public Song findSongTitle(String title) {
        for (Song s : songList) {
            if (s.getTitle().equals(title)) return s;
        }
        return null;
    }

    /**
     * save stores a song in the database.
     * @param song is the song to be stored.
     */

    @Override
    public void save(Song song) {
        delete(song.getSongId());
        song.setSongId(nextId());
        songList.add(song);
    }

    /**
     * delete erases a song from the database.
     * @param songId is the id of the song we want to delete.
     */

    @Override
    public void delete(int songId) {
        for (Song s : songList) {
            if (s.getSongId() == songId) {
                songList.remove(s);
                break;
            }
        }
    }

    /**
     * findAll searches the database and returns all the available songs.
     * @return a list of all songs stored in the database.
     */

    @Override
    public List<Song> findAll() {
        return new ArrayList<>(songList);
    }

    /**
     * nextId
     * @return the id of the next song.
     */

    @Override
    public int nextId() {
        userIdCounter++;
        return userIdCounter;
    }
}
