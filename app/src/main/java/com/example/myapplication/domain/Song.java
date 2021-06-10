package com.example.myapplication.domain;
import com.example.myapplication.InvalidDataException;

/**
 * Song processes information about songs stored in the database
 */

public class Song {
    private int id ;
    private String title;
    private Genre genre;
    private int productionYear;
    private Band band;
    private String duration;
    private String link;

    public Song(int id){
        this.id = id;
    }

    public Song(String title,int id){
        this.id =id;
        this.title = title;
    }

    public Song(String title, String link, int id){
        this.id = id;
        this.title = title;
        this.link = link;
    }

    public Song(String title, Genre genre, int productionYear, Band band, String link,int id){
        this.id =id;
        this.title = title;
        this.genre = genre;
        this.productionYear = productionYear;
        this.band = band;
        this.link = link;
    }

    public int getSongId(){
        return id;
    }

    public void setSongId(int id){
        this.id = id;
    }

    public String getLink(){
        return link;
    }

    public void setLink(String l) throws InvalidDataException{
        if (l.isEmpty()) {
            throw new InvalidDataException("Invalid link");
        }
        link = l;
    }


    public String getTitle(){
        return title;
    }

    public void setTitle(String t) throws InvalidDataException{
        if (t.isEmpty() || hasTitle()) {
            throw new InvalidDataException("Invalid title");
        }
        title = t;
    }

    public boolean hasTitle(){
        return !title.isEmpty();
    }

    public Genre getGenre(){
        return genre;
    }

    public void setGenre(Genre g) throws InvalidDataException{
        if (!Genre.isAvailable(Genre.getGenreAsString(g))) {
            throw new InvalidDataException("Invalid genre");
        }
        genre = g;
    }

    public int getProductionYear(){
        return productionYear;
    }

    public void setProductionYear(int year) throws InvalidDataException{
        if (year < 0) {
            throw new InvalidDataException("Invalid year");
        }
        productionYear = year;
    }

    public Band getBand(){
        return band;
    }

    public void setBand(Band b) throws InvalidDataException{
        if (b.name.isEmpty()) {
            throw new InvalidDataException("Invalid band");
        }
        band = b;
    }

    public String getDuration(){
        return duration;
    }

    public void setDuration(String dur) {
        duration = dur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
