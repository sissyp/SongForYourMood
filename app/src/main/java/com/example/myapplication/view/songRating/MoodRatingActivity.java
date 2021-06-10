package com.example.myapplication.view.songRating;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.myapplication.App;
import com.example.myapplication.R;

import com.example.myapplication.databinding.LayoutActivityMoodRatingBinding;

public class MoodRatingActivity extends AppCompatActivity implements MoodRatingView {

    LayoutActivityMoodRatingBinding binding;
    MoodRatingPresenter presenter;
    String element1;
    String element2;
    int counter;
    String song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Mood Question");
        binding = DataBindingUtil.setContentView(this, R.layout.layout_activity_mood_rating);
        presenter = new MoodRatingPresenter(this, App.memoryInitializer.getSongDAO());
        Bundle extras = getIntent().getExtras();
        counter = extras.getInt("counter");
        element1 = extras.getString("element1");
        element2 = extras.getString("element2");
        if(counter == 1 || counter == 3)
            chooseSong(element1);
        else if(counter == 2 || counter == 4)
            chooseSong(element2);
        setClickListeners();
    }

    private void setClickListeners() {
        binding.happyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickMoodRating("happy");

            }

        });

        binding.sadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickMoodRating("sad");

            }
        });

        binding.stressedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickMoodRating("stressed");

            }
        });
        binding.nostalgicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickMoodRating("nostalgic");

            }
        });
        binding.angryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickMoodRating("angry");

            }
        });
        binding.calmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.onClickMoodRating("calm");
            }
        });
    }

    @Override
    public void chooseSong(String element){
        song = presenter.findSongForElement(element);
        String text = "         \n         Let's start !\n         You'll have to rate: " + song +"\n         Pick a mood for this one";
        binding.textView.setText(text);
    }

    @Override
    public void handleMoodRating(String mood) {

        Intent intent = new Intent(MoodRatingActivity.this, ActivityRatingActivity.class);
        intent.putExtra("mood", mood);
        intent.putExtra("song", song);
        intent.putExtra("element1", element1);
        intent.putExtra("element2", element2);
        intent.putExtra("counter", counter);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
