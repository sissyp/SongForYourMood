package com.example.myapplication.view.moodQuestion;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.myapplication.R;
import com.example.myapplication.databinding.LayoutActivityMoodRatingBinding;
import com.example.myapplication.view.genreQuestion.GenreQuestionActivity;

public class MoodQuestionActivity extends AppCompatActivity implements MoodQuestionView {
    LayoutActivityMoodRatingBinding binding;
    MoodQuestionPresenter presenter;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Mood Question");
        binding = DataBindingUtil.setContentView(this, R.layout.layout_activity_mood_rating);
        presenter = new MoodQuestionPresenter(this);
        String text = "         \n         Let's start !\n        Choose the option that best describes your mood!";
        binding.textView.setText(text);

        setClickListeners();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void setClickListeners() {
        binding.happyBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                presenter.onClickGenreQuestion("happy");

            }

        });

        binding.sadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickGenreQuestion("sad");

            }

        });

        binding.stressedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickGenreQuestion("stressed");

            }
        });
        binding.nostalgicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickGenreQuestion("nostalgic");

            }
        });
        binding.angryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickGenreQuestion("angry");

            }
        });
        binding.calmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.onClickGenreQuestion("calm");

            }
        });

    }


    @Override
    public void handleGenreQuestion(String mood) {
        Intent intent = new Intent(MoodQuestionActivity.this, GenreQuestionActivity.class);
        intent.putExtra("mood", mood);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
