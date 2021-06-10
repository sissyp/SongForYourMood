package com.example.myapplication.domain;
import com.example.myapplication.InvalidDataException;

/**
 * GenrePreference is responsible for storing the favourite genres of a specific user.
 */

public class GenrePreference {
    private Genre[] favouriteGenres = new Genre[5];

    public GenrePreference(){

    }

    public GenrePreference(Genre[] genreArray){
        this.favouriteGenres = genreArray;
    }

    public void add(Genre g) throws InvalidDataException{
        if (findEmptyCellIndex() < 0) {
            throw new InvalidDataException("Array is full");
        }
        else
            favouriteGenres[findEmptyCellIndex()] = g;

    }

    public int findEmptyCellIndex(){
        int index = -1;
        for (int i = 0; i <5; i++){
            if (favouriteGenres[i] == null){
                index = i;
                break;
            }
        }
        return index;
    }

    public Genre[] getFavouriteGenres(){
        return favouriteGenres;
    }

    public void print(){
        for (int i = 0; i <5; i++)
            Genre.getGenreAsString(favouriteGenres[i]);
    }
}
