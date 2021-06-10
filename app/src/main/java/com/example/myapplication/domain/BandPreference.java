package com.example.myapplication.domain;
import com.example.myapplication.InvalidDataException;

/**
 * BandPreference is responsible for storing the favourite bands of a specific user.
 */
public class BandPreference {
    private static Band[] favouriteBands = new Band[5];

    public BandPreference(){

    }

    public BandPreference(Band[] bandArray){
        this.favouriteBands = bandArray;
    }

    public void add(Band b) throws InvalidDataException{
        if (findEmptyCellIndex() < 0){
            throw new InvalidDataException("Array is full");
        }
        else {
            favouriteBands[findEmptyCellIndex()] = b;
        }

    }

    public static int findEmptyCellIndex(){
        int index = -1;
        for (int i = 0; i <5; i++){
            if (favouriteBands[i] == null){
                index = i;
                break;
            }
        }
        return index;
    }

    public Band[] getFavouriteBands(){
        return favouriteBands;
    }

    public void print(){
        for (int i = 0; i <5; i++)
            Band.printBandInfo(favouriteBands[i]);
    }
}
