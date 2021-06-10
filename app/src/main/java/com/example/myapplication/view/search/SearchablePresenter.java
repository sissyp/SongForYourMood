package com.example.myapplication.view.search;

import com.example.myapplication.domain.Genre;
import com.example.myapplication.domain.Song;
import com.example.myapplication.memorydao.SongDAO;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SearchablePresenter {

    SearchableView view;
    SongDAO songDAO;

    public SearchablePresenter(SearchableView view, SongDAO songDAO) {
        this.view = view;
        this.songDAO = songDAO;
    }

    public void loadAllSongs(String query) {
        List<Song> songList= new ArrayList<>();
        List<Song> allSongs = songDAO.findAll();
        for(Song s: allSongs){
            if (query.equals(s.getTitle()))
                songList.add(s);
            else if (query.equals(s.getBand().getName()))
                songList.add(s);
            else if(query.equals(Genre.getGenreAsString(s.getGenre())))
                songList.add(s);
        }
        if(!songList.isEmpty())
            view.onFetchSongs(songList);
        else
            view.noResultsFound();
    }
}
