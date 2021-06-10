package com.example.myapplication.view.genreQuestion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.myapplication.InvalidDataException;
import com.example.myapplication.R;
import com.example.myapplication.databinding.LayoutActivityGenreQuestionBinding;
import com.example.myapplication.domain.Genre;
import com.example.myapplication.view.intensityQuestion.IntensityQuestionActivity;
import com.example.myapplication.view.moodQuestion.MoodQuestionActivity;
import com.example.myapplication.view.musicSession.MusicSessionActivity;

public class GenreQuestionActivity extends AppCompatActivity implements GenreQuestionView {
    LayoutActivityGenreQuestionBinding binding;
    GenreQuestionPresenter presenter;
    String mood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Genre Question");
        binding = DataBindingUtil.setContentView(this, R.layout.layout_activity_genre_question);
        presenter = new GenreQuestionPresenter(this);
        Bundle extras = getIntent().getExtras();
        mood = extras.getString("mood");
        String text = "         \n        Which genre would you prefer?";
        binding.textView.setText(text);

        setClickListeners();
    }

    private void setClickListeners() {
        binding.jazzBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.onClickIntensityQuestion("jazz");
            }
        });

        binding.rockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.onClickIntensityQuestion("rock");
            }
        });

        binding.popBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.onClickIntensityQuestion("pop");
            }
        });
        binding.discoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.onClickIntensityQuestion("disco");
            }
        });
        binding.rapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.onClickIntensityQuestion("rap");
            }
        });
        binding.classicalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.onClickIntensityQuestion("classical");
            }
        });
    }

    @Override
    public void handleIntensityQuestion(String genre) {
        Intent intent = new Intent(GenreQuestionActivity.this, IntensityQuestionActivity.class);
        intent.putExtra("mood", mood);
        intent.putExtra("genre",genre);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
