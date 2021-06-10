package com.example.myapplication.view.songRating;


public class ActivityRatingPresenter {

    ActivityRatingView view;

    public ActivityRatingPresenter(ActivityRatingView view) {
        this.view = view;
    }

    public void onClickActivityRating(String activity) {
        view.handleActivityRating(activity);
    }

    void detach() {
        view = null;
    }
}
