package com.example.myapplication.domain;

import java.util.ArrayList;
import java.util.Arrays;
import com.example.myapplication.InvalidDataException;

/**
 * Mood includes all the available options for moods and contains methods that manage them.
 */

public enum Mood {
    HAPPY("happy"), SAD("sad"), ANGRY("angry"), NOSTALGIC("nostalgic"), STRESSED("stressed"), CALM("calm");
    String mood;

    Mood(){

    }

    Mood(String mood){
        this.mood = mood;
    }

    public static String getMoodAsString(Mood mood){
        return mood.mood;
    }

    public void setMood(String m) throws InvalidDataException{
        if (!isAvailable(m)) {
            throw new InvalidDataException("Invalid mood");
        }
        this.mood = m;
    }

    public static Mood[] getAvailableMoods(){
        Mood[] moods =  new Mood[6];
        int i = 0;
        for (Mood m: Mood.values()) {
            moods[i] = m;
            i++;
        }
        return moods;
    }

    public void showPossibleMoods(){
        System.out.println("Available Moods: ");
        for (Mood m:Mood.values()){
            System.out.print(m.name());
        }
    }

    public static boolean isAvailable(String md){
        boolean found = false;
        for (Mood m: Mood.values()) {
            if (m.name().toLowerCase().equals(md)) {
                found = true;
                break;
            }
        }
        return found;
    }
}