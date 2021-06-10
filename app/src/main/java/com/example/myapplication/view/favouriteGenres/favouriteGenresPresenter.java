package com.example.myapplication.view.favouriteGenres;

import com.example.myapplication.domain.Genre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class favouriteGenresPresenter {
    favouriteGenresView view;

    public favouriteGenresPresenter(favouriteGenresView view) {
        this.view = view;
    }

    public void loadAllGenres() {
        List<Genre> allGenres = new ArrayList<>(Arrays.asList(Genre.values()));
        view.onFetchGenres(allGenres);
    }

    public void onProcessCompleted() {

        List<Genre> allGenres = new ArrayList<>(Arrays.asList(Genre.values()));
        boolean genreExists = false;
        for(Genre g: allGenres){
            if(Genre.getGenreAsString(g).equals(view.getGenreTitle1())) {
                genreExists = true;
            }
        }

        if(!genreExists)
            view.showEmptyOrWrongFieldsDetected();
        else{
            for(Genre g: allGenres){
                if(Genre.getGenreAsString(g).equals(view.getGenreTitle2()))
                    genreExists = false;
            }
            if(genreExists)
                view.showEmptyOrWrongFieldsDetected();
            else
                view.onSuccessfullyCompletedProcess(view.getGenreTitle1(),view.getGenreTitle2());
        }
    }
}
