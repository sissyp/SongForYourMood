package com.example.myapplication.view.admin;

public class AdminPresenter{
    AdminView view;

    public AdminPresenter(AdminView view) {
        this.view = view;
    }

    public void onClickAddSong() {
        view.handleAddSong();
    }

    public void onClickRemoveSong() {
        view.handleRemoveSong();
    }

    void detach() {
        view = null;
    }

}
