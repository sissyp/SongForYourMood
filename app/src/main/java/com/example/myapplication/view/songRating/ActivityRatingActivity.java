package com.example.myapplication.view.songRating;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.myapplication.R;
import com.example.myapplication.databinding.LayoutActivityActivityRatingBinding;


public class ActivityRatingActivity extends AppCompatActivity implements ActivityRatingView {
    LayoutActivityActivityRatingBinding binding;
    ActivityRatingPresenter presenter;
    String element1;
    String element2;
    int counter;
    String song;
    String mood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Activity Question");
        binding = DataBindingUtil.setContentView(this, R.layout.layout_activity_activity_rating);
        presenter = new ActivityRatingPresenter(this);
        Bundle extras = getIntent().getExtras();
        counter = extras.getInt("counter");
        mood = extras.getString("mood");
        song = extras.getString("song");
        element1 = extras.getString("element1");
        element2 = extras.getString("element2");
        String text = "           \n         You are currently rating: " + song +"\n         Pick an activity for this one";
        binding.textView.setText(text);

        setClickListeners();
    }

    private void setClickListeners() {
        binding.workBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickActivityRating("work");

            }

        });

        binding.hobbyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickActivityRating("hobby");

            }
        });

        binding.partyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickActivityRating("party");

            }
        });
        binding.workingOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickActivityRating("working_out");

            }
        });
        binding.noActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickActivityRating("no_activity");

            }
        });
        binding.studyingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.onClickActivityRating("studying");
            }
        });
    }


    @Override
    public void handleActivityRating(String activity) {
        Intent intent = new Intent(ActivityRatingActivity.this, IntensityRatingActivity.class);
        intent.putExtra("activity",activity);
        intent.putExtra("mood", mood);
        intent.putExtra("song",song);
        intent.putExtra("element1",element1);
        intent.putExtra("element2",element2);
        intent.putExtra("counter",(counter));
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

}
