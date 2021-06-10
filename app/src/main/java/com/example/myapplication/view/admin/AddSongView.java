package com.example.myapplication.view.admin;


public interface AddSongView {

    void onSuccessfulAddition();

    int getId();

    void setId(int id);

    String getSongTitle();

    void setSongTitle(String title);

    String getGenre();

    void setGenre(String genre);

    int getProductionYear();

    void setProductionYear(int productionYear);

    String getBandName();

    void setBandName(String bandName);

    int getNumberOfBandMembers();

    void setNumberOfBandMembers(int numberOfMembers);

    String getBandGenre();

    void setBandGenre(String bandGenre);

    String getLink();

    void setLink(String link);

    void showEmptyOrWrongFieldsDetected();

    void showSongAlreadyExists();

}
