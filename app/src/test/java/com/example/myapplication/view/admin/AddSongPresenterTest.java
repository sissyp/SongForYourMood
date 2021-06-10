package com.example.myapplication.view.admin;

import com.example.myapplication.domain.Band;
import com.example.myapplication.domain.Genre;
import com.example.myapplication.domain.Song;
import com.example.myapplication.memorydao.SongDAO;

import org.junit.Test;
import org.junit.Before;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class AddSongPresenterTest {

    private AddSongView addSongView;
    private SongDAO songDAO;
    private AddSongPresenter presenterUnderTest;

    @Before
    public void setUp() throws Exception {
        addSongView = mock(AddSongView.class);
        songDAO = mock(SongDAO.class);
        presenterUnderTest = new AddSongPresenter(addSongView, songDAO);
    }

    @Test
    public void shouldCallShowEmptyOrWrongFieldsDetected() {
        when(addSongView.getSongTitle()).thenReturn("");
        presenterUnderTest.onAddSong();
        verify(addSongView).showEmptyOrWrongFieldsDetected();
    }

    @Test
    public void shouldCallShowSongAlreadyExists() {
        Band band = new Band("ABBA", 4, Genre.DISCO);
        Song song = new Song("Dancing Queen", Genre.DISCO, 1976, band,"https://youtu.be/3ij_pUtJJrw",2);
        when(addSongView.getId()).thenReturn(song.getId());
        when(addSongView.getProductionYear()).thenReturn(song.getProductionYear());
        when(addSongView.getSongTitle()).thenReturn(song.getTitle());
        when(addSongView.getLink()).thenReturn(song.getLink());
        when(addSongView.getBandGenre()).thenReturn(Genre.getGenreAsString(song.getBand().getGenre()));
        when(addSongView.getNumberOfBandMembers()).thenReturn(song.getBand().getMembers());
        when(addSongView.getBandName()).thenReturn(song.getBand().getName());
        when(addSongView.getGenre()).thenReturn(Genre.getGenreAsString(song.getGenre()));

        when(songDAO.findSongTitle(addSongView.getSongTitle())).thenReturn(song);
        presenterUnderTest.onAddSong();
        verify(addSongView).showSongAlreadyExists();
    }

    @Test
    public void shouldCallOnSuccessfulAddition() {
        Band band = new Band("ABBA", 4, Genre.DISCO);
        Song song = new Song("Dancing Queen", Genre.DISCO, 1976, band,"https://youtu.be/3ij_pUtJJrw",2);
        when(addSongView.getId()).thenReturn(song.getId());
        when(addSongView.getProductionYear()).thenReturn(song.getProductionYear());
        when(addSongView.getSongTitle()).thenReturn(song.getTitle());
        when(addSongView.getLink()).thenReturn(song.getLink());
        when(addSongView.getBandGenre()).thenReturn(Genre.getGenreAsString(song.getBand().getGenre()));
        when(addSongView.getNumberOfBandMembers()).thenReturn(song.getBand().getMembers());
        when(addSongView.getBandName()).thenReturn(song.getBand().getName());
        when(addSongView.getGenre()).thenReturn(Genre.getGenreAsString(song.getGenre()));

        when(songDAO.find(song.getSongId())).thenReturn(song);
        presenterUnderTest.onAddSong();
        verify(addSongView).onSuccessfulAddition();
    }

    @Test
    public void shouldCallShowWrongFieldsDetected() {
        Band band = new Band("ABBA", 4, Genre.DISCO);
        Song song = new Song("Dancing Queen", Genre.DISCO, 1976, band,"https://youtu.be/3ij_pUtJJrw",2);
        when(addSongView.getId()).thenReturn(song.getId());
        when(addSongView.getProductionYear()).thenReturn(song.getProductionYear());
        when(addSongView.getSongTitle()).thenReturn(song.getTitle());
        when(addSongView.getLink()).thenReturn(song.getLink());
        when(addSongView.getBandGenre()).thenReturn("hard rock");
        when(addSongView.getNumberOfBandMembers()).thenReturn(song.getBand().getMembers());
        when(addSongView.getBandName()).thenReturn(song.getBand().getName());
        when(addSongView.getGenre()).thenReturn(Genre.getGenreAsString(song.getGenre()));

        when(songDAO.find(song.getSongId())).thenReturn(song);
        presenterUnderTest.onAddSong();
        verify(addSongView).showEmptyOrWrongFieldsDetected();
    }




    @Test
    public void detach() {
    }
}