package com.example.myapplication.view.favouriteBands;

import com.example.myapplication.domain.Band;
import com.example.myapplication.domain.Song;
import com.example.myapplication.memorydao.SongDAO;

import java.util.ArrayList;
import java.util.List;


public class favouriteBandsPresenter {

    favouriteBandsView view;
    SongDAO songDAO;

    public favouriteBandsPresenter(favouriteBandsView view, SongDAO songDAO) {
        this.view = view;
        this.songDAO = songDAO;
    }

    public void loadAllBands() {
        List<Song> allSongs = songDAO.findAll();
        List<Band> allBands = new ArrayList<>();
        for(Song s : allSongs){
            if(!allBands.contains(s.getBand())){
                allBands.add(s.getBand());
            }
        }
        view.onFetchBands(allBands);
    }

    public void onProcessCompleted() {

        List<Song> allSongs = songDAO.findAll();
        List<Band> allBands = new ArrayList<>();
        for(Song s : allSongs){
            if(!allBands.contains(s.getBand())){
                allBands.add(s.getBand());
            }
        }
        boolean bandExists = false;
        for(Band b: allBands){
            if(b.getName().equals(view.getBandTitle1())) {
                bandExists = true;
            }
        }

        if(!bandExists)
            view.showEmptyOrWrongFieldsDetected();
        else{
            for(Band b: allBands){
                if(b.getName().equals(view.getBandTitle2()))
                    bandExists = false;
            }
            if(bandExists)
                view.showEmptyOrWrongFieldsDetected();
            else
                view.onSuccessfullyCompletedProcess(view.getBandTitle1(),view.getBandTitle2());
        }
    }
}
