package com.example.myapplication.view.intensityQuestion;

public class IntensityQuestionPresenter {
    IntensityQuestionView view;

    public IntensityQuestionPresenter(IntensityQuestionView view) {
        this.view = view;
    }

    public void onClickActivityQuestion(String intensity) {
        view.handleActivityQuestion(intensity);
    }

    void detach() {
        view = null;
    }

}
