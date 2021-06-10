package com.example.myapplication.view.admin;

import com.example.myapplication.domain.Band;
import com.example.myapplication.domain.Genre;
import com.example.myapplication.domain.Song;
import com.example.myapplication.memorydao.SongDAO;

public class AddSongPresenter {

    AddSongView view;
    SongDAO songDAO;

    public AddSongPresenter(AddSongView view, SongDAO songDAO) {
        this.view = view;
        this.songDAO = songDAO;
    }

    public void onAddSong() {

        if (view.getId() <= 0 || view.getProductionYear() <= 0 || view.getLink().isEmpty() || view.getBandGenre().isEmpty()
        || view.getNumberOfBandMembers() <= 0 || view.getBandName().isEmpty() || view.getSongTitle().isEmpty() || view.getGenre().isEmpty()){
            view.showEmptyOrWrongFieldsDetected();
            return;
        }

        if (songDAO.findSongTitle(view.getSongTitle()) != null) {
            view.showSongAlreadyExists();
            return;
        }
        if(Genre.isAvailable(view.getBandGenre()) && Genre.isAvailable(view.getGenre())) {
            Genre bandGenre = Genre.valueOf(view.getBandGenre().toUpperCase());
            Band band = new Band(view.getBandName(), view.getNumberOfBandMembers(), bandGenre);

            Genre genre = Genre.valueOf(view.getGenre().toUpperCase());

            Song song = new Song(view.getSongTitle(),genre,view.getProductionYear(),band,view.getLink(), view.getId());
            songDAO.save(song);
            view.onSuccessfulAddition();
        }
        else {
            view.showEmptyOrWrongFieldsDetected();
        }

    }

    void detach() {
        view = null;
    }
}
