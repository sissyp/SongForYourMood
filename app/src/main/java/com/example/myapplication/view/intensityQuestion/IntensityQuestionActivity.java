package com.example.myapplication.view.intensityQuestion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;


import com.example.myapplication.R;
import com.example.myapplication.databinding.LayoutActivityIntensityRatingBinding;
import com.example.myapplication.view.activityQuestion.ActivityQuestionActivity;


public class IntensityQuestionActivity extends AppCompatActivity implements IntensityQuestionView {
    LayoutActivityIntensityRatingBinding binding;
    IntensityQuestionPresenter presenter;
    String mood;
    String genre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Intensity Question");
        binding = DataBindingUtil.setContentView(this, R.layout.layout_activity_intensity_rating);
        presenter = new IntensityQuestionPresenter(this);
        Bundle extras = getIntent().getExtras();
        mood = extras.getString("mood");
        genre = extras.getString("genre");

        String text = "         \n        Which of the following intensity levels "+"         \n        would you prefer?";
        binding.textView.setText(text);

        setClickListeners();
    }

    private void setClickListeners() {
        binding.lowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.onClickActivityQuestion("low");
            }
        });

        binding.mediumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.onClickActivityQuestion("medium");
            }
        });

        binding.highBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.onClickActivityQuestion("high");
            }
        });
    }

    @Override
    public void handleActivityQuestion(String intensity) {
        Intent intent = new Intent(IntensityQuestionActivity.this, ActivityQuestionActivity.class);
        intent.putExtra("mood", mood);
        intent.putExtra("genre",genre);
        intent.putExtra("intensity",intensity);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
