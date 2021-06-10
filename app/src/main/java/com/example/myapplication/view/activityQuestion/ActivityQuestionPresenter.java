package com.example.myapplication.view.activityQuestion;


public class ActivityQuestionPresenter {
    ActivityQuestionView view;

    public ActivityQuestionPresenter(ActivityQuestionView view) {
        this.view = view;
    }

    public void onClickMusicSession(String activity) {
        view.handleMusicSession(activity);
    }

    void detach() {
        view = null;
    }

}
