package com.example.myapplication.view.favouriteGenres;

import com.example.myapplication.domain.Genre;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class favouriteGenresPresenterTest {

    private favouriteGenresView genresView;
    private favouriteGenresPresenter presenterUnderTest;

    @Before
    public void setUp() throws Exception {
        genresView = mock(favouriteGenresView.class);
        presenterUnderTest = new favouriteGenresPresenter(genresView);
    }

    @Test
    public void loadAllGenres() {
    }

    @Test
    public void callShowEmptyOrWrongFieldsDetectedForFirstGenre() {
        when(genresView.getGenreTitle1()).thenReturn("hip hop");
        presenterUnderTest.onProcessCompleted();
        verify(genresView).showEmptyOrWrongFieldsDetected();
    }

    @Test
    public void callShowEmptyOrWrongFieldsDetectedForSecondGenre() {
        when(genresView.getGenreTitle2()).thenReturn("");
        presenterUnderTest.onProcessCompleted();
        verify(genresView).showEmptyOrWrongFieldsDetected();
    }

    @Test
    public void onProcessCompleted(){
        Genre genre1 = Genre.POP;
        Genre genre2 = Genre.CLASSICAL;

        when(genresView.getGenreTitle1()).thenReturn(Genre.getGenreAsString(genre1));
        when(genresView.getGenreTitle2()).thenReturn(Genre.getGenreAsString(genre2));
        presenterUnderTest.onProcessCompleted();
        verify(genresView).onSuccessfullyCompletedProcess("pop","classical");
    }
}