package com.example.myapplication.view.genreQuestion;

import com.example.myapplication.view.moodQuestion.MoodQuestionView;

public class GenreQuestionPresenter {
    GenreQuestionView view;

    public GenreQuestionPresenter(GenreQuestionView view) {
        this.view = view;
    }

    public void onClickIntensityQuestion(String genre) {
        view.handleIntensityQuestion(genre);
    }

    void detach() {
        view = null;
    }

}
