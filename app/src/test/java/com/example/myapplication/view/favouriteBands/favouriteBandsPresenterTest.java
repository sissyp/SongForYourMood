package com.example.myapplication.view.favouriteBands;

import com.example.myapplication.domain.Band;
import com.example.myapplication.domain.Genre;
import com.example.myapplication.domain.Song;
import com.example.myapplication.memorydao.SongDAO;
import com.example.myapplication.view.admin.AddSongPresenter;
import com.example.myapplication.view.admin.AddSongView;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class favouriteBandsPresenterTest {

    private favouriteBandsView bandsView;
    private SongDAO songDAO;
    private favouriteBandsPresenter presenterUnderTest;

    @Before
    public void setUp() throws Exception {
        bandsView = mock(favouriteBandsView.class);
        songDAO = mock(SongDAO.class);
        presenterUnderTest = new favouriteBandsPresenter(bandsView, songDAO);
    }

    @Test
    public void loadAllBands() {

    }

    @Test
    public void callShowEmptyOrWrongFieldsDetectedForFirstBand() {
        when(bandsView.getBandTitle1()).thenReturn("metallica");
        presenterUnderTest.onProcessCompleted();
        verify(bandsView).showEmptyOrWrongFieldsDetected();
    }

    @Test
    public void callShowEmptyOrWrongFieldsDetectedForSecondBand() {
        when(bandsView.getBandTitle2()).thenReturn("");
        presenterUnderTest.onProcessCompleted();
        verify(bandsView).showEmptyOrWrongFieldsDetected();
    }

    @Test
    public void onProcessCompleted(){
        Band band1 = new Band("ABBA",4, Genre.ROCK);
        Band band2 = new Band("U2",4, Genre.ROCK);
        Song song1 = new Song("Dancing Queen", Genre.DISCO, 1976, band1,"https://youtu.be/3ij_pUtJJrw",2);
        Song song2 = new Song("Where the streets have no name", Genre.ROCK, 1987, band2,"https://youtu.be/GzZWSrr5wFI",10);
        List<Song> allSongs = new ArrayList<>();
        allSongs.add(song1);
        allSongs.add(song2);

        when(songDAO.findAll()).thenReturn(allSongs);
        when(bandsView.getBandTitle1()).thenReturn(song1.getBand().getName());
        when(bandsView.getBandTitle2()).thenReturn(song2.getBand().getName());
        presenterUnderTest.onProcessCompleted();
        verify(bandsView).onSuccessfullyCompletedProcess("ABBA","U2");
    }

}