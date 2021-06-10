package com.example.myapplication.domain;
import com.example.myapplication.InvalidDataException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Genre includes all the available options for genres and contains methods that manage them.
 */

public enum Genre {
    JAZZ("jazz"), ROCK("rock"), POP("pop"), DISCO("disco"), RAP("rap"), CLASSICAL("classical");
    String genre;
    Genre(){

    }
    Genre(String genre){
        this.genre = genre;
    }
    public void setGenre(String g) throws InvalidDataException{
        if (!isAvailable(g)) {
            throw new InvalidDataException("Invalid genre");
        }
        this.genre = g;
    }

    public static Genre[] getAvailableGenres(){
        Genre[] genres =  new Genre[6];
        int i = 0;
        for (Genre genre: Genre.values()) {
            genres[i] = genre;
            i++;
        }
        return genres;
    }

    public void showGenres(){
        System.out.println("Available Genres: ");
        for (Genre g:Genre.values()){
            System.out.print(g.name());
        }
    }

    public static String getGenreAsString(Genre genre){
        return genre.genre;
    }

    public static boolean isAvailable(String g){
        boolean found = false;
        for (Genre genre: Genre.values()) {
            if (genre.name().toLowerCase().equals(g)) {
                found = true;
                break;
            }
        }
        return found;
    }
}
