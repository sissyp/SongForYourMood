package com.example.myapplication.view.menu;

public class MenuPresenter {
    MenuView view;

    public MenuPresenter(MenuView view) {
        this.view = view;
    }

    public void onClickMusicSession() {
        view.handleMusicSession();
    }

    public void onClickSearch() {
        view.handleSearch();
    }

    public void onClickStatistics() {
        view.handleStatistics();
    }

    void detach() {
        view = null;
    }
}
