package com.example.myapplication.view.activityQuestion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.myapplication.R;
import com.example.myapplication.databinding.LayoutActivityActivityRatingBinding;
import com.example.myapplication.view.musicSession.MusicSessionActivity;


public class ActivityQuestionActivity extends AppCompatActivity implements ActivityQuestionView {
    LayoutActivityActivityRatingBinding binding;
    ActivityQuestionPresenter presenter;
    String mood;
    String genre;
    String intensity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Activity Question");
        binding = DataBindingUtil.setContentView(this, R.layout.layout_activity_activity_rating);
        presenter = new ActivityQuestionPresenter(this);
        Bundle extras = getIntent().getExtras();
        mood = extras.getString("mood");
        genre = extras.getString("genre");
        intensity = extras.getString("intensity");

        String text = "         \n        Which of the following activities"+"         \n        are you going to do?";
        binding.textView.setText(text);

        setClickListeners();
    }

    private void setClickListeners() {
        binding.workBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.onClickMusicSession("work");
            }
        });

        binding.studyingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.onClickMusicSession("studying");
            }
        });

        binding.workingOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.onClickMusicSession("working_out");
            }
        });
        binding.partyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.onClickMusicSession("party");
            }
        });
        binding.hobbyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.onClickMusicSession("hobby");
            }
        });
        binding.noActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.onClickMusicSession("no_activity");
            }
        });
    }

    @Override
    public void handleMusicSession(String activity) {
        Intent intent = new Intent(ActivityQuestionActivity.this, MusicSessionActivity.class);
        intent.putExtra("mood", mood);
        intent.putExtra("genre",genre);
        intent.putExtra("intensity",intensity);
        intent.putExtra("activity",activity);

        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
