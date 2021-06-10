package com.example.myapplication.view.moodQuestion;

import com.example.myapplication.view.menu.MenuView;

public class MoodQuestionPresenter {
    MoodQuestionView view;

    public MoodQuestionPresenter(MoodQuestionView view) {
        this.view = view;
    }

    public void onClickGenreQuestion(String mood) {
        view.handleGenreQuestion(mood);
    }

    void detach() {
        view = null;
    }

}
