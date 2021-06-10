package com.example.myapplication.view.search;

import com.example.myapplication.domain.Band;
import com.example.myapplication.domain.Genre;
import com.example.myapplication.domain.Song;
import com.example.myapplication.memorydao.SongDAO;
import com.example.myapplication.view.musicSession.MusicSessionPresenter;
import com.example.myapplication.view.musicSession.MusicSessionView;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SearchablePresenterTest {

    private SearchableView searchableView;
    private SongDAO songDAO;
    private SearchablePresenter presenterUnderTest;

    @Before
    public void setUp() throws Exception {
        searchableView = mock(SearchableView.class);
        songDAO = mock(SongDAO.class);
        presenterUnderTest = new SearchablePresenter(searchableView, songDAO);
    }

    @Test
    public void callOnFetchSongs() {
        Band band = new Band("U2",4, Genre.ROCK);
        Song song = new Song("Where the streets have no name", Genre.ROCK, 1987, band,"https://youtu.be/GzZWSrr5wFI",10);
        List<Song> allSongs = new ArrayList<>();
        allSongs.add(song);
        when(songDAO.findAll()).thenReturn(allSongs);
        presenterUnderTest.loadAllSongs("Where the streets have no name");
        verify(searchableView).onFetchSongs(allSongs);
    }

    @Test
    public void callNoResultsFound(){
        Band band = new Band("U2",4, Genre.ROCK);
        Song song = new Song("Where the streets have no name", Genre.ROCK, 1987, band,"https://youtu.be/GzZWSrr5wFI",10);
        List<Song> allSongs = new ArrayList<>();
        allSongs.add(song);
        when(songDAO.findAll()).thenReturn(allSongs);
        presenterUnderTest.loadAllSongs("Where the streets have nobody");
        verify(searchableView).noResultsFound();

    }
}