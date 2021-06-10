package com.example.myapplication.domain;
import com.example.myapplication.InvalidDataException;

/**
 * interface used for genrePreference and BandPreference
 * @param <T> is a generic type.
 */
public interface Preference<T> {
    public void add(T p) throws InvalidDataException;

    public int findEmptyCellIndex();

    public void print();
}
