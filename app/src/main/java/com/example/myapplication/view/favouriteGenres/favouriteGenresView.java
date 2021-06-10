package com.example.myapplication.view.favouriteGenres;

import com.example.myapplication.domain.Genre;

import java.util.List;

public interface favouriteGenresView {

    void onFetchGenres(List<Genre> genreList);

    String getGenreTitle1();

    void setGenreTitle1(String title);

    String getGenreTitle2();

    void setGenreTitle2(String title);

    void onSuccessfullyCompletedProcess(String genre1, String genre2);

    void showEmptyOrWrongFieldsDetected();
}
