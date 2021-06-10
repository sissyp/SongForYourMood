package com.example.myapplication.domain;
import java.util.*;
import com.example.myapplication.InvalidDataException;

/**
 * Band refers to all data related to bands stored in the database and contains methods that manage them.
 */
public class Band {
    public String name;
    public int members;
    public Genre genre;
    public ArrayList<String> memberNames =  new ArrayList<String>();

    public Band(){

    }

    public Band(String name, int members, Genre genre){
        this.name = name;
        this.members = members;
        this.genre = genre;
    }

    public String getName(){
        return name;
    }

    public void setName(String n) throws InvalidDataException{
        if (n.isEmpty()) {
            throw new InvalidDataException("Invalid name");
        }
        name = n;
    }

    public int getMembers(){
        return members;
    }

    public void setMembers(int m) throws InvalidDataException{
        if (m <= 0) {
            throw new InvalidDataException("Invalid number for members");
        }
        members = m;
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

    public boolean checkForSoloArtist(){
        return members == 1;
    }

    public ArrayList<String> getMemberNames(){
        return memberNames;
    }

    public void setMemberNames(ArrayList<String> mem) throws InvalidDataException{
        if (mem.isEmpty()) {
            throw new InvalidDataException("Invalid member");
        }
        memberNames = mem;
        members = mem.size();
    }

    public static String printBandInfo(Band b){
        return "Band name: "+ b.name +"\n"+"Members: "+b.getMemberNames()+ "\n" +"Genre: "+ b.genre;
    }
}
