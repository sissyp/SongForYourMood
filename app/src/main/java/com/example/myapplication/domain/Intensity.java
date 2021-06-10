package com.example.myapplication.domain;

import java.util.ArrayList;
import java.util.Arrays;
import com.example.myapplication.InvalidDataException;

/**
 * Intensity includes all the available options for levels of intensity and contains methods that manage them.
 */

public enum Intensity {
    HIGH("high"), MEDIUM("medium"), LOW("low");
    String intensity;

    Intensity(){

    }

    Intensity(String intensity){
        this.intensity = intensity;
    }

    public static String getIntensityAsString(Intensity intensity){
        return intensity.intensity;
    }

    public void setIntensity(String i) throws InvalidDataException{
        if (!isAvailable(i)) {
            throw new InvalidDataException("Invalid intensity");
        }
        this.intensity = i;
    }

    public static Intensity[] getIntensityLevels(){
        Intensity[] levels =  new Intensity[3];
        int i = 0;
        for (Intensity lev: Intensity.values()) {
            levels[i] = lev;
            i++;
        }
        return levels;
    }

    public void showIntensityOptions(){
        System.out.println("Available Intensities: ");
        for (Intensity l:Intensity.values()){
            System.out.print(l.name());
        }
    }

    public static boolean isAvailable(String intensity){
        boolean found = false;
        for (Intensity lev: Intensity.values()) {
            if (lev.name().toLowerCase().equals(intensity)) {
                found = true;
                break;
            }
        }
        return found;
    }
}
