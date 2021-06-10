package com.example.myapplication.view.musicSession;

import com.example.myapplication.App;
import com.example.myapplication.domain.Activity;
import com.example.myapplication.domain.Genre;
import com.example.myapplication.domain.Intensity;
import com.example.myapplication.domain.Mood;
import com.example.myapplication.domain.Song;
import com.example.myapplication.memorydao.SongDAO;
import com.example.myapplication.util.Statistics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MusicSessionPresenter {
    MusicSessionView view;
    SongDAO songDAO;

    public MusicSessionPresenter(MusicSessionView view, SongDAO songDAO){
        this.view = view;
        this.songDAO = songDAO;
    }

    public void loadAllSongs(String mood, String genre,String intensity,String activity) {
        List<Song> songList= new ArrayList<>();
        List<Song> allSongs = songDAO.findAll();

        for(Song song : allSongs) {
            Statistics songStats = new Statistics(song);
            Statistics.initialize();
            int addSong = 1;

            if(Genre.getGenreAsString(song.getGenre()).equals(genre))
                addSong++;

            for (Map.Entry<String, Integer> s : songStats.calculateRatings(App.memoryInitializer.getSongRatingDAO()).entrySet()) {
                if (Mood.isAvailable(s.getKey().toLowerCase()) && ((s.getKey().toLowerCase()).equals(mood)))
                    addSong ++;

                if (Activity.isAvailable(s.getKey().toLowerCase()) && ((s.getKey().toLowerCase()).equals(activity)))
                    addSong ++;

                if (Intensity.isAvailable(s.getKey().toLowerCase()) && ((s.getKey().toLowerCase()).equals(intensity)))
                    addSong++;
            }

            if(addSong == 5)
                songList.add(song);
        }
        if(songList.isEmpty())
            view.noSongsMatch();
        else
            view.onFetchSongs(songList);
    }
}
