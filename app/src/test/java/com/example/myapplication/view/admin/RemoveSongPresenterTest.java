package com.example.myapplication.view.admin;

import com.example.myapplication.domain.Band;
import com.example.myapplication.domain.Genre;
import com.example.myapplication.domain.Song;
import com.example.myapplication.memorydao.SongDAO;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RemoveSongPresenterTest {

    private RemoveSongView removeSongView;
    private SongDAO songDAO;
    private RemoveSongPresenter presenterUnderTest;

    @Before
    public void setUp() throws Exception {
        removeSongView = mock(RemoveSongView.class);
        songDAO = mock(SongDAO.class);
        presenterUnderTest = new RemoveSongPresenter(removeSongView, songDAO);
    }

    @Test
    public void loadAllSongs() {
    }

    @Test
    public void onRemoveSong() {
        Band band = new Band("ABBA", 4, Genre.DISCO);
        Song song = new Song("Dancing Queen", Genre.DISCO, 1976, band,"https://youtu.be/3ij_pUtJJrw",2);

        when(removeSongView.getSongTitle()).thenReturn(song.getTitle());

        when(songDAO.findSongTitle(removeSongView.getSongTitle())).thenReturn(song);
        presenterUnderTest.onRemoveSong();
        verify(removeSongView).onSuccessRemove();

    }

    @Test
    public void onCallShowEmptyOrWrongFieldsDetected() {
        Song song = null;

        when(songDAO.findSongTitle(removeSongView.getSongTitle())).thenReturn(song);
        presenterUnderTest.onRemoveSong();
        verify(removeSongView).showEmptyOrWrongFieldsDetected();

    }


}